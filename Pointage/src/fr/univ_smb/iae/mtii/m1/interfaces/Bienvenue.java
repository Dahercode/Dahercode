package fr.univ_smb.iae.mtii.m1.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.univ_smb.iae.mtii.m1.utilités.Database;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Bienvenue extends JFrame {

	private JPanel contentPane;


	
	public Bienvenue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblBienvenueChezMtii = new JLabel("Bienvenue chez MTII ENTREPRISE !");
		lblBienvenueChezMtii.setFont(new Font("Sitka Heading", Font.BOLD, 20));
		
		JButton btnSeConnecter = new JButton("Consulter la liste de vos salari\u00E9s sur la BDD!");
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Database data =new Database ();
				data.selectAllFromDatabase();
				for (int i=0; i< data.getColonneId().size();i++){
					String a =data.getColonneId().get(i);
					String b= data.getColonneNom().get(i);
					System.out.println("Le salarié "+ a+ " / Nom: "+ b);
					
				}
			}
		});
		
		JButton openEntrepriseInterface = new JButton("Continuer");
		openEntrepriseInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Fonctionnalites fonc_Interface= new Fonctionnalites();
				fonc_Interface.setVisible(true);
				
			}
		});
		
		JLabel lblPourTesterDautres = new JLabel("Pour tester d'autres fonctionnalit\u00E9s de la classe entrerpise : ");
		
		JLabel lblPourTesterLes = new JLabel("Pour tester les fonctionnalit\u00E9s de la classe salari\u00E9 : ");
		
		JButton openSalarieInterface = new JButton("Continuer");
		openSalarieInterface.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Interface_Salarie_Demo i= new Interface_Salarie_Demo();
				i.setVisible(true);
				
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(64)
							.addComponent(lblBienvenueChezMtii, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(85)
							.addComponent(btnSeConnecter)))
					.addContainerGap(84, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPourTesterDautres, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPourTesterLes, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
							.addGap(39)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(openSalarieInterface, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(openEntrepriseInterface, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
					.addGap(68))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addComponent(lblBienvenueChezMtii, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSeConnecter, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(73)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addComponent(lblPourTesterLes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(openSalarieInterface, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(openEntrepriseInterface, GroupLayout.PREFERRED_SIZE, 18, Short.MAX_VALUE)
						.addComponent(lblPourTesterDautres, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(3))
		);
		contentPane.setLayout(gl_contentPane);
	}


	
}
