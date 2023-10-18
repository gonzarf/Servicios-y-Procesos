package threads;

import java.util.ArrayList;
import java.util.Random;

public class Hilo extends Thread{
	
	private ArrayList<Integer> resultados;
	
	
	
	public Hilo(ArrayList<Integer> resultados) {

		this.resultados = resultados;
	}



	public void run() {
		
		Random r = new Random();
		int resultado = r.nextInt(0,2);
		
		synchronized (resultados) {
			resultados.add(resultado);

		}
		
		
		
	}
	
	

}
