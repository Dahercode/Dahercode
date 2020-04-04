import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProgrammeTest {
	private Programme p;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = NullPointerException.class)
	public void setHoraireException() {
		p.setHoraire("08h","17h");
	}

}
