package fr.univ_smb.iae.mtii.m1.gestion;

import java.util.ArrayList;

import fr.univ_smb.iae.mtii.m1.exceptions.RetardDejaNulException;
import fr.univ_smb.iae.mtii.m1.interfaces.Interface_Bienvenue;
import fr.univ_smb.iae.mtii.m1.personnel.Salarie;

public class Entreprise {
 
	private ArrayList <Salarie> salaries = new ArrayList <Salarie>();
	private long regleDeGestion=500;
	
	public ArrayList <Salarie> getSalaries() {
		return salaries;
	}
	
	
	//Consructeur + Singleton (Design Pattern)
	private Entreprise(){
		Interface_Bienvenue test = new Interface_Bienvenue();
		test.setVisible(true);	
	}
	private static Entreprise INSTANCE=null;
	
	
	
	public static Entreprise getInstance(){
		if (INSTANCE==null){
			INSTANCE= new Entreprise();
		}
		return INSTANCE;
	}
	
	
	
	
	public void enregistrerSalarie (Salarie e,Programme p){
		
		this.getSalaries().add(e);
		e.setEntreprise(this);
		e.setProgramme(p);
	}
	
	public void retirerSalarie (Salarie e){
		this.getSalaries().remove(e);
	}
	
	public void listerCompteDesSalaries () {
		for (int i = 0; i<this.getSalaries().size();i++) {
			this.getSalaries().get(i).comptePersonnel();
		}
	}
	
	public void retardEstJusitfie(Salarie e, long l) throws RetardDejaNulException {
		boolean salarieTrouve=false;
		int i=0;
		while (salarieTrouve==false && i<this.getSalaries().size()){
			if (this.getSalaries().get(i)==e){
				salarieTrouve=true;
				long a = this.getSalaries().get(i).getRetard();
				if (a==0){
					throw  new RetardDejaNulException ();
				}
				else {
					this.getSalaries().get(i).setRetard(a-l);
					System.out.println("Retard justifié avec succès");
				}
			}
			i++;
		}
		
	}
	
	
	public void nouvelleAnnee () {
		System.out.println("Bienvenue à la nouvelle Année : ");
		for (int i = 0; i<this.getSalaries().size();i++) {
			this.getSalaries().get(i).setRetard(0);
			this.getSalaries().get(i).setAvance(0);
			this.getSalaries().get(i).comptePersonnel();
		}
	}
	
	public void listerHistoriqueEntree () {
		for (int i = 0; i<this.getSalaries().size();i++) {
			this.getSalaries().get(i).consulterHistorique();
		}
	}
	

	public long getRegleDeGestion() {
		return regleDeGestion;
	}


	public void setRegleDeGestion(long regleDeGestion) {
		this.regleDeGestion = regleDeGestion;
	}
	
	



	
}
