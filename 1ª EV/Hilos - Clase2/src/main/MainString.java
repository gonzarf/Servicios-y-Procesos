package main;

import threads.HiloString;

// CREAR DOS HILOS Y QUE BUSQUEN DENTRO DE UNA CADENA EL NUMERO DE VOCALES (MAYUSCULAS Y MINUSCULAS) QUE TIENE.
public class MainString {

	public static void main(String[] args) {
		
		String cadena = "HolamellamoGonzalo";
		
		HiloString h1 = new HiloString(cadena, 0, 0, cadena.length()/2);
		HiloString h2 = new HiloString(cadena, 0, cadena.length()/2, cadena.length());
		
		h1.start();
		h2.start();
		
		try {
			
			h1.join();
			h2.join();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

		
		System.out.println("El resultado es: " + (h1.getSum() + h2.getSum()));

	}

}
