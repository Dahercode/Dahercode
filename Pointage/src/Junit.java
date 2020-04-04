import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Junit {
	private Salarie s;
	private Programme p;
	private Entreprise en;

	@Before
	public void setUp() throws Exception {
		this.s = new Salarie("T01","Riven");
		this.p = new Programme();
		this.en = Entreprise.getInstance();
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
	@Test
	public void defaultHeureDePause() { //L'heure de pause est normalement d�finie par d�faut � 12
		 assertEquals(12, p.getHeurePause());
	}
	public void setHeureDePause() { 
		p.setHeurePause(13);
		assertEquals(13, p.getHeurePause());
	}
	@Test
	public void defaultRegledeGestion() { //La regle de gestion est normalement d�finie par d�faut � 500 minutes
		 assertEquals(500, en.getRegleDeGestion());
	}
	public void setRegledegestion() { 
		en.setRegleDeGestion(1000);
		assertEquals(1000, en.getRegleDeGestion());
	}
	@Test
	public void isAssiduTest(){
		p.setHoraire("08:00", "14:00");
		en.enregistrerSalarie(s, p);
		s.setRetard(550);
		 assertEquals(false, s.isAssidu());  //Le resultat doit renvoyer � false puisque le salari� n'a pas respect� la r�gle de gestion d�finie par d�faut (500 minutes de retard maximum)
	}
	@Test
	public void isNotAssiduTest(){
		p.setHoraire("08:00", "14:00");
		en.enregistrerSalarie(s, p);
		s.setRetard(450);
		 assertEquals(true, s.isAssidu());  //Le resultat doit renvoyer � true puisque le salari� n'a pas enfreit la r�gle de gestion d�finie par d�faut (500 minutes de retard maximum)
	}
	

}
