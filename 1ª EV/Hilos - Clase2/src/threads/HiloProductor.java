package threads;

import java.util.Random;

public class HiloProductor extends Thread{
	
	private int[] numeros;
	private int pos;
	
	public HiloProductor(int[] numeros, int pos) {
		this.numeros = numeros;
		this.pos = pos;
	}
	
	public void run() {
		numeros[pos] = new Random().nextInt(numeros.length);
	}
}
