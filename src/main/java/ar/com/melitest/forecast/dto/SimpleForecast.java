package ar.com.melitest.forecast.dto;

public class SimpleForecast {
	int day;
	String forecast;
	
	public SimpleForecast(int day, String forecast) {
		super();
		this.day = day;
		this.forecast = forecast;
	}
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
	
}
