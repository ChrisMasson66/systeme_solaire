package main;

public class LanceurMeteorite {
	
	
	private Meteorite meteorite;
	private Facto_enum_meteor typeMeteorite;
	private CorpsCeleste cs;
	private boolean isCollision=false;
	
	private String messageRetourString ="";
	
	private static String eventPerimetre = "Météorite entrée dans le système solaire.";
	private static String eventCollision = "Météorite entrée en collision avec le système solaire, elle est détruite.";	
	private static String eventCollisionTueuse = "Météorite tueuse est entrée dans les systàème solaire et a détuit un corps céleste.";
	
	
	
	public LanceurMeteorite(Meteorite meteorite, Facto_enum_meteor typeMeteorite)
	{
		this.meteorite = meteorite;
		this.typeMeteorite = typeMeteorite;
		
	}
	
	//cas d'une collision
	 public boolean InterceptorPlanete(CorpsCeleste cs)
	 {
		 this.cs = cs;
		 
		 //test des coordonnées
		 if(this.meteorite.getPosition().getX() == this.cs.getPosition().getX() && this.meteorite.getPosition().getY()== this.cs.getPosition().getY())
		 {
			 //traite selon le type de météorite
			 switch(this.typeMeteorite)
			 {
			 
             case NORMAL :
            	 
            	 messageRetourString = eventCollision;
            	 isCollision =  true;
                 break;
      
             
             case TUEUSEPLANETE:
            	 
            	 messageRetourString = eventCollisionTueuse;
            	 isCollision =  true;
            	 break;

             default : 
            	 isCollision = false;
            	 break;
			 
			 
			 }		 
			 
		 }
		 
		 else {
			 isCollision = false;
		}
		 
		 return isCollision;
	 }
	
	 //retourne le messege info type de collision
	 public String getInfoEvent()
	 {
		 
		 return messageRetourString;
	 }
	 
	
	 private boolean InterceptorPerimetre(System_s s)
	 {
		 
		 
		return false; 
	 }
	
	 /*
	  *     NORMAL,
    TUEUSEPLANETE
	  * 
	  * */

}
