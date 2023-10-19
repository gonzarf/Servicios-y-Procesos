/*Se debe simular una carrera de coches en un circuito cerrado.
 * La carrera constará de N pilotos, cada uno con su identificador asignado, siendo N una cantidad definida en una variable (no hace falta pedir al usuario este valor, lo pondremos desde código).
 * Los N pilotos serán hilos independientes, y tienen que hacer un total de 10 vueltas. En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
 * El hilo principal, una vez han salido los coches, va mostrando cada segundo cómo está actualmente el orden desde el primero (el que toma la delantera) hasta el décimo (el que va último), 
 * indicando el identificador, las vueltas que lleva y la posición de los participantes.*/

package threads;

import java.util.ArrayList;
import java.util.Random;

public class Coche extends Thread{
	
	private ArrayList<Coche> posiciones ;
	private int vueltas = 0;

	public Coche(ArrayList<Coche> posiciones, int vueltas) {

		this.posiciones = posiciones;
		this.vueltas = vueltas;
	}

	public ArrayList<Coche> getPosiciones() {
		return posiciones;
	}

	public void setPosiciones(ArrayList<Coche> posiciones) {
		this.posiciones = posiciones;
	}
	
	public int getVueltas() {
		return vueltas;
	}

	public void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public synchronized void run() {
		
		Random r = new Random();
		
		for(int i = 1; i <= 10;i++) {
			
			int tiempo = r.nextInt(500,3000);
			
			try {
				
				Thread.sleep(tiempo);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
			this.vueltas++;
		}

	}


	
}
