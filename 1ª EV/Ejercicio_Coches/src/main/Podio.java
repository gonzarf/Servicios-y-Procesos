package main;

import java.util.ArrayList;

import threads.Coche;

public class Podio {
	
	private ArrayList<Coche> orden = new ArrayList<>();

	public Podio(ArrayList<Coche> orden) {
		this.orden = orden;
	}

	public ArrayList<Coche> getOrden() {
		return orden;
	}

	public void setOrden(ArrayList<Coche> orden) {
		this.orden = orden;
	}
	
	public synchronized void vuelta(Coche c) {

		orden.remove(c); //Eliminamos el objeto de la lista
		
		
		//Comparamos las vueltas que lleva el Coche que llega primero a la funcion con el resto de coches que ya estaban en el arraylist. 
		
		for(int i = 0; i < orden.size(); i++) {
			if(c.getVueltas() > orden.get(i).getVueltas()) { //Si tine mas vueltas que alguno de los coches del arraylist
				orden.add(i,c);								//se añade en la posicion de ese coche 
				break;
			}
		}
		
		if(!orden.contains(c)) {   //Si el coche entrante no se ha añadido de nuevo   
			orden.add(c);		  //lo añadimos al final del arraylist
		}

	}
	
	public synchronized void mostrar() {
		
		System.out.println("Coche-------Vueltas-------Posicion\n");
		for(int i = 0;i<orden.size();i++) {
			System.out.println(orden.get(i).getNombre() + "          " + orden.get(i).getVueltas() + "           " + (i+1));
		}
		System.out.println("\n");
	}
	

}
