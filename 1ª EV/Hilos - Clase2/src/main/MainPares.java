package main;

import threads.HiloPares;

public class MainPares {
	
	
	//EL PROGRAMA DEBE DECIR SI TODOS LOS NUMEROS DEL ARRAY SON PARES.
	public static void main(String[] args) {
		int[] numeros = {1, 5, 20, 17, 8, -1, 61, 100};
		
		
		HiloPares h1 = new HiloPares(numeros, 0, numeros.length/2, true);
		HiloPares h2 = new HiloPares(numeros, numeros.length/2, numeros.length, true);

		h1.start();
		h2.start();


		try {
			
			h1.join();
			h2.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (!h1.isResultado() || !h2.isResultado()) {
			
			System.out.println("Hay numeros que no son pares");
			
		}else {
			System.out.println("Todos los numeros son pares");
		}
		
	}

}
