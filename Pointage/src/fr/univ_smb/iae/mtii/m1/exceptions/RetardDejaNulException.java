package fr.univ_smb.iae.mtii.m1.exceptions;

public class RetardDejaNulException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public RetardDejaNulException(){
		super ("L'employé concerné n'a aucune minute de retard sur son compteur");
	}

}
