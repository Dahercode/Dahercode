import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

	private Connection con;
	private ArrayList <String> colonneId= new ArrayList <String>();
	private ArrayList <String> colonneNom= new ArrayList <String>();
	
	
	public void selectAllFromDatabase(){
		this.createConnection();
		try{
			
			Statement s =con.createStatement();
		    ResultSet rs =s.executeQuery("SELECT * FROM SALARIES");	
		     while(rs.next()){
		    	 this.colonneId.add(rs.getString("iD"));
		    	 this.colonneNom.add(rs.getString("nom")); //Le nom de la colonne
		     }
		     s.close();
			
		
		}
		catch(  SQLException ex){
			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public void createConnection(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			 setCon(DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root"));
			 System.out.println("Database Connection Success");	
		}
		catch(ClassNotFoundException | SQLException ex){
//			Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("L'application n'arrive pas à accèder au serveur BDD local, veuillez lancer le serveur MySQL avant !");
		}
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public ArrayList <String> getColonneId(){
		return this.colonneId;
	}
	public ArrayList <String> getColonneNom(){
		return this.colonneNom;
	}

	
	
	
	}

