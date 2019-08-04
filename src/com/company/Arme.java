package com.company;

	/**
	 * Classe Arme
	 * @author Sly
	 * @version 1.1
	 * 2014-2015
	 */
		 
		public class Arme extends Objet {
			
			private int degatTerre;
			private int degatFeu;
			private int degatAir;
			private int degatEau;
			private int ptsDegats;
			
	
	 
		 public int getPtsDegats() {return this.ptsDegats;}
		 public void setPtsDegats(int ptsDegats) {this.ptsDegats = ptsDegats;}
	
	public  Arme(String nom, String type, int ptsAction,int ptsMouvement, int niveau, int vitalite, int force,int intelligence,int chance,int initiative,int resistence,int pods,int id ){
		super(nom, type,ptsAction,ptsMouvement, niveau,vitalite, force, intelligence, chance, initiative,resistence, pods, id);
		
	}
}
