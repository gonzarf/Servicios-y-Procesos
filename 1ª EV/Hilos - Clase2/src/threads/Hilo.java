package threads;

import java.util.Random;

public class Hilo extends Thread{
	
	public Hilo(String name) {
		setName(name);
	}

	@Override
	public void run() {
		
		Random r = new Random();
		
		try {
			
			Thread.sleep(r.nextLong(100, 1001));
			
		} catch (InterruptedException e1) {
	
			e1.printStackTrace();
		}
		
		System.out.println("Hola soy " + getName());
		
	}

}
