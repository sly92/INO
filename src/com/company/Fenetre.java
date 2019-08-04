package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Fenetre extends JFrame{

	public mj moteur;

	public static Fenetre ihm;
	public static Monstre MC;
	public static Joueur JC;

	private JButton atq;
	public JButton[] sac;

	public JTabbedPane centre;
	public JPanel haut;
	public JPanel bas;
	public JPanel mapp;
	public JPanel profil;

	JButton boutonH = new JButton ("Haut");
	JButton boutonB = new JButton ("Bas");
	JButton boutonG = new JButton ("Gauche");
	JButton boutonD = new JButton ("Droite");

	private JButton arme;
	private JButton feu;
	private JButton air;
	private JButton force;

	private String msg;


	public  Fenetre(){


		super(FenetreD.getnom());
		this.moteur=new mj();
		this.setSize(1000,500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		initialise();

	}

	void setMsg(String Msg){
		this.msg=Msg;
	}

	void setBoutonAttaquer(boolean a){

		atq.setEnabled(a);
	}

	void setBoutonCombat(boolean a){
		arme.setEnabled(a);
		feu.setEnabled(a);
		air.setEnabled(a);
		force.setEnabled(a);
	}

	public void initialise () {


		this.setLayout(new BorderLayout());

		this.add(panelBas(),BorderLayout.SOUTH);
		this.add(panelHaut(),BorderLayout.NORTH);
		this.add(panelCentre(),BorderLayout.CENTER);
		this.add(panelGauche(),BorderLayout.WEST);

	}

	public JPanel panelBas(){

		bas = new JPanel();
		bas.setLayout(new GridLayout(1,3));

		arme = new JButton("arme");
		feu = new JButton("sort feu");
		air = new JButton("sort air");
		force = new JButton("sort force");
		arme.setForeground(Color.BLACK);
		feu.setForeground(Color.RED);
		air.setForeground(Color.GREEN);
		force.setForeground(Color.ORANGE);
		arme.setEnabled(false);
		feu.setEnabled(false);
		force.setEnabled(false);
		air.setEnabled(false);
		bas.add(arme);
		bas.add(feu);
		bas.add(force);
		bas.add(air);

		bas.setSize(100, 100);

		return bas;

	}
	public JPanel panelHaut(){
		haut = new JPanel();
		haut.setOpaque(true);
		haut.setBackground(Color.BLACK);
		JLabel a = new JLabel(); JLabel aa = new JLabel();
		JLabel b = new JLabel(); JLabel bb = new JLabel();
		JLabel c = new JLabel(); JLabel cc = new JLabel();
		JLabel d = new JLabel(); JLabel dd = new JLabel();
		JLabel e = new JLabel(); JLabel ee = new JLabel();
		JLabel f = new JLabel(); JLabel ff = new JLabel();
		a.setForeground(Color.BLUE);
		a.setText("Point D'action");
		haut.add(a);

		aa.setForeground(Color.BLUE);
		aa.setText("[ "+moteur.J.getPtsAction()+" ]   ");
		haut.add(aa);

		b.setForeground(Color.GREEN);
		b.setText("Point De Mouvement");
		haut.add(b);

		bb.setForeground(Color.GREEN);
		bb.setText("[ "+moteur.J.getPtsMouvement()+" ]   ");
		haut.add(bb);

		c.setForeground(Color.RED);
		c.setText("Point De Vie");
		haut.add(c);

		cc.setForeground(Color.RED);
		cc.setText("[ "+moteur.J.getPtsVie()+" ]   ");
		haut.add(cc);

		d.setForeground(new Color(239,210,66));
		d.setText("Or");
		haut.add(d);

		dd.setForeground(new Color(239,210,66));
		dd.setText("[ "+moteur.J.getOr()+" ]   ");
		haut.add(dd);

		e.setForeground(Color.ORANGE);
		e.setText("Point D'experience");
		haut.add(e);

		ee.setForeground(Color.ORANGE);
		ee.setText("[ "+moteur.J.getPtsXp()+" ]   ");
		haut.add(ee);

		f.setForeground(Color.DARK_GRAY);
		f.setText("Niveau");
		haut.add(f);

		ff.setForeground(Color.DARK_GRAY);
		ff.setText("[ "+moteur.J.getNiveau()+" ]   ");
		haut.add(ff);
		return haut;

	}

	public void creerSecond(){

		sac=new JButton[Vivant.tailleSac];

		JPanel sacADos=new JPanel(new GridLayout (5,1));
		JPanel equipement=new JPanel(new GridLayout (5,2));
		JTextArea stats = new JTextArea(1,1);
		stats.setEditable(false);

		ButtonGroup group= new ButtonGroup();
		JScrollPane scroll = new JScrollPane(sacADos);

		ChoixInventaireListener q = new ChoixInventaireListener();
		for(int j = 0; j< Vivant.tailleSac; j++){
			if(moteur.J.getItem(j)!="vide"){
				sac[j] =  new JButton(moteur.J.getItem(j));

				sac[j].addActionListener(q);
				sac[j].setEnabled(true);
				sacADos.add(sac[j]);
			}
		}

BoutonDesequiperListener j= new BoutonDesequiperListener();
		JButton []f=new JButton[9];
		for(int i=0;i<9;i++){
			f[i] = new JButton(moteur.J.getEquipementF(i));
			f[i].addActionListener(j);
		}

		for(int i=0;i<25;i++){

			switch(i){
				case 0:equipement.add(f[0]); break;
				case 2:equipement.add(f[1]); break;
				case 4:equipement.add(f[2]); break;
				case 7:equipement.add(f[3]); break;
				case 10:equipement.add(f[4]); break;
				case 12:equipement.add(f[5]); break;
				case 14:equipement.add(f[6]); break;
				case 18:equipement.add(f[7]); break;
				case 22:equipement.add(f[8]); break;
				default : equipement.add(new JLabel());
			}
		}


		stats.setText("Nom "+"\t"+moteur.J.getNom()+"\n"+
				"Niveau "+"\t"+moteur.J.getNiveau()+"\n"+
				"Force "+"\t"+moteur.J.getForce()+"\n"+
				"Agilite "+"\t"+moteur.J.getAgilite()+"\n"+
				"Intelligence "+"\t"+moteur.J.getIntelligence()+"\n"+
				"Chance "+"\t"+moteur.J.getChance()+"\n"+
				"vitalite "+"\t"+moteur.J.getVitalite()+"\n"+
				"Initiative "+"\t"+moteur.J.getInitiative()+"\n"+
				"Pods "+"\t"+moteur.J.getPods()+"\n"+
				"Points de caracteristique "+"\t"+moteur.J.getPtsCarateristique()+"\n");



		profil.add(equipement);
		profil.add(sacADos);
		profil.add(stats);

	}



	public JTabbedPane panelCentre(){

		centre = new JTabbedPane();
		profil = new JPanel(new GridLayout (2,2,1,1));

		mapp = new JPanel(new GridLayout (15,15,1,1));


		this.centre.add(mapp,"Map");
		creerSecond();
		this.centre.add(profil,"Inventaire");
		return this.centre;
		}

		public JPanel panelGauche(){

		BoutonListener n = new BoutonListener();
		JPanel gauche = new JPanel(new GridLayout (3,1,3,3));

		JPanel a = new JPanel(new GridLayout(4,1,3,3));

		a.add(new JLabel(moteur.J.getNom()));

		JButton b1 = new JButton ("Sauvegarder");
		b1.setEnabled(true);
		a.add(b1);

		JButton b2 = new JButton ("Parler");
		b2.setEnabled(false);
		a.add(b2);

		atq = new JButton ("Attaquer");
		atq.setEnabled(false);
		atq.addActionListener(n);
		a.add(atq);

		JPanel b = new JPanel();
		JTextArea jt=new JTextArea(2000,25);
		jt.setText(msg+"\n");
		b.add(jt);

		JPanel c = new JPanel(new GridLayout (3,3,3,3));
		c.add(new JPanel());;

		boutonH.setEnabled(true);
		boutonH.addActionListener(n);
		c.add(boutonH);
		c.add(new JPanel());

		boutonG.setEnabled(true);
		boutonG.addActionListener(n);
		c.add(boutonG);
		c.add(new JPanel());

		boutonD.setEnabled(true);
		boutonD.addActionListener(n);
		c.add(boutonD);
		c.add(new JPanel());

		boutonB.setEnabled(true);
		boutonB.addActionListener(n);
		c.add(boutonB);
		c.add(new JPanel());

		gauche.add(a);
		gauche.add(b);
		gauche.add(c);
		return gauche;
	}

	public void creerMapp(){

		for(int i=0;i<15;i++){
			for(int j=0;j<15;j++){
				mapp.add(new JLabel(""+moteur.m.affichage(i,j)));
			}
		}
	}

	void metAjour(){
		mapp.removeAll();
		creerMapp();

		mapp.revalidate();

		profil.removeAll();
		creerSecond();
		profil.revalidate();
	}

	public class BoutonDesequiperListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String s=e.getActionCommand();

			for(int i=0;i<9;i++){
				if(s.equals(moteur.J.getEquipementF(i))){
					moteur.J.desequiper(i);
				}
			}
			metAjour();
		}
	}

	private void creerOption(int i){

		JLabel label = new JLabel("Essayer les differents boutons");

		String[] choix = {"Equiper", "Jeter"};
		if(this.moteur.J.getItemType(i)=="Potion"){
			choix[0]="Utiliser";
		}
		int reponse = JOptionPane.showOptionDialog(this,
				"Que voulez-vous faire ?",
				"",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				choix,
				choix[1]);
		if (reponse == JOptionPane.YES_OPTION) moteur.J.equiper(i);
		else if (reponse == JOptionPane.NO_OPTION) moteur.J.jeter(i);
		metAjour();
	}

	public class ChoixInventaireListener implements ActionListener{
		public void actionPerformed(ActionEvent e){

			String s = e.getActionCommand();
			JOptionPane n = new JOptionPane();
			for(int i = 0; i< Vivant.tailleSac; i++){
				if(s.equals(moteur.J.getItem(i))){
					creerOption(i);
				}
			}
		}
	}
	public class BoutonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			String s = e.getActionCommand();

			if (s.equals("Gauche")) {
				moteur.m.deplacerJ('a', moteur.J);
			}
			else if (s.equals("Droite")) {
				moteur.m.deplacerJ('d', moteur.J);
			}
			else if (s.equals("Bas")) {
				moteur.m.deplacerJ('s', moteur.J);
			}
			else if (s.equals("Haut")) {
				moteur.m.deplacerJ('w', moteur.J);
			}
			else if(s.equals("Attaquer")){
				if(!JC.getEtat()) {
					disableMove();
					moteur.m.combat(JC, MC);
					enableMove();
				}
				else
					JC.atq(MC);
			}
			metAjour();
		}}
		public void disableMove(){

			boutonB.setEnabled(false);
			boutonH.setEnabled(false);
			boutonD.setEnabled(false);
			boutonG.setEnabled(false);
		}

	public void enableMove(){

		boutonB.setEnabled(true);
		boutonH.setEnabled(true);
		boutonD.setEnabled(true);
		boutonG.setEnabled(true);
	}

		public static void fen(){
		ihm =new Fenetre();


	}}
