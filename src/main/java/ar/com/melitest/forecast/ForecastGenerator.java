package ar.com.melitest.forecast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import ar.com.melitest.forecast.domain.Betasoide;
import ar.com.melitest.forecast.domain.Ferengi;
import ar.com.melitest.forecast.domain.Position;
import ar.com.melitest.forecast.domain.Vulcano;
import ar.com.melitest.forecast.model.Forecast;
import ar.com.melitest.forecast.repository.ForecastRepository;

@Component
public class ForecastGenerator implements ApplicationListener<ContextRefreshedEvent> {
	
	public static final Logger logger = LoggerFactory.getLogger(ForecastGenerator.class);
	
	@Autowired
	private ForecastRepository forecastRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		Ferengi ferengi = new Ferengi();
		Betasoide betasoide = new Betasoide();
		Vulcano vulcano = new Vulcano();

		int countDrought = 0;
		int countNormal = 0;
		int countRain = 0;
		int countOptimunPres = 0;
		double maxArea = 0;
		int maxRain = 0;
		for (int i = 1; i < 3651; i++) {
			Forecast forecast = new Forecast();
			forecast.setDay(i);
			forecast.setDegVulcano(vulcano.advanceOneDay());
			forecast.setDegFerengi(ferengi.advanceOneDay());
			forecast.setDegBetasoide(betasoide.advanceOneDay());
			double areaTriang = calculateAreaTrig(ferengi.getPosition(), betasoide.getPosition(),
					vulcano.getPosition());

			forecast.setAreaTriangle(areaTriang);
			if (areaTriang == 0) {

				Position a = ferengi.getPosition();
				Position b = betasoide.getPosition();
				double slope = (b.getY() - a.getY()) / (b.getX() - a.getX());

				if (slope == Double.POSITIVE_INFINITY || slope == Double.NEGATIVE_INFINITY
						|| (0 - b.getY()) == slope * (0 - b.getX())) {
					countDrought++;
					forecast.setForecast("Sequia");
				} else {
					countOptimunPres++;
					forecast.setForecast("Condiciones Optimas de Presión y Temperatura");
				}
			} else {
				if (isPointInsideTriangle(new Position(), ferengi.getPosition(), betasoide.getPosition(),
						vulcano.getPosition())) {
					if (areaTriang > maxArea) {
						maxArea = areaTriang;
						maxRain = i;
					}
					forecast.setForecast("Lluvia");
					countRain++;
				} else {
					forecast.setForecast("Normal");
					countNormal++;
				}
			}

			forecastRepository.save(forecast);
		}

		logger.info("Periodos Sequia:" + countDrought);
		logger.info("Periodos Optima Presion:" + countOptimunPres);
		logger.info("Periodos Lluvia:" + countRain);
		logger.info("Periodos Normal:" + countNormal);
		logger.info("Dia de Mas lluvia: " + maxRain);

	}

	private double calculateAreaTrig(Position a, Position b, Position c) {
		double areaTrig = Math.abs(((a.getX() * (b.getY() - c.getY())) + (b.getX() * (c.getY() - a.getY()))
				+ (c.getX() * (a.getY() - b.getY()))) / 2);
		return areaTrig;
	}

	private boolean isPointInsideTriangle(Position s, Position a, Position b, Position c) {
		double auxX = s.getX() - a.getX();
		double auxY = s.getY() - a.getY();
		boolean auxAB = (b.getX() - a.getX()) * auxY - (b.getY() - a.getY()) * auxX > 0;
		if ((c.getX() - a.getX()) * auxY - (c.getY() - a.getY()) * auxX > 0 == auxAB)
			return false;
		if ((c.getX() - b.getX()) * (s.getY() - b.getY()) - (c.getY() - b.getY()) * (s.getX() - b.getX()) > 0 != auxAB)
			return false;
		return true;
	}

}
