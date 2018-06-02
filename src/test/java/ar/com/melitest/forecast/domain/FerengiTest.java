package ar.com.melitest.forecast.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FerengiTest {
	@Test
	public void ferengiDisplacementTest() {
		Ferengi ferengi = new Ferengi();
		ferengi.advanceOneDay();
		ferengi.advanceOneDay();
		ferengi.advanceOneDay();
		
	    assertThat(ferengi.getDegree())
	      .isEqualTo(357);
	}
	
	@Test
	public void ferengiPositionTest() {
		Ferengi Ferengi = new Ferengi();
		Ferengi.advanceOneDay();
		Ferengi.advanceOneDay();
		Ferengi.advanceOneDay();

		Position expected = new Position();
		expected.setX(499);
		expected.setY(-26);
		
	    assertThat(Ferengi.getPosition().getX()).isEqualTo(expected.getX());
	    assertThat(Ferengi.getPosition().getY()).isEqualTo(expected.getY());
	}
}
