package fr.univ_smb.iae.mtii.m1.personnel;

public class Employe extends Salarie{

	
	public Employe (String i, String n){
		super(i,n);
	}
	
  
	public void entrerLocal(){
		System.out.print("L'employ� ");
		super.entrerLocal();
	}
	
	public void comptePersonnel(){
		System.out.print("L'employ� ");
		super.comptePersonnel();
	}
 
 
}
