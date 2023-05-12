package main;



public class Meteorite{
	
	private String name;
    private double vitesseX;
    private double vitesseY;
    private Position position;
    private int id;
    


    private int distance_orbit;

    
    public Meteorite(int id, String name, double vitesseX, double vitesseY, Position position) {

    	this.id = id;
    	this.name=name;
    	this.vitesseX = vitesseX;
    	this.vitesseY = vitesseY;
    	this.position = position;
    	
    }

    
    
    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getVitesseX() {
		return vitesseX;
	}


	public void setVitesseX(double vitesseX) {
		this.vitesseX = vitesseX;
	}


	public double getVitesseY() {
		return vitesseY;
	}


	public void setVitesseY(double vitesseY) {
		this.vitesseY = vitesseY;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public int getDistance_orbit() {
		return distance_orbit;
	}


	public void setDistance_orbit(int distance_orbit) {
		this.distance_orbit = distance_orbit;
	}



	
}
