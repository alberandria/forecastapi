package ar.com.melitest.forecast.repository;

import ar.com.melitest.forecast.model.Forecast;

public interface ForecastCustomRepository {
	Forecast findByDay(int day);
}
