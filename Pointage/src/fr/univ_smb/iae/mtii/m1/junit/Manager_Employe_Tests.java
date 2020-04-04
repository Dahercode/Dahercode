package fr.univ_smb.iae.mtii.m1.junit;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.univ_smb.iae.mtii.m1.gestion.Entreprise;
import fr.univ_smb.iae.mtii.m1.gestion.Programme;
import fr.univ_smb.iae.mtii.m1.personnel.Employe;
import fr.univ_smb.iae.mtii.m1.personnel.Manager;

public class Manager_Employe_Tests {
	private Manager m;
	private Employe e;
	private Programme p;
	private Entreprise en;

	@Before
	public void setUp() throws Exception {
		this.m = new Manager("M01","Sett");
		this.e = new Employe ("S01","Canon");
		this.p = new Programme();
		this.en = Entreprise.getInstance();
		
		en.enregistrerSalarie(m, p);
		en.enregistrerSalarie(e, p);
		
		m.ajouterEmploye(e);
	}

	@After
	public void tearDown() throws Exception {
		m.retirerEmploye(e);
	}
	
	@Test
	public void associationManagerEmployeTest(){
		 assertEquals(1, m.getEmployes().size());  
	}
	@Test
	public void retirerEmploye(){
		 m.retirerEmploye(e); 
		 assertEquals(0, m.getEmployes().size()); 
	}
	@Test
	public void getRetardDepuisManager(){
		 e.setRetard(200);
		 assertEquals(200, m.getEmployes().get(0).getRetard());  
	}

	

}
