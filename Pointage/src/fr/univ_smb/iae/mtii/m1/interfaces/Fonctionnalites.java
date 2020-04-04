package fr.univ_smb.iae.mtii.m1.interfaces;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import fr.univ_smb.iae.mtii.m1.gestion.Entreprise;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Fonctionnalites extends JFrame {

	private JPanel contentPane;


	
	public Fonctionnalites() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton listercompte = new JButton("Consulter compte de tous les salari\u00E9s !");
		listercompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entreprise en =	Entreprise.getInstance();
				en.listerCompteDesSalaries();
				}
			
		});
		
		JButton listerHistoriqueEntrees = new JButton("Lister historique d'entr\u00E9es de tous les salari\u00E9s!");
		listerHistoriqueEntrees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entreprise en =	Entreprise.getInstance();
				en.listerHistoriqueEntree();
			}
		});
		
		JButton nouvelleAnnee = new JButton("Nouvelle ann\u00E9e ! (R\u00E9initisalise le compte des salari\u00E9s )");
		nouvelleAnnee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entreprise en =	Entreprise.getInstance();
				en.nouvelleAnnee();
			}
		});
		
		JLabel lblLesMthodesNe = new JLabel("Simplification : Les m\u00E9thodes ne marchent que pour  les salari\u00E9s cr\u00E9es sur le jeu d'essai");
		lblLesMthodesNe.setFont(new Font("Tahoma", Font.PLAIN, 9));
		
		JLabel lblOuDepuisLinterface = new JLabel("ou sur l'interface salaries");
		lblOuDepuisLinterface.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblLesMthodesNe, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addGap(18))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(79, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(listercompte, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(listerHistoriqueEntrees, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(nouvelleAnnee, Alignment.TRAILING))
					.addGap(58))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(220, Short.MAX_VALUE)
					.addComponent(lblOuDepuisLinterface)
					.addGap(162))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(15)
					.addComponent(lblLesMthodesNe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblOuDepuisLinterface)
					.addGap(21)
					.addComponent(listercompte)
					.addGap(29)
					.addComponent(listerHistoriqueEntrees)
					.addGap(28)
					.addComponent(nouvelleAnnee)
					.addGap(58))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
}
