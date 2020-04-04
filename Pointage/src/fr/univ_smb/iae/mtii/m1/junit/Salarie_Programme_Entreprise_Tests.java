package fr.univ_smb.iae.mtii.m1.junit;
import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univ_smb.iae.mtii.m1.exceptions.RetardDejaNulException;
import fr.univ_smb.iae.mtii.m1.gestion.Entreprise;
import fr.univ_smb.iae.mtii.m1.gestion.Programme;
import fr.univ_smb.iae.mtii.m1.personnel.Salarie;

public class Salarie_Programme_Entreprise_Tests {
	private Salarie s;
	private Programme p;
	private Entreprise en;

	@Before
	public void setUp() throws Exception {
		this.s = new Salarie("T01","Riven");
		this.p = new Programme();
		this.en = Entreprise.getInstance();
		
		p.setHoraire("08:00", "14:00");
		en.enregistrerSalarie(s, p);
	}

	@After
	public void tearDown() throws Exception {
		en.retirerSalarie(s);
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
	public void defaultHeureDePause() { //L'heure de pause est normalement définie par défaut à 12
		 assertEquals(12, p.getHeurePause());
	}
	public void setHeureDePause() { 
		p.setHeurePause(13);
		assertEquals(13, p.getHeurePause());
	}
	@Test
	public void defaultRegledeGestion() { //La regle de gestion est normalement définie par défaut à 500 minutes
		 assertEquals(500, en.getRegleDeGestion());
	}
	public void setRegledegestion() { 
		en.setRegleDeGestion(1000);
		assertEquals(1000, en.getRegleDeGestion());
	}
	@Test
	public void isAssiduTest(){
		s.setRetard(550);
		 assertEquals(false, s.isAssidu());  //Le resultat doit renvoyer à false puisque le salarié n'a pas respecté la règle de gestion définie par défaut (500 minutes de retard maximum)
	}
	@Test
	public void isNotAssiduTest(){
		s.setRetard(450);
		 assertEquals(true, s.isAssidu());  //Le resultat doit renvoyer à true puisque le salarié n'a pas enfreit la règle de gestion définie par défaut (500 minutes de retard maximum)
	}
	@Test
	public void associationEntrepriseSalarieTest(){
		 assertEquals(1, en.getSalaries().size());  
	}
	@Test
	public void retirerSalarie(){
		 en.retirerSalarie(s); 
		 assertEquals(0, en.getSalaries().size()); 
	}
	@Test
	public void getRetardDepuisEntreprise(){
		 s.setRetard(200);
		 assertEquals(200, en.getSalaries().get(0).getRetard());  
	}
	@Test
	public void nouvelleAnnee_retard(){
		 en.nouvelleAnnee();
		 assertEquals(0, en.getSalaries().get(0).getRetard());  
	}
	@Test
	public void nouvelleAnnee_avance(){
		 en.nouvelleAnnee();
		 assertEquals(0, en.getSalaries().get(0).getAvance());  
	}
	@Test
	public void retardestJustifie() throws RetardDejaNulException{
		 s.setRetard(100);
		 en.retardEstJusitfie(s, 50);
		 assertEquals(50, en.getSalaries().get(0).getRetard());  
	}
//	@Test
//	public void getHoraire_BaseDeCalculDuRetard() {
//		assertEquals("Sat Apr 04 14:00:00 CEST 2020", p.getHoraire().toString()); //Le test renvoie à succès si la date saisie en expected correspond bien a la date du jour et si l'heure actuelle est supérieur à l'heure de pause 
//	}
	
	

}
