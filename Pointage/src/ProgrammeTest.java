import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProgrammeTest {
	private Programme p;

	@Before
	public void setUp() throws Exception {
		this.p = new Programme();
		p.setHoraire("08:00","17:00");
		p.setHeurePause(12);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void setHoraireException() {
		p.setHoraire("08:00","17:00");
		assertEquals("Sat Apr 04 17:00:00 CEST 2020", p.getHoraire().toString()); //Le test renvoie à succès si la date saisie en expected correspond bien a la date du jour et si l'heure actuelle est supérieur à l'heure de pause 
	}

}
