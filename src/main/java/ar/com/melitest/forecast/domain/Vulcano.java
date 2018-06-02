package ar.com.melitest.forecast.domain;

public class Vulcano extends Planet {
	
	public Vulcano() {
		this.setDegree(0);
		this.setAngularSpeed(5);
		this.setOrbitRadius(1000);
	}
	
	@Override
	public int advanceOneDay() {
		int degree = this.getDegree();
		degree+=this.getAngularSpeed();
		if(degree >= 360) {
			degree -= 360;
		}
		this.setDegree(degree);
		return this.getDegree();
	}
}
