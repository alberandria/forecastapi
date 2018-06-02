package ar.com.melitest.forecast.domain;

public abstract class Planet {
	private int degree;
	private int orbitRadius;
	private int angularSpeed;
	
	public abstract int advanceOneDay();
	
	public Position getPosition() {
		Position pos = new Position();
		pos.setX((double)Math.round(orbitRadius*Math.cos(Math.toRadians(degree))));
		pos.setY((double)Math.round(orbitRadius*Math.sin(Math.toRadians(degree))));
		return pos;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getOrbitRadius() {
		return orbitRadius;
	}
	
	public int getAngularSpeed() {
		return angularSpeed;
	}

	public void setOrbitRadius(int orbitRadius) {
		this.orbitRadius = orbitRadius;
	}

	public void setAngularSpeed(int angularSpeed) {
		this.angularSpeed = angularSpeed;
	}
	
	
}
