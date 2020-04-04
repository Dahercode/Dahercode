package fr.univ_smb.iae.mtii.m1.main;

import fr.univ_smb.iae.mtii.m1.gestion.Entreprise;
import fr.univ_smb.iae.mtii.m1.gestion.Programme;
import fr.univ_smb.iae.mtii.m1.personnel.Employe;
import fr.univ_smb.iae.mtii.m1.personnel.Manager;

public class Essai {

	public static void main(String[] args) throws Exception {
	
		Entreprise en =	Entreprise.getInstance(); //Ouvre l'interface bienvenue qui m�ne � d'uatures interfaces, plusieurs actions sont possibles ! 
		
		// Tester le reste des m�thodes ! : 
		Programme p;
		p=new Programme();
		p.setHoraire("8h","14h"); // Whops, ce n'est pas comme �a qu'il faut saisir 
     	p.setHoraire("08:00","14:00"); // Corrigeons
     	  	
	    Manager m; //La cr�ation d'un objet de type salari� ouvre une interface qui propose la saisie des donn�es en bdd locale
	    m= new Manager("M001","Riven"); 
        Employe e;
		e=new Employe("E001","Alex");
		
		en.enregistrerSalarie(m, p); // Enregistrement des salair�s � l'entreprise
		en.enregistrerSalarie(e, p);
		
		m.entrerLocal(); // Les deux salair�s sont au locaux, la console affiche l'heure et calcule leur retard
		e.entrerLocal();
		
		en.listerCompteDesSalaries(); //Affiche le compte des retards avance pour tous les salari�s enregistr�s
//		en.listerHistoriqueEntree();  Affiche l'historiques des entr�es de tous les salari�s, pour mieux tester la m�thode, lancez l'application en mode debug o� les salari�s entre plusieurs fois avec un �cart de temps ^^
//		
		en.retardEstJusitfie(m, 60); //Le manager a pu justifier une heure de retard, retirons l'heure de son compteur !! 
		m.comptePersonnel(); // V�rifions le succ�s de l'op�ration pr�c�dente ^^
		
		en.setRegleDeGestion(300); //Nous passons par une semaine d�licate!, on n'accepte plus les salari�s avec un retard sup�rieur � 300 minutes ! 
		e.entrerLocal(); // Alex est encore en retard (veuillez bien v�rifier qu'il est en retard pas en avance :p) ! 
		//.. Refaire l'op�ration entrer local jusqu'� que l'utilisateur d�passe 300 minutes de retard en total
		//..
		//..
		e.entrerLocal(); // Et non, l'acc�s est bloqu�, la console affiche un message demandant au salari� de s'adresser � la direction
		e.totalAvance(); //Alex peut voir son compteur d'avance et s'en servir comme arugmenet pour son convocation 
		en.retirerSalarie(e); // D�sol� mais on vous vire, trop de retards !
		en.listerCompteDesSalaries(); // V�rifions qu'il n'est bien plus l� 
		
		
		
		en.nouvelleAnnee(); // Nouvelle ann�e, on r�initialise tous les comptes des salari�s ! 
		
		//Testons maitenant la hi�rarchie Manager/Employ� 
		
		Employe e2 = new Employe ("E002","Quiyana");
	    m.ajouterEmploye(e2); // Oups, toujours pas enregistr�
	    en.enregistrerSalarie(e2, p); 
	    m.ajouterEmploye(e2);  
	    m.listerCompteDesEmployes(); // Et voil�
	    e2.entrerLocal(); 
	    m.listerCompteDesEmployes();
//	    m.listerHistoriqueEntree(); Le manager a aussi la possibilit� de voir l'historique d'entr�es, � tester avec debug mode de pr�f�rence 
        m.retirerEmploye(e2); //Notre manager ne veut plus de Quiyana
        m.listerCompteDesEmployes(); // Elle a bien disparu :(
		
	}

}
