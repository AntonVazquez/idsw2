package Pck;

public class Persona {

	public int plantaDestino;
	public int plantaActual;
	public int contador;
	public int dni;
	public Ascensor as;
	public int estado=0; //0 creado 1 planta 2 esperando 3 ascensor 4 plantaDestino 5 esperando 6 ascensor 7 saliendo
	public Persona() {
		double nam = Math.floor(Math.random() * (1000 - 0)) + 0;
		int nams = (int) nam;
		this.dni=nams;
		double nam2 = Math.floor(Math.random()*(20-10))+10;
		int nams2 = (int) nam2;
		this.contador = nams2;
		double nam3 = Math.floor(Math.random()*(4-1))+1;
		int nams3 = (int) nam3;
		this.plantaDestino=nams3;
		double nam4 = Math.floor(Math.random()*(4-0))+0;
		int nams4 = (int) nam4;
		this.plantaActual= 0;
		
	}
}

