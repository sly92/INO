package com.company;

/**
 * Classe Armure
 * @author Sly
 * @version 1.0
 * 2014-2015
 */
public class Armure extends Objet {
    
     public Armure(String nom, String type, int ptsAction, int ptsMouvement,
			int niveau, int vitalite, int force, int intelligence, int chance,
			int initiative, int resistence, int pods, int id) {
		super(nom, type, ptsAction, ptsMouvement, niveau, vitalite, force,
				intelligence, chance, initiative, resistence, pods, id);
		// TODO Auto-generated constructor stub
	}
	private int ptsArmure;

    public int getPtsArmure() {return this.ptsArmure;}
    public void setPtsArmure(int ptsArmure) {this.ptsArmure = ptsArmure;}

}