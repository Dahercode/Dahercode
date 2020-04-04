package fr.univ_smb.iae.mtii.m1.personnel;

import java.util.ArrayList;

public class Manager extends Salarie {
	
	private ArrayList <Employe> employes = new ArrayList <Employe>();
	

	
	public Manager (String i, String n){
		super(i,n);
	}
	
	
  
	public void entrerLocal() {
		System.out.print("Manager ");
		super.entrerLocal();
	}
	
	public void comptePersonnel(){
		System.out.print("Le manager ");
		super.comptePersonnel();
	}


	public ArrayList <Employe> getEmployes() {
		return employes;
	}


	public void ajouterEmploye (Employe e){
		if(e.getEntreprise() != null && this.getEntreprise()!=null){
			this.getEmployes().add(e);
        }
		else {
			if(e.getEntreprise()==null){
				System.out.println("L'employé " + e.getId()+ " n'est pas enregistré dans l'entreprise, il ne peut être sous la charge du Manager");
			}
			else {
				System.out.println("Le manager " + this.getId()+ " n'est pas enregistré dans l'entreprise, il ne peut être responsable de l'employé");
			}
		}
	}
	public void retirerEmploye (Employe e){
		this.getEmployes().remove(e);
	}
	
	public void listerHistoriqueEntree () {
		if (this.getEmployes().size()>0){
			for (int i = 0; i<this.getEmployes().size();i++) {
				this.getEmployes().get(i).consulterHistorique();
			}	
		}
		else {
			System.out.println("Vous n'avez aucun employé à votre charge");
		}
	}
	
	public void listerCompteDesEmployes () {
		if (this.getEmployes().size()>0){
			for (int i = 0; i<this.getEmployes().size();i++) {
				this.getEmployes().get(i).comptePersonnel();
			}	
		}
		else {
			System.out.println("Vous n'avez aucun employé à votre charge");
		}
	}
}
