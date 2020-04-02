
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
		this.getEmployes().add(e);
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
	
	public void listerCompteDesSalaries () {
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
