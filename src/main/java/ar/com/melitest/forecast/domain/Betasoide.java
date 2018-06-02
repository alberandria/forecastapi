package ar.com.melitest.forecast.domain;

public class Betasoide extends Planet {

	public Betasoide() {
		this.setDegree(0);
		this.setAngularSpeed(3);
		this.setOrbitRadius(2000);
	}

	@Override
	public int advanceOneDay() {
		int degree = this.getDegree();
		degree-=this.getAngularSpeed();
		if(degree < 0) {
			degree += 360;
		}
		this.setDegree(degree);
		return this.getDegree();
	}

}
