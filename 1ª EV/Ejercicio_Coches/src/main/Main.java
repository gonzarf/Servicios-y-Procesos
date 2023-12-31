/*Se debe simular una carrera de coches en un circuito cerrado.
 * La carrera constará de N pilotos, cada uno con su identificador asignado, siendo N una cantidad definida en una variable (no hace falta pedir al usuario este valor, lo pondremos desde código).
 * Los N pilotos serán hilos independientes, y tienen que hacer un total de 10 vueltas. En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
 * El hilo principal, una vez han salido los coches, va mostrando cada segundo cómo está actualmente el orden desde el primero (el que toma la delantera) hasta el décimo (el que va último), 
 * indicando el identificador, las vueltas que lleva y la posición de los participantes.*/

package main;

import java.util.ArrayList;

import threads.Coche;

public class Main {

	public static void main(String[] args) {

		ArrayList<Coche> coches = new ArrayList<>();
		Podio podio = new Podio(coches);

		for (int i = 0; i < 10; i++) {

			Coche h = new Coche("Coche-" + (i + 1), podio);
			coches.add(h);

		}
		
		for (Coche hilo : coches) {
			hilo.start();
		}

		while(quedanCoches(coches)) {
						try {
				Thread.sleep(1000);
				podio.mostrar();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//El metodo mira si hay coches que no han llegado a 10 vueltas
	//si alguno no ha llegado, devuelve un true
	//si han llegado todos, devuelve false
	
	public static boolean quedanCoches(ArrayList<Coche> coches) {

		for (int i = 0; i < 10; i++) {
			
			if (coches.get(i).getVueltas() != 10) {
				return true;
			} else {

			}

		}

		return false;

	}

}
