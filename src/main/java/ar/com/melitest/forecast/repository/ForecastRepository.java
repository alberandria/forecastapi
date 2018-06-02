package ar.com.melitest.forecast.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.melitest.forecast.model.Forecast;

@Repository
public interface ForecastRepository extends CrudRepository<Forecast, Integer>, ForecastCustomRepository{

}
