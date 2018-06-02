package ar.com.melitest.forecast.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.melitest.forecast.model.Forecast;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ForecastRepositoryTest {
    @Autowired
    private ForecastRepository forecastRepository;
    
    @Test
    public void whenFindByDay_thenReturnForecast() {
        Forecast forecast = new Forecast();
        forecast.setDay(23);
        forecast.setDegBetasoide(10);
        forecast.setDegVulcano(10);
        forecast.setDegFerengi(10);
        forecast.setAreaTriangle(30d);
        forecast.setForecast("Lluvia");
        forecastRepository.save(forecast);
     
        Forecast found = forecastRepository.findByDay(23);
     
        assertThat(found.getForecast()).isEqualTo(forecast.getForecast());
    }
}
