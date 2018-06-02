package ar.com.melitest.forecast.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.melitest.forecast.dto.SimpleForecast;
import ar.com.melitest.forecast.model.Forecast;
import ar.com.melitest.forecast.repository.ForecastRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ForecastApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getClimaTest() throws Exception {
    	
    	SimpleForecast result = this.restTemplate.getForObject("http://localhost:" + port + "/ForecastApi/clima?dia=78",SimpleForecast.class);
    	
        assertThat(result.getDay()).isEqualTo(78);
        assertThat(result.getForecast()).isEqualTo("Lluvia");
    }
}
