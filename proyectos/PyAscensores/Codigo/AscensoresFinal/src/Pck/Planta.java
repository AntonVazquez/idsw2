package Pck;

public class Planta {

public int piso;
public int ocupacionPlanta;
public int personasEsperando;



 public Planta(int pis){
   this.piso=pis;
   this.ocupacionPlanta=0;
   this.personasEsperando=0;
 }
 
 public Planta(){
   
 }
 
public void aņadirPersonas(int n){
  this.ocupacionPlanta=this.ocupacionPlanta+n;
}

public  void esperarAscensor(){
  this.personasEsperando++;
}

public  void cogerAscensor(){
  this.ocupacionPlanta=this.ocupacionPlanta-this.personasEsperando;
  this.personasEsperando=0;
  
}
}
