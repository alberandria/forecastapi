package ar.com.melitest.forecast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"ar.com.melitest.forecast"})
public class ForecastApiApp {

	public static void main(String[] args) {
		SpringApplication.run(ForecastApiApp.class, args);
	}
	

    
}
