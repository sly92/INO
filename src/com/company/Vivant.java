package com.company;


import javax.swing.*;

public class Vivant {

	private String nom;
	private String type;
    private int ptsAction;
    private int ptsMouvement;
    private int niveau;
    private int ptsVie;
    private int vitalite;
    private int force;
    private int agilite;
    private int intelligence;
    private int chance;
    private int initiative;
    private int pods;
    private int pCaracteristique;
    private int ptsXp;
	private int id;
	private int or;
	public final static int tailleSac=30;
	private int[] pos;

	
    private boolean etat; //0 libre 1 en combat
    protected Objet []sac;
	
    public Vivant(String nom, String type, int id){
    	 this.nom=nom;
    	 this.type=type;
    	 this.ptsAction=6;
    	 this.ptsMouvement=3;
    	 this.niveau=1;
    	 this.ptsVie=50;
    	 this.vitalite=0;
    	 this.force=0;
    	 this.agilite=0;
    	 this.intelligence=0;
    	 this.chance=0;
    	 this.initiative=1000;
    	 this.pods=1000;
    	 this.pCaracteristique=5;
    	 this.ptsXp=0;
    	 this.id=0;
    	 this.or=0;
    	 this.etat=false; //0 libre 1 en combat
	     this.sac= new Objet[tailleSac];
    }

    public void atq(Vivant v){
        int degat = 5 + (int)(Math.random() * ((this.getForce() - 5) + 1));
        v.setPtsVie(v.ptsVie-degat);
    }

    public boolean getEtat(){return this.etat;}

    public String getItem(int i){
    	String a= "";
    		if(this.sac[i]!=null){a=this.sac[i].getNom(); }
    		else if(this.sac[i]==null)	{a="vide";}
    	return a;
    }
    public String getItemType(int i){
        String a= "";
            if(this.sac[i]!=null){a=this.sac[i].getType(); }
        return a;
    }

    public void mourrir(){
        if(this.getType().equals("joueur")) {
            JOptionPane.showMessageDialog(null, "You are dead ! :/");
//            FenetreD fd = new FenetreD();
//            fd.initialise();
        }
        else
            JOptionPane.showMessageDialog(null, "You kill it !");
    }


    public String getNom(){return this.nom;}
    public String getType(){return this.type;}
    public int getPtsAction(){return this.ptsAction;}
    public int getPtsMouvement(){return this.ptsMouvement;}
    public int getNiveau() {return this.niveau;}
    public int getPtsVie(){return this.ptsVie;}
    public int getVitalite() {return this.vitalite;}
    public int getForce() {return this.force;}
    public int getAgilite(){return this.agilite;}
    public int getIntelligence(){return this.intelligence;}
    public int getChance(){return this.chance;}
    public int getInitiative(){return this.initiative;}
    public int getPods(){return this.pods;}
    public int getPtsCarateristique(){return this.pCaracteristique;}
    public int getPtsXp(){return this.ptsXp;}
    public int getId(){return this.id;}
    public int getOr(){return this.or;}
    public void setNom(String nom){ this.nom=nom;}
    public void setType(String type){ this.type=type;}
    public void setPtsAction(int ptsAction){ this.ptsAction+=ptsAction;}
    public void setPtsMouvement(int ptsMouvement){ this.ptsMouvement+=ptsMouvement;}
    public void setNiveau(int niveau) { this.niveau+=niveau;}
    public void setPtsVie(int ptsVie){ this.ptsVie+=ptsVie;}
    public void setVitalite(int vitalite) { this.vitalite+=vitalite; this.ptsVie+=vitalite;}
    public void setForce(int force) { this.force+=force; this.pods+=(force/10);}
    public void setAgilite(int agilite){ this.agilite=agilite; this.initiative+=(agilite/5);}
    public void setIntelligence(int intelligence){ this.intelligence+=intelligence;}
    public void setChance(int chance){ this.chance+=chance;}
    public void setInitiative(int initiative){ this.initiative+=initiative;}
    public void setPods(int pods){ this.pods-=pods;}
    public void setPtsCarateristique(int caracteristique){ this.pCaracteristique+=caracteristique;}
    public void setPtsXp(int xp){ this.ptsXp+=xp;
        if(this.ptsXp==niveau*1000)
            this.niveau+=1;
        setPtsCarateristique(5);
    }
    public void setId(int id){ this.id= id;}
    public void setEtat(boolean etat){ this.etat=etat;}

    public int[] getPos(){return this.pos;}
    public void setPos(int[] pos){ this.pos=pos;}
	
}
