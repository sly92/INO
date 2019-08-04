package com.company;
import java.util.Random;


public class Combat {

	Joueur J;
	Monstre M;
	
	public Combat(Joueur j, Monstre m){
		this.J=j;
		this.M=m;

		System.out.print("Combat");
		Fenetre.ihm.setBoutonCombat(true);
		Fenetre.ihm.setMsg("que le combat commence");
		Fenetre.ihm.metAjour();
	}

	public int combat(Joueur j, Monstre m){

		this.J.setEtat(true);
		int vieM;
		while(this.J.getPtsVie()==0 || this.M.getPtsVie()==0){
			vieM= this.M.getPtsVie();
			if(vieM!=this.M.getPtsVie())
				this.M.atq(j);
		}
		this.J.setEtat(false);
		if(this.J.getPtsVie()==0) {
			this.J.mourrir();
			return 1;
		}
		else {
			this.M.mourrir();
			return 0;
		}
	}
}
