package Pck;

import java.util.ArrayList;

public class Trayecto {
	int tiempo = 1000;
	Edificio f = new Edificio();
	ArrayList<Persona> p = new ArrayList<Persona>();
	
	
	
	public void imprimir() {
		String[][] table = new String[6][];
        table[0] = new String[] { " Nº ", "Personas en planta", " PersonasEsperando","Ascensor1","Ascensor2","Ascensor3","Ascensor4" };
        table[1] = new String[] { "Planta 4",String.valueOf(f.plantas[4].ocupacionPlanta)  , String.valueOf(f.plantas[4].personasEsperando),esAscen(f.ascensores[0],4),esAscen(f.ascensores[1],4),esAscen(f.ascensores[2],4),esAscen(f.ascensores[3],4)};
        table[2] = new String[] { "Planta 3", String.valueOf(f.plantas[3].ocupacionPlanta), String.valueOf(f.plantas[3].personasEsperando),esAscen(f.ascensores[0],3),esAscen(f.ascensores[1],3),esAscen(f.ascensores[2],3),esAscen(f.ascensores[3],3) };
        table[3] = new String[] { "Planta 2", String.valueOf(f.plantas[2].ocupacionPlanta), String.valueOf(f.plantas[2].personasEsperando),esAscen(f.ascensores[0],2),esAscen(f.ascensores[1],2),esAscen(f.ascensores[2],2),esAscen(f.ascensores[3],2) };
        table[4] = new String[] { "Planta 1", String.valueOf(f.plantas[1].ocupacionPlanta), String.valueOf(f.plantas[1].personasEsperando),esAscen(f.ascensores[0],1),esAscen(f.ascensores[1],1),esAscen(f.ascensores[2],1),esAscen(f.ascensores[3],1)};
        table[5] = new String[] { "Planta 0", String.valueOf(f.plantas[0].ocupacionPlanta), String.valueOf(f.plantas[0].personasEsperando),esAscen(f.ascensores[0],0),esAscen(f.ascensores[1],0),esAscen(f.ascensores[2],0),esAscen(f.ascensores[3],0) };


        for (String[] row : table) {
            System.out.format("%15s %15s %15s  %15s %15s %15s %15s %n", row);
        }
	}
	
	public String esAscen(Ascensor a,int planta) {
		if (a.pisoActual==planta) 
		{
			return String.valueOf(a.getOcupacion());
			
		}else {
			return "||";
		}
	}
	public static Ascensor masCercano(Ascensor[] numeros, int num) {
        int cercano = 0;
        int diferencia = Integer.MAX_VALUE; //inicializado valor máximo de variable de tipo int
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i].pisoActual == num) {
                return numeros[i];
            } else {
                if(Math.abs(numeros[i].pisoActual-num)<diferencia){
                    cercano=numeros[i].pisoActual;
                    diferencia = Math.abs(numeros[i].pisoActual-num);
                }
            }
        }
        return numeros[cercano];
        
    }

		
	public void start() {
		
		
		
	for(int i=0;i<tiempo;i++) {
		//System.out.println("Planta0: "+f.plantas[0].ocupacionPlanta+"\n Planta0Esperando: "+f.plantas[0].personasEsperando+"\n Planta1: "+f.plantas[1].ocupacionPlanta+"\n Planta1Esperando: "+f.plantas[1].personasEsperando+"\n Planta2: "+f.plantas[2].ocupacionPlanta+"\n Planta2Esperando: "+f.plantas[2].personasEsperando+"\n Planta3: "+f.plantas[3].ocupacionPlanta+"\n Planta3Esperando: "+f.plantas[3].personasEsperando+"\n Planta4: "+f.plantas[4].ocupacionPlanta+"\n Planta4Esperando: "+f.plantas[4].personasEsperando);
		imprimir();
		System.out.println(" ");
		System.out.println(" ");
		Ascensor c = new Ascensor(0,0);
		if(i%4==0) {
			Persona anton = new Persona();
			System.out.println(" ");
			System.out.println("Hola, soy"+anton.dni+"estoy en la planta: "+anton.plantaActual+"voy a la planta: "+anton.plantaDestino+" el tiempo: "+anton.contador);
			f.plantas[anton.plantaActual].añadirPersonas(1);
			
			p.add(anton);
		}
	    for(int j=0;j<p.size();j++) {
	    	Persona persona =p.get(j);
	    	if(persona.estado==0) {
	    		persona.estado++;
	    	}else if(persona.estado==1) {
	    		c = masCercano(f.ascensores,persona.plantaActual);
	    		persona.as=c;
	    		f.plantas[persona.plantaActual].esperarAscensor();
	    		persona.estado++;
	    		c.irAlPiso(persona.plantaActual);
	    	}else if(persona.estado==2) {
	    		c = persona.as;
	    		
	    		c.setocupacion(f.plantas[persona.plantaActual].personasEsperando);
	    		f.plantas[persona.plantaActual].cogerAscensor();
	    		
	    		
	    		persona.estado++;
	    	}else if(persona.estado==3) {
	    		c = persona.as;
	    		c.irAlPiso(persona.plantaDestino);
	    		persona.estado++;
	    	}
	    		
	    	else if(persona.estado==4) {
	    	
	    		
	    		persona.plantaActual=persona.plantaDestino;
	    		c = persona.as;
	    		c.setocupacion(0);
	    		
	    		f.plantas[persona.plantaActual].añadirPersonas(1);
	    		persona.contador--;
	    		persona.estado++;
	    		
	    	}else if(persona.estado==5) {
	    		persona.contador--;
	    		if(persona.contador==0) {
	    			persona.estado++;
	    			persona.plantaDestino=0;
	    		}
	    	}
	    		
	    	else if(persona.estado==6) {
	    		c = masCercano(f.ascensores,persona.plantaActual);
	    		persona.as=c;
	    		f.plantas[persona.plantaActual].esperarAscensor();
	    		persona.estado++;
	    		c.irAlPiso(persona.plantaActual);
	    	}else if(persona.estado==7) {
	    		c = persona.as;
	    		c.setocupacion(f.plantas[persona.plantaActual].personasEsperando);
	    		f.plantas[persona.plantaActual].cogerAscensor();
	    		
	    		
	    		persona.estado++;
	    	}else if(persona.estado==8) {
	    		c = persona.as;
	    		c.irAlPiso(persona.plantaDestino);
	    		persona.estado++;
	    	}
	    		if(persona.estado==9) {
	    	
	    		c = persona.as;
	    		
	    		c.setocupacion(0);
	    		f.plantas[persona.plantaActual].añadirPersonas(1);
	    		persona.estado++;
	    	}else if(persona.estado==10) {
	    		f.plantas[persona.plantaActual].ocupacionPlanta--;
	    		System.out.println("Soy: "+persona.dni+" me voy");
	    		p.remove(persona);
	    	}
	    }
		
	    try {
			
				Thread.sleep(1000);
				
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}
		
	}
	
		
	}
