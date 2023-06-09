import main.*;
import org.json.JSONObject;
import java.io.*;

import static main.Facto_enum.*;


public class Main {
    public static void main(String[] args) throws IOException {
   
        System.out.println("Hello world!");
        
        JSONObject sun = Tools.jsonFileToJsonObject("sun.json");
        
        Etoile soleil = (Etoile) Factorycorpceleste.facto_cc(ETOILE,sun);
        
        JSONObject earth = Tools.jsonFileToJsonObject("earth.json");
        
        Planet terre = (Planet) Factorycorpceleste.facto_cc(PLANET , earth);
        
        JSONObject moon = Tools.jsonFileToJsonObject("moon.json");
        
        JSONObject jmars = Tools.jsonFileToJsonObject("mars.json"); 
        
        Planet mars = (Planet)Factorycorpceleste.facto_cc(PLANET,jmars);
        
        Satellite lune = (Satellite) Factorycorpceleste.facto_cc(SATELLITE,moon);
        
        JSONObject phob = Tools.jsonFileToJsonObject("phobos.json");
        
        Satellite phobos = (Satellite) Factorycorpceleste.facto_cc(SATELLITE,phob);
        
        System.out.println(soleil.getName());
        
        terre.add_satellite(lune);
        
        mars.add_satellite(phobos);
        
        System.out.println(terre.getName());
        
        terre.turn();
        
        System.out.println(terre.pos_to_string());
        System.out.println(lune.pos_to_string());
        System.out.println(terre.distance(soleil));
        System.out.println(terre.getClass());
        
        //init nouvelle météorite
        Meteorite nabilla =new Meteorite(1, "NABILLA", 0, 0, new Position(1.489118235293327E8, 5125311.031427594));//pour test
        
        //init lanceur du type météorite NORMAL
        LanceurMeteorite eventNabilla = new  LanceurMeteorite(nabilla, Facto_enum_meteor.NORMAL);
        
        System_s sol = new System_s("Systaire", eventNabilla);
        
        sol.addCorp(soleil);
        sol.addCorp(terre);
        sol.addCorp(lune);
        sol.addCorp(mars);
        sol.addCorp(phobos);
        sol.turnall(800);


    }
}