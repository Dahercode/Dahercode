package fr.univ_smb.iae.mtii.m1.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.univ_smb.iae.mtii.m1.gestion.Entreprise;
import fr.univ_smb.iae.mtii.m1.gestion.Programme;
import fr.univ_smb.iae.mtii.m1.personnel.Salarie;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

//Cette classe est une interface utilisée pour tester le parcours utilisateur_Salarié, c'est une démo, l'horaire de travail est fixée à 8h-17h, pour plus de liberté, utilisons le jeu d'essai :D 

public class Interface_Salarie_Demo extends JFrame {

	private JPanel contentPane;


	private JTextField iD;
	private JTextField nom;
	private JButton entrer;
	private JLabel lblCetteInterfaceNest;
	private JLabel lblLhoraireDeTravail;
	private JLabel lblPlusDeLibert;
	private JButton comptePerso;

	// Facade Design Pattern
	private Salarie salarie;
	private Programme programme;
	private Entreprise entreprise;
	public Interface_Salarie_Demo() {
		 
		 entreprise = Entreprise.getInstance();
		 programme = new Programme ();
		 
		 
		 
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		JButton creerObjet = new JButton("1.Cr\u00E9er l'objet !");
		creerObjet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // ajouter le try ! pour entrer et creer
				String a= iD.getText();
				String b = nom.getText();
				salarie = new Salarie ();
				salarie.setId(a);
				salarie.setNom(b);
				programme.setHoraire("08:00","14:00");
				entreprise.enregistrerSalarie(salarie,programme);
				System.out.println("L'objet de type salarié est crée puis ajouté à l'entreprise avec succcès");
				entrer.setEnabled(true);
				comptePerso.setEnabled(true);
			}
		});
		
		iD = new JTextField();
		iD.setText("Veuillez saisir un iD de votre choix");
		iD.setColumns(10);
		
		nom = new JTextField();
		nom.setText("Veuillez saisir un nom de votre choix");
		nom.setColumns(10);
		
		entrer = new JButton("2.Entrer au local !");
		entrer.setEnabled(false);
		entrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					salarie.entrerLocal();
					
			}
		});
		
		lblCetteInterfaceNest = new JLabel("Cette interface n'est qu'une version demo du parcours_utilisateur salari\u00E9.");
		lblCetteInterfaceNest.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCetteInterfaceNest.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblLhoraireDeTravail = new JLabel("L'horaire de travail est fix\u00E9 par d\u00E9faut \u00E0 8h le matin et 14h l'aprem");
		lblLhoraireDeTravail.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		lblPlusDeLibert = new JLabel("Plus de libert\u00E9 sur le jeu d'essai !");
		lblPlusDeLibert.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		comptePerso = new JButton("3.Mon compte");
		comptePerso.setEnabled(false);
		comptePerso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					salarie.comptePersonnel();
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(nom, Alignment.LEADING)
								.addComponent(iD, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 213, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(127)
							.addComponent(lblPlusDeLibert)))
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCetteInterfaceNest, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(17, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addComponent(creerObjet)
					.addGap(18)
					.addComponent(entrer)
					.addGap(18)
					.addComponent(comptePerso, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(43))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addComponent(lblLhoraireDeTravail, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(iD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(29)
					.addComponent(nom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblCetteInterfaceNest, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(lblLhoraireDeTravail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblPlusDeLibert)
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(creerObjet)
						.addComponent(entrer)
						.addComponent(comptePerso, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
