package main;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;



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
                 if (p.getClass() == Planet.class) {
                     ((Planet) p).turn();
                 }
             }
             
             
            for (CorpsCeleste c:this.corps)
 			{
                 
            	//récupération du CorpsCeleste
            	if(this.meteor != null) 
            	{
		            	//test d'évènement ou non
		            	 boolean isCollision = 	this.meteor.InterceptorPlanete(c);   
		            	 
		            	 //si vrai, alors event
		            	 if(isCollision!=false)
		            	 {
		            		 //récup de l'info de l'event
		            		 String info = this.meteor.getInfoEvent();
		            		 
		            		 InfoEvent event = new InfoEvent(c, info);
		            		  //on enregistre avec l'instance du singletosn      		 
		            		 Singleton.getInstance().addjson(event.toJSON());
		            		            		 		            		 
		            	 }
		            	 
		                 //sinon normal	on enregistre le corps celeste
		                 else {
		                 	
		                  	Singleton.getInstance().addjson(c.toJSON());
		     					
		     				}
           	 
            	}
            	//aucun météor
            	else 
            	{
            		Singleton.getInstance().addjson(c.toJSON());
				}
            	

            			
 			}

             Singleton.getInstance().wcycle();

         }
        
        
        
        

      
        Singleton.getInstance().printlog();
    }
}
