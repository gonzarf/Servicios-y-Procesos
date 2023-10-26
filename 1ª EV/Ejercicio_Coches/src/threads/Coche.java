/*Se debe simular una carrera de coches en un circuito cerrado.
 * La carrera constará de N pilotos, cada uno con su identificador asignado, siendo N una cantidad definida en una variable (no hace falta pedir al usuario este valor, lo pondremos desde código).
 * Los N pilotos serán hilos independientes, y tienen que hacer un total de 10 vueltas. En completar cada vuelta tardan un tiempo aleatorio de 0.5 a 3 segundos.
 * El hilo principal, una vez han salido los coches, va mostrando cada segundo cómo está actualmente el orden desde el primero (el que toma la delantera) hasta el décimo (el que va último), 
 * indicando el identificador, las vueltas que lleva y la posición de los participantes.*/

package threads;

import java.util.Random;

import main.Podio;

public class Coche extends Thread{
	
	private int vueltas = 0;
	private String nombre;
	private Podio podio;


	public Coche(String nombre, Podio podio) {

		this.nombre = nombre;
		this.podio = podio;
	}
	
	public Coche(){
		
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getVueltas() {
		return vueltas;
	}

	public void setVueltas(int vueltas) {
		this.vueltas = vueltas;
	}

	public synchronized void run() {
		
		Random r = new Random();
		int tvuelta = r.nextInt(500,3000);

		
		for(int i = 0; i<10; i++) {
			
			try {
				Thread.sleep(tvuelta);
				vueltas++;
				podio.vuelta(this);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}

	}


	
}
