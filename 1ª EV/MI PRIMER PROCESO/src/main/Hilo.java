package main;

public class Hilo extends Thread{
	
	public Hilo(String nombre) {
		setName(nombre);
	}
	
	public void run() {
		
		System.out.println("Hola soy " + getName());
		
		for(int n = 1; n<=100; n++) {
			
			System.out.println(getName() + ": " + n);
		}
	}
}
