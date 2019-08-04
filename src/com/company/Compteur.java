package com.company;


public class Compteur extends Thread {


	private int valeur;
	private static int pa = 0;

	public Compteur(int val) {
		valeur = val;
	}

	public void run() {
		while (pa < 6) {
			try {
				for (int i = 0; i < 30; i++) { //4h 14400
					valeur = i;

					sleep(1000);
				}
				pa++;
			} catch (InterruptedException e) {
				return;
			}

		}
		System.out.println("Vous avec recupere tout vos point d'action !");
	}

	public int getValeur() {
		return this.valeur;
	}

	public static int getPa() {
		return pa;
	}

	public static void setPa(int pa) {
		Compteur.pa = pa;
	}

	public void attributionPa(Joueur j) {
		//if(j.setPtsAction(j.getPtsAction()+1)==1)
		System.out.println("Vous venez de gagner 1 PA !");
	}
}