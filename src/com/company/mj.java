package com.company;

public class mj {

	 public static Joueur J;
	 public Monstre M =new Monstre("carapuce","monstre",1);
	 public Potion P = new Potion("Potion Magique","Potion",0,0, 0,50, 50,50,50,50,0,20,10,10,5,200);
	 public Map m;

	 public mj() {

		 this.J = new Joueur(FenetreD.getnom(), "joueur", 1);
		 this.m = new Map();
		 J.setPos(m.placer(J));
		 P.setPos(m.placer(P));
		 M.setPos(m.placer(M));

		 Objet o = new Objet("Colier du prince", "Amulette", 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 101);
		 Objet f = new Objet("Colier de la princeesse", "Amulette", 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 102);
		 Objet a = new Objet("Chapeau du pandawan", "Chapeau", 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 103);
		 Objet x = new Objet("Botte de l'éclaireur", "Botte", 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 104);
		 Objet y = new Objet("Cape du voleur", "Cape", 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 105);
		 Objet z = new Objet("Ceinture du désert", "Ceinture", 1, 1, 1, 10, 10, 10, 10, 10, 10, 10, 106);
		 x.setPos(m.placer(x));
		 y.setPos(m.placer(y));
		 z.setPos(m.placer(z));
		 o.setPos(m.placer(o));
		 f.setPos(m.placer(f));
		 a.setPos(m.placer(a));

		 J.toString();
	 }

	}
	


