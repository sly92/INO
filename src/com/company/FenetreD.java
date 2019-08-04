package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class FenetreD extends JFrame {

	private static JTextField nom=new JTextField(30);
	private JTextField agilite=new JTextField(30);
	private JTextField force=new JTextField(30);
	private JTextField intel=new JTextField(30);
	private JTextField chance=new JTextField(30);
	private JButton commencer=new JButton("Nouvelle Partie");
	private JButton Charger=new JButton("Charger");
    public static FenetreD fn;
	
	public FenetreD(){
		super("INO");
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.initialise();
		
	}
	
	public void initialise(){
		JPanel a = new JPanel(new GridLayout(6,2));
		BoutonListener n = new BoutonListener();
		a.add(new JLabel("nom"));
		a.add(nom);
		a.add(new JLabel("agilite"));a.add(agilite);
		a.add(new JLabel("force"));a.add(force);
		a.add(new JLabel("intelligence"));a.add(intel);
		a.add(new JLabel("chance"));a.add(chance);
		commencer.addActionListener(n);
		a.add(Charger);
		a.add(commencer);
		this.add(a);
	}

	public static String getnom(){return nom.getText();}
	public int getforce(){ return Integer.parseInt(force.getText());}
	public int getagilite(){return Integer.parseInt(agilite.getText());}
	public int getchance(){return Integer.parseInt(chance.getText());}
	public int getintel(){return Integer.parseInt(intel.getText());}
	
	

public class BoutonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			if(s.equals("Nouvelle Partie")){
				Fenetre.fen();
				fn.setVisible(false);
			}
			
		}}
	public static void main(String[] args) {
		 fn=new FenetreD();

		
	}

}
