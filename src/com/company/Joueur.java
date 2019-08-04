package com.company;
import java.util.Scanner;


public class Joueur extends Vivant {
	private Objet[] equipement= new Objet[9];
	private Objet o=null;
	
	
	public Joueur(String nom, String type, int id){
		super(nom,type,id);
	}
	
	public void equiper(int i){
			this.o = this.sac[i];
		
			if(o.getType().equals("Bouclier")){inter(i,0);}
			else if(o.getType().equals("Chapeau")){inter(i,1);}
			else if(o.getType().equals("Arme")){inter(i,2);}
			else if(o.getType().equals("Amulette")){inter(i,3);}
			else if(o.getType().equals("AnneauD")){inter(i,4);}
			else if(o.getType().equals("Ceinture")){inter(i,5);}
			else if(o.getType().equals("AnneauG")){inter(i,6);}
			else if(o.getType().equals("Cape")){inter(i,7);}
			else if(o.getType().equals("Botte")){inter(i,8);}
			else if(o.getType().equals("Potion")){utiliserPotion(i); }
}
	public void jeter(int i){
		this.removeSac(i);
	}
	
	public void utiliserPotion(int i){
		Potion p= (Potion) this.sac[i];
		    this.setPtsAction(p.getPtsAction());
		     this.setPtsMouvement(p.getPtsMouvement()); 
			 this.setPtsVie(p.getVie());
			 this.setForce(p.getForce()); 
		     this.setAgilite(p.getIntelligence());
		     this.setIntelligence(p.getIntelligence());
		     this.setChance(p.getChance());
		     this.setInitiative(p.getInitiative());
		     this.setPods(p.getPods());
		     this.setPtsCarateristique(p.getCaracteristique());
		     this.setPtsXp(p.getXp());
		    	this.removeSac(i);
		    
	}
		

public void inter(int i, int j){
	
	if(this.equipement[j]==null){this.equipement[j]=this.o;this.modifierStat(this.o,1);this.removeSac(i);}
	else{
		
		this.addSac(equipement[j]);
		this.modifierStat(o,-1);
		this.equipement[j]=this.o;
		this.modifierStat(this.o,1);
		this.removeSac(i);}
	}
	

	
	
		public void desequiper(int i){
			Objet d = getEquipement(i);
			if(d.getType().equals("Chapeau")){this.addSac(d);this.equipement[1]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Amulette")){this.addSac(d);this.equipement[3]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Anneau")){this.addSac(d);this.equipement[4]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Anneau")){this.addSac(d);this.equipement[6]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Ceinture")){this.addSac(d);this.equipement[5]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Cape")){this.addSac(d);this.equipement[7]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Botte")){this.addSac(d);this.equipement[8]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Arme")){this.addSac(d);this.equipement[2]=null; modifierStat(d,-1);}
			else if(d.getType().equals("Bouclier")){this.addSac(d);this.equipement[0]=null; modifierStat(d,-1);}
		
		}
	
	public void modifierStat(Objet o, int i){
		 this.setPtsAction(i*o.getPtsAction());
		    this.setPtsMouvement(i*o.getPtsMouvement());
			this.setVitalite(i*o.getVitalite());
			this.setForce(i*o.getForce()); 
		    this.setAgilite(i*o.getAgilite());
		    this.setIntelligence(i*o.getIntelligence());
		    this.setChance(i*o.getChance());
		    this.setInitiative(i*o.getInitiative());
	}
	
	
	public void ramasser(Objet l){
		
			if(this.getPods()-l.getPods()<0){
				Fenetre.ihm.setMsg(("Vous avez pas assez de pods"));}
			else{
			this.addSac(l);
			this.setPods(l.getPods());
			
			}
		}
		
	public Objet getEquipement(int i){
		if (this.equipement[i]==null)
			return null;
		else
			return this.equipement[i];
	}
	
	public String getEquipementF(int i){
		if (this.equipement[i]==null)
			return "";
		else
			return this.equipement[i].getNom();
	}
	
	 public void removeSac(int ii){
		
		 boolean flag=true;
	    	this.sac[ii]=null;
	    	
	    	for(int i=0;i<tailleSac-1 && flag==true;i++){
	    		if(sac[i]==null){
	    			sac[i]=sac[i+1];
	    		
	    			sac[i+1]=null;}
	    	}
	    	
	    	
	    }
	 
	 public void addSac(Objet m){
	    	boolean flag=true;
	    
	    	for(int i=0; i<tailleSac && flag==true;i++){
	    		if(this.sac[i]==null){
	    			
	    			this.sac[i]=m;
	    			flag=false;
	    		}
	    		
	    	}
	    }
	
	public void inventaire(){
		
	}
	
	public String toString(){
		return ""+this.getPods();
	}
}

