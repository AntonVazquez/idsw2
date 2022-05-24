package Pck;

import java.util.Scanner;



public class Edificio {
	
	public Planta[] plantas;
	public Ascensor[] ascensores;
	
      public Edificio() {
	   
	   Planta[] plantas = new Planta[5]; 
	   plantas[0] = new Planta(0);
	   plantas[1] = new Planta(1);
	   plantas[2] = new Planta(2);
	   plantas[3] = new Planta(3);
	   plantas[4] = new Planta(4);
	   this.plantas = plantas;
	   
	   Ascensor[] ascensores = new Ascensor[4];
	   ascensores[0] = new Ascensor(1,0);
	   ascensores[1] = new Ascensor(2,0);
	   ascensores[2] = new Ascensor(3,0);
	   ascensores[3] = new Ascensor(4,0);
	   this.ascensores = ascensores;
      }
     
      
    	  
      }
