
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Salarie {
	private String iD;
	private String nom;
	private long retard;
	private long avance;
	private Programme programme;
	private ArrayList <String> historiqueEntrees = new ArrayList <String>();
	private Entreprise entreprise;
	private boolean assidu=true;
	
	
	
	public String getId(){
		return this.iD;
	}
	public void setId (String i){
		this.iD =i;
	}
	public String getNom(){
		return this.nom;
	}
	public void setNom (String n){
		this.nom =n;
	}
	
	public Salarie (String i, String n){
		this.setId(i);
		this.setNom(n);
		Insertion_Interface interfagraphique =new Insertion_Interface(i,n);
		interfagraphique.setVisible(true);
		
	}
	
	public Salarie (){
		
	}
	
	public void setProgramme (Programme p){
		this.programme=p;
	}
	
	
	public void entrerLocal() {
		
		SimpleDateFormat tf= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	     Date d;
	     d=new Date(); //Date d'entrée
	     try {
	    	 if (this.isAssidu()==true){
	    		 System.out.println(this.getId()+" vous êtes entré dans les locaux. Time : " + tf.format(d));
	    		 this.calculRetardOuAvance();
	    		 
	    	 }
	    	 
	    	 else {
	    		 System.out.println(this.getId()+" Vous avez dépassé le nombre maximal de retard autorisé, veuillez vous addresser à la direction");
	    	 }
	    	 
	     }
	     catch (NullPointerException e){
	    	 System.out.println( this.getId()+ " n'est pas enregistré dans l'entreprise, les calculs ne seront pas corrects");
	     }
	}
	
	
	
	 public void calculRetardOuAvance (){
		SimpleDateFormat tf= new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	     Date d;
	     d=new Date(); //Date d'entrée
	     try{
	    	 long r=  (d.getTime()-this.programme.getHoraire().getTime())/60000; 
	    	 
	    	 //Retard	    	 
	    	 if (r>0){
	    		 this.retard = r + this.retard;
	    		 String t ="     Retard : " + r+ " minutes" +" correspondant à " +r/60+" heure(s)";
	    		 System.out.println(t);
	    		 String s1 = "Time : " + tf.format(d) +t ;
	    		 this.getHistoriqueEntrees().add(s1);
	    	 }
	    	 
	    	 //Avance
	    	 else {
	    		 this.avance= r*-1 +this.avance;
	    		 String t2 ="     Avance : " + r*-1+ " minutes" +" correspondant à " +r*-1/60+" heure(s)";
	    		 System.out.println(t2);
	    		 String s2 = " Time : " + tf.format(d) +t2 ;
	    		 this.getHistoriqueEntrees().add(s2);
	    		 
	    		 
	    	 }
	     }
	     catch(NullPointerException e){
	    	 
	    	 System.out.println("Attention ! Le retard ou avance ne peuvent pas être calculés à cause de l'absence ou d'une erreur de saisie d'horaire");
	    	 
	     }
	     
	        
	   
	}
	
	
	
	
	
	
	
	public void consulterHistorique(){
		if (this.getHistoriqueEntrees().size()>0){
			System.out.println ("Le salarié " + this.getId() +" est entré dans les locaux. ");
			for (int i=0; i<this.getHistoriqueEntrees().size();i++){
				System.out.println(this.getHistoriqueEntrees().get(i));
			}
			
		}
		else{
			System.out.println("Aucune entrée enregistrée");
		}
		
		
	}
	public long getRetard() {
		return retard;
	}
	
	public void setRetard(long l) {
		this.retard=l;
	}
	
	public void totalRetard(){
//		double enHeure= Double.valueOf(this.retard)/60;
		System.out.println(" Retards accumulés: "+ this.retard+" minutes, soit approximativement " + this.retard/60 + " heures");
	}
	
	public void totalAvance(){
//		double enHeure= Double.valueOf(this.retard)/60;
		System.out.println(" Avances accumulées: "+ this.avance+" minutes, soit approximativement " + this.avance/60 + " heures");
	}
	
	public void comptePersonnel(){
		System.out.println(this.getNom()+" >> ID : " + this.getId());
		this.totalRetard();
		this.totalAvance();
	}
	
	public long getAvance() {
		return avance;
	}
	public void setAvance(long avance) {
		this.avance = avance;
	}
	public ArrayList <String> getHistoriqueEntrees() {
		return historiqueEntrees;
	}
	public boolean isAssidu() {
		if (this.retard>=this.getEntreprise().getRegleDeGestion()){
			this.assidu =false;
		}
		else{
			this.assidu=true;
		}
		return assidu;
	}
	public void setAssidu(boolean assiduite) {
		this.assidu = assiduite;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;

	}

	
	
	
	
}
