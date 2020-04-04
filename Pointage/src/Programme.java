import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Programme {
private Date[] horaire = new Date[2] ;
private int heurePause=12;

public void setHoraire(String debutTravailMatin,String debutTravailAprem ) {
	SimpleDateFormat tf =new SimpleDateFormat("dd/MM/yy");
	SimpleDateFormat tf2 =new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	SimpleDateFormat tf3 =new SimpleDateFormat("HH:mm");
	Date d= new Date(); 
	String a= tf.format(d); //Je récupère la date du jour
	
	
	
	
	
		try {
			this.horaire[0] = tf2.parse(a+ " "+ debutTravailMatin+":00"); // Je stocke la date du jour + l'heure dans mon attribut horaire
			System.out.println("L'horaire de début du travail le matin est fixée à "+tf3.format(horaire[0])); // J'affiche mon horaire en format tf3
		} 
		catch (ParseException | NullPointerException e) {			
			e.printStackTrace();
			System.out.println("Veuillez saisir l'horaire de début matin correctement, sous le format suivant >> HH:MM");
		} 
		

		try {
			this.horaire[1] = tf2.parse(a+ " "+ debutTravailAprem+":00");
			System.out.println("L'horaire de début du travail l'aprem est fixée à "+tf3.format(horaire[1])); // J'affiche mon horaire en format tf3
		} catch (ParseException | NullPointerException e ) {
			
			System.out.println("Veuillez saisir l'horaire de début aprem correctement, sous le format suivant >> HH:MM");
			
		} // Je stocke la date du jour + l'heure dans mon attribut horaire

}



public Date getHoraire(){
	Calendar cal = Calendar.getInstance();
	
	if (cal.get(Calendar.HOUR_OF_DAY)<this.heurePause){  //Date.getHours était deprecated
	return this.horaire[0];
	}
	else{
		return this.horaire[1];
	}
}



public int getHeurePause() {
	return heurePause;
}



public void setHeurePause(int heurePause) {
	this.heurePause = heurePause;
}

}
