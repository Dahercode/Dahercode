package fr.univ_smb.iae.mtii.m1.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.univ_smb.iae.mtii.m1.utilités.Database;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.TextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.Font;

public class Insertion_Interface extends JFrame {

	private JPanel contentPane;
	
	public Connection con;
	private JTextField iDInput;
	private JTextField nomInput;
	
	


	
	
	public Insertion_Interface(String iD, String nom) {
		Database d = new Database ();
		d.createConnection();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		iDInput = new JTextField();
		iDInput.setText(iD);
		iDInput.setToolTipText("");
		iDInput.setColumns(10);
		
		nomInput = new JTextField();
		nomInput.setText(nom);
		nomInput.setColumns(10);
		
		JButton insertIntoBdd = new JButton("Ins\u00E9rer objet dans la BDD locale !");
		insertIntoBdd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		insertIntoBdd.addActionListener(new ActionListener() 
		
		
		{
			public void actionPerformed(ActionEvent e) {
				try {
					String iD=iDInput.getText();
					String nom=nomInput.getText();

					PreparedStatement st= d.getCon().prepareStatement("INSERT INTO SALARIES VALUES(?,?)");
					st.setString(1, iD);	
					st.setString(2, nom);
					st.execute();
					System.out.println("L'insertion est réussie");
					st.close();
				} 
				catch (SQLException | NullPointerException ex) {
					
				System.out.println("Une erreur SQL est survenue, vérifier que la clé primaire n'existe pas déjà et le format des données saisies");   
				Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);	   
			    }
		   }
			
			
		});
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(nomInput, Alignment.TRAILING)
						.addComponent(iDInput, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
					.addGap(36)
					.addComponent(insertIntoBdd, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
					.addGap(16))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(iDInput, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(52)
							.addComponent(nomInput, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(104)
							.addComponent(insertIntoBdd, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(50, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);

	}
}
