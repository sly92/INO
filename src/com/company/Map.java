package com.company;

import java.util.Random;
import java.util.Scanner;


public class Map {

	
	private char direction;
	private static int ligne = 15;
	private static int colonne = 15;
	private Object [][] grille ;
	
	public Map(){
		//cree grille
		this.grille = new Object[this.ligne][this.colonne];
	    for (int i=0;i<this.ligne;i++){
            for (int j=0;j<this.colonne;j++){
                if(i==0 || j==0 ||i==this.ligne-1 || j==this.colonne-1)
                    this.grille[i][j] = new String(" # ");
                else
                    this.grille[i][j] = new String("   ");
            }
    }
	   
	}
	
	public int[] placer(Object o) {
		int[] pos= null;
		boolean flag=true;
		
		do{ 
			Random rand = new Random();
			int n1 = rand.nextInt(13) + 1;
			int n2 = rand.nextInt(13) + 1;
		
	                if(this.grille[n1][n2].equals("   ")){
	                    this.grille[n1][n2] = o;
	                     pos = new int[] {n1, n2};

	                    flag=true;
	                }
	                else
	                	flag=false;

	}while(flag=false);
		return pos;
	}
	
	public String affichage(int a, int b){
		String [][] tmp = new String[ligne][colonne];
		
		 for (int i=0;i<ligne;i++){
	            for (int j=0;j<colonne;j++){
	                if(grille[i][j] instanceof Joueur){
	            	tmp[i][j]= " J ";}
	                else if(grille[i][j] instanceof Monstre){
	                	tmp[i][j] =" M ";}
	                else if(grille[i][j] instanceof Potion){
	                	tmp[i][j] =" P ";}
	                else if(grille[i][j] instanceof Objet){
	                	tmp[i][j] =" O ";}
	                else if(grille[i][j] instanceof Potion){
	                	tmp[i][j] =" P ";}
	                else if(grille[i][j] instanceof Arme){
	                	tmp[i][j] =" A ";}
	                else{
	                	tmp[i][j]= (String) (grille[i][j]);}
	                
	            }
	             
	            
	    } 
		return  tmp[a][b];
	}

	public void deplacerJ(char direction,Joueur J){
		int a = 0;	
		int b = 0;
		int x=0;
		int y=0;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		switch (direction){
		case 'w': a = -1;  //haut
    break;
		case 'a': b = -1;  //gauche
    break;
		case 's': a =  1;	 //bas
    break;
		case 'd': b =  1 ; //droite
		}
		for(int i=0; i<this.ligne;i++){
			for(int j=0; j<this.colonne;j++){  //On cherche la position du joueur
				if(grille[i][j].equals(J)){
					x=i;
					y=j; ;
				}}}
				
					if((x+a)>=1 || (b+y)>=1 || (a+x)<=(this.ligne-1) || (y+b)<=(this.colonne-1)){
					if(grille[x+a][y+b].equals("   ")){
					
						grille[x+a][y+b] = J;
						grille[x][y] = "   ";	
						
					}
					else if(grille[x+a][y+b] instanceof Objet){
			
						
						
						J.ramasser((Objet)grille[x+a][y+b]);//si il le ramasse on l'enleve de la map
							grille[x+a][y+b] = J;
						grille[x][y] = new String("   ");
						
						}
					else if(grille[x+a][y+b] instanceof Monstre){
						Fenetre.ihm.setBoutonAttaquer(true);
						Fenetre.MC=(Monstre) grille[x+a][y+b];
						Fenetre.JC=(Joueur)grille[x][y];

						}
					}
					}

	public void combat(Joueur j, Monstre m) {
		Combat c = new Combat(j, m);
		int n = c.combat(j, m);
		if(n==0)
			grille[m.getPos()[0]][m.getPos()[1]] = "   ";
	}
}

