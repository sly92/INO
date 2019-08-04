package com.company;

public class Objet {

	private String nom;
	private String type;
    private int ptsAction;
    private int ptsMouvement;
    private int niveau;
 
    private int vitalite;
    private int force;
    private int agilite;
    private int intelligence;
    private int chance;
    private int initiative;
    private int resistance;
    private int pods;
    private int id;
    private int[] pos;
    
    public Objet(String nom, String type, int ptsAction,int ptsMouvement, int niveau, int vitalite, int force,int intelligence,int chance,int initiative,int resistence,int pods,int id ){
   	 this.nom=nom;
   	 this.type=type;
   	 this.ptsAction=ptsAction;
   	 this.ptsMouvement=ptsMouvement;
   	 this.niveau=niveau;
   	 this.vitalite=vitalite;
   	 this.force=force;
   	 this.agilite=agilite;
   	 this.intelligence=intelligence;
   	 this.chance=chance;
   	 this.initiative=initiative;
   	 this.resistance=resistance;
   	 this.pods=pods;
   	 this.id=id;
   	 this.type=type;
    }
    public String getNom(){return this.nom;}
 
    public int getPtsAction(){return this.ptsAction;}
    public int getPtsMouvement(){return this.ptsMouvement;}
    public int getNiveau() {return this.niveau;}
  
	public int getVitalite() {return this.vitalite;}
	public int getForce() {return this.force;}
    public int getAgilite(){return this.agilite;}
    public int getIntelligence(){return this.intelligence;}
    public int getChance(){return this.chance;}
    public int getInitiative(){return this.initiative;}
    public int getPods(){return this.pods;}
    public String getType(){return this.type;}

    public int[] getPos(){return this.pos;}
    public void setPos(int[] pos){ this.pos=pos;}
}
