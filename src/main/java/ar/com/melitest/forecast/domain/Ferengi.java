package ar.com.melitest.forecast.domain;

public class Ferengi extends Planet {

	public Ferengi() {
		this.setDegree(0);
		this.setAngularSpeed(1);
		this.setOrbitRadius(500);
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
