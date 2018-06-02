package ar.com.melitest.forecast.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class VulcanoTest {
	@Test
	public void vulcanoDisplacementTest() {
		Vulcano vulcano = new Vulcano();
		vulcano.advanceOneDay();
		vulcano.advanceOneDay();
		vulcano.advanceOneDay();
		
	    assertThat(vulcano.getDegree())
	      .isEqualTo(15);
	}
	
	@Test
	public void vulcanoPositionTest() {
		Vulcano vulcano = new Vulcano();
		vulcano.advanceOneDay();
		vulcano.advanceOneDay();
		vulcano.advanceOneDay();

		Position expected = new Position();
		expected.setX(966);
		expected.setY(259);
		
	    assertThat(vulcano.getPosition().getX()).isEqualTo(expected.getX());
	    assertThat(vulcano.getPosition().getY()).isEqualTo(expected.getY());
	}
}
