package main;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;



import netscape.javascript.JSObject;

public class System_s {
    private String nom;
    private List<CorpsCeleste> corps = new ArrayList<>();
    private LanceurMeteorite meteor;

    public System_s(String nom) {
        this.nom = nom;
    }

    //init systeme avec un météor
    public System_s(String nom, LanceurMeteorite meteor) {
        this.nom = nom;
        this.meteor = meteor;
    }

    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<main.CorpsCeleste> getCorps() {
        return corps;
    }

    public void setCorps(List<main.CorpsCeleste> corps) {
        this.corps = corps;
    }
    
    public void addCorp(CorpsCeleste cc){
        corps.add(cc);
    }
    
    public CorpsCeleste findById(int id){
        for(CorpsCeleste cc : this.corps){
            if(cc.getId() == id){
                return cc;
            }
        }
        return null;
    }

    public void turnall(int j) throws FileNotFoundException {

        Logmachine l = new Logmachine();

        for (int i = 0; i < j; i++) 
        
        {
            for (CorpsCeleste p : this.corps)           
            {
            	
            	//récupération du CorpsCeleste
            	if(this.meteor != null) 
            	{
            		//test d'évènement ou non
            	 boolean isCollision = 	this.meteor.InterceptorPlanete(p);   
            	 
            	 //si vrai, alors event
            /*	 if(isCollision!=false)
            	 {
            		 String info = this.meteor.getInfoEvent();
            		 
            		 InfoEvent event = new InfoEvent(p, info);
            		         		 
            		 Singleton.getInstance().addjson(event.toJSON());
            		 
            		 Singleton.getInstance().addjson(p.toJSON());
            		 
            		 //System.out.print("COLLISION");
            		 
            	 }*/
            	 
            	 
            }
            	
            	            	
                if (p.getClass() == Planet.class)                 
                {
                    ((Planet) p).turn();
                    
                }
            }
            
            
            
            for (CorpsCeleste c:this.corps)
            
            {
                Singleton.getInstance().addjson(c.toJSON());
            }

            Singleton.getInstance().wcycle();

        }
        Singleton.getInstance().printlog();
    }
}
