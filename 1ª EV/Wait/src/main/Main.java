package main;

import hilos.HiloConsumidor;
import hilos.HiloProductor;
import shared.ListaCompartida;

public class Main {

	public static void main(String[] args) {
		ListaCompartida lista = new ListaCompartida();
		HiloConsumidor consumidor = new HiloConsumidor(lista);
		HiloProductor productor = new HiloProductor(lista);
		
		productor.start();
		consumidor.start();

		
		try {
			productor.join();
			consumidor.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
