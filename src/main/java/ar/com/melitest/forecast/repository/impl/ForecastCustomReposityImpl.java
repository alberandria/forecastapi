package ar.com.melitest.forecast.repository.impl;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.com.melitest.forecast.model.Forecast;
import ar.com.melitest.forecast.repository.ForecastCustomRepository;

@Repository
@Transactional(readOnly = true)
public class ForecastCustomReposityImpl implements ForecastCustomRepository{

    @PersistenceContext
    EntityManager entityManager;
    
	@Override
	public Forecast findByDay(int day) {
		Query query = entityManager.createNativeQuery("SELECT * FROM forecast WHERE day=?", Forecast.class);
        query.setParameter(1, day);
        return (Forecast) query.getSingleResult();
	}
}
