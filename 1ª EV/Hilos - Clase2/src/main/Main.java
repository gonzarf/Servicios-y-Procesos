package main;

import threads.Hilo;

public class Main {

	public static void main(String[] args) {
		
		//EN EL CASO DE QUE HILO IMPLEMENTE RUNNABLE
		//Thread t1 = new Thread(new Hilo());
		
		Hilo h1 = new Hilo("H1");
		Hilo h2 = new Hilo("H2");
		Hilo h3 = new Hilo("H3");
		
		h1.start();
		h2.start();		
		h3.start();
		
		
		try {
			
			h1.join();
			h2.join();
			h3.join();
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		System.out.println("Soy el MAIN y he  terminado");
	}

}
