package ar.com.melitest.forecast.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forecast {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
    private Integer day;
    private String forecast;
    private Integer degVulcano;
    private Integer degBetasoide;
    private Integer degFerengi;
    private Double areaTriangle;
	
	public Forecast(){
			
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public Integer getDegVulcano() {
		return degVulcano;
	}

	public void setDegVulcano(Integer degVulcano) {
		this.degVulcano = degVulcano;
	}

	public Integer getDegBetasoide() {
		return degBetasoide;
	}

	public void setDegBetasoide(Integer degBetasoide) {
		this.degBetasoide = degBetasoide;
	}

	public Integer getDegFerengi() {
		return degFerengi;
	}

	public void setDegFerengi(Integer degFerengi) {
		this.degFerengi = degFerengi;
	}

	public Double getAreaTriangle() {
		return areaTriangle;
	}

	public void setAreaTriangle(Double areaTriangle) {
		this.areaTriangle = areaTriangle;
	}
	
	
}