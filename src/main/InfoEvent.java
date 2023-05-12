package main;

//class pour envoyer l'info collision qui sera transformé en JSON
public class InfoEvent {
	
	private CorpsCeleste celeste;
	private String infoString;
	
	
	public InfoEvent(CorpsCeleste celeste,String infoString )
	{
		
		this.celeste = celeste;
		this.infoString = infoString;
	}
	
	//renvoi pour l'entrée dans le fichier log
    public String toJSON()
    {
        return "{'x':"+this.celeste.getPosition().getX()+", 'y':"+this.celeste.getPosition().getY()+", 'Astre':"+this.celeste.getName()+","+this.infoString+"}";
    }
	

}
