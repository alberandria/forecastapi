package ar.com.melitest.forecast.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class BetasoideTest {
	@Test
	public void betasoideDisplacementTest() {
		Betasoide betasoide = new Betasoide();
		betasoide.advanceOneDay();
		betasoide.advanceOneDay();
		betasoide.advanceOneDay();
		
	    assertThat(betasoide.getDegree())
	      .isEqualTo(351);
	}
	
	@Test
	public void vulcanoPositionTest() {
		Betasoide betasoide = new Betasoide();
		betasoide.advanceOneDay();
		betasoide.advanceOneDay();
		betasoide.advanceOneDay();

		Position expected = new Position();
		expected.setX(1975);
		expected.setY(-313);
		
	    assertThat(betasoide.getPosition().getX()).isEqualTo(expected.getX());
	    assertThat(betasoide.getPosition().getY()).isEqualTo(expected.getY());
	}
}
