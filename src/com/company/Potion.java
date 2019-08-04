package com.company;

public class Potion extends Objet {
	private int vie;
	private int xp;
	private int caracteristique;
	public Potion(String nom, String type, int ptsAction,int ptsMouvement, int niveau, int vitalite, int force,int intelligence,int chance,int initiative,int resistence,int vie,int xp,int caracteristique,int pods,int id ){
		super(nom,type,ptsAction,ptsMouvement,niveau,vitalite,force,intelligence,chance,initiative,resistence,pods,id);
		this.vie=vie;
		this.xp=xp;
		this.caracteristique=caracteristique;
	}

	public int getVie(){return this.vie;}
	
	public int getXp(){return this.xp;}
	
	public int getCaracteristique(){return this.caracteristique;}
}
