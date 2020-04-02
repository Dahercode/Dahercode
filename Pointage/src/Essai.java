

public class Essai {

	public static void main(String[] args) throws Exception {
	
		
		

		Programme p;
		p=new Programme();
		p.setHoraire("08:00","14:00");
	  
		Employe a;
		a=new Employe("E001","Alex"); //   Une fenêtre s'affiche proposant d'ajouter le salarié à la BDD
////     	a.setProgramme(p);
//		Manager e;
//		e= new Manager("P001","Gandia"); // Une fenêtre s'affiche proposant d'ajouter le salarié à la BDD
//		e.setProgramme(p);
		
		

	Entreprise en =	Entreprise.getInstance(); //Affiche l'interface Bienvenue!
		
		//Tester le reste des fonctianalités sur l'employé a et le manager e
//		en.enregistrerSalarie(a,p);  // Enregistre le salarié a avec l'horaire de travail correspondant
//		en.enregistrerSalarie(e,p);
//		en.retirerSalarie(a);
//		en.listerCompteDesSalaries();
//		en.enregistrerSalarie(a,p);
//		en.listerCompteDesSalaries();
//        a.entrerSalle();
//        e.entrerSalle();
//        en.listerHistoriqueEntree();
		
	
//    	en.listerCompteDesSalaries();
//		en.retardEstJusitfie(e, 30);
//		en.retardTotal();
		
//		en.nouvelleAnnee();
//		a.entrerSalle();
//		a.comptePersonnel();
//		e.ajouterEmploye(a);
//		a.entrerSalle();
//		en.listerCompteDesSalaries();
//		en.listerHistoriqueEntree();
//		e.listerHistoriqueEntree();
//		e.listerCompteDesSalaries();
//		e.consulterHistorique();
		

	}

}
