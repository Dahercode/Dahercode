package fr.univ_smb.iae.mtii.m1.main;

import fr.univ_smb.iae.mtii.m1.gestion.Entreprise;
import fr.univ_smb.iae.mtii.m1.gestion.Programme;
import fr.univ_smb.iae.mtii.m1.personnel.Employe;
import fr.univ_smb.iae.mtii.m1.personnel.Manager;

public class Essai {

	public static void main(String[] args) throws Exception {
	
		Entreprise en =	Entreprise.getInstance(); //Ouvre l'interface bienvenue qui mène à d'uatures interfaces, plusieurs actions sont possibles ! 
		
		// Tester le reste des méthodes ! : 
		Programme p;
		p=new Programme();
		p.setHoraire("8h","14h"); // Whops, ce n'est pas comme ça qu'il faut saisir 
     	p.setHoraire("08:00","14:00"); // Corrigeons
     	  	
	    Manager m; //La création d'un objet de type salarié ouvre une interface qui propose la saisie des données en bdd locale
	    m= new Manager("M001","Riven"); 
        Employe e;
		e=new Employe("E001","Alex");
		
		en.enregistrerSalarie(m, p); // Enregistrement des salairés à l'entreprise
		en.enregistrerSalarie(e, p);
		
		m.entrerLocal(); // Les deux salairés sont au locaux, la console affiche l'heure et calcule leur retard
		e.entrerLocal();
		
		en.listerCompteDesSalaries(); //Affiche le compte des retards avance pour tous les salariés enregistrés
//		en.listerHistoriqueEntree();  Affiche l'historiques des entrées de tous les salariés, pour mieux tester la méthode, lancez l'application en mode debug où les salariés entre plusieurs fois avec un écart de temps ^^
//		
		en.retardEstJusitfie(m, 60); //Le manager a pu justifier une heure de retard, retirons l'heure de son compteur !! 
		m.comptePersonnel(); // Vérifions le succès de l'opération précédente ^^
		
		en.setRegleDeGestion(300); //Nous passons par une semaine délicate!, on n'accepte plus les salariés avec un retard supérieur à 300 minutes ! 
		e.entrerLocal(); // Alex est encore en retard (veuillez bien vérifier qu'il est en retard pas en avance :p) ! 
		//.. Refaire l'opération entrer local jusqu'à que l'utilisateur dépasse 300 minutes de retard en total
		//..
		//..
		e.entrerLocal(); // Et non, l'accès est bloqué, la console affiche un message demandant au salarié de s'adresser à la direction
		e.totalAvance(); //Alex peut voir son compteur d'avance et s'en servir comme arugmenet pour son convocation 
		en.retirerSalarie(e); // Désolé mais on vous vire, trop de retards !
		en.listerCompteDesSalaries(); // Vérifions qu'il n'est bien plus là 
		
		
		
		en.nouvelleAnnee(); // Nouvelle année, on réinitialise tous les comptes des salariés ! 
		
		//Testons maitenant la hiérarchie Manager/Employé 
		
		Employe e2 = new Employe ("E002","Quiyana");
	    m.ajouterEmploye(e2); // Oups, toujours pas enregistré
	    en.enregistrerSalarie(e2, p); 
	    m.ajouterEmploye(e2);  
	    m.listerCompteDesEmployes(); // Et voilà
	    e2.entrerLocal(); 
	    m.listerCompteDesEmployes();
//	    m.listerHistoriqueEntree(); Le manager a aussi la possibilité de voir l'historique d'entrées, à tester avec debug mode de préférence 
        m.retirerEmploye(e2); //Notre manager ne veut plus de Quiyana
        m.listerCompteDesEmployes(); // Elle a bien disparu :(
		
	}

}
