import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Junit {
	private Salarie s;
	private Programme p;

	@Before
	public void setUp() throws Exception {
		this.s = new Salarie("T01","Riven");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getIdtest() {
		 assertEquals("T01", s.getId());
	}
	@Test
	public void getNomtest() {
		 assertEquals("Riven", s.getNom());
	}

}
