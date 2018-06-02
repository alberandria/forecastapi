package ar.com.melitest.forecast.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.melitest.forecast.dto.SimpleForecast;
import ar.com.melitest.forecast.model.Forecast;
import ar.com.melitest.forecast.repository.ForecastRepository;

@RestController
@RequestMapping("/")
public class ForecastApiController {

	public static final Logger logger = LoggerFactory.getLogger(ForecastApiController.class);
    
	@Autowired
	private ForecastRepository forecastRepository;
		
	@RequestMapping(value = "clima", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SimpleForecast> getPronostico(@RequestParam("dia") Integer day) {
		if(day == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		Forecast forecast = forecastRepository.findByDay(day);
		if(forecast == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(new SimpleForecast(day, forecast.getForecast()));
	}	
}