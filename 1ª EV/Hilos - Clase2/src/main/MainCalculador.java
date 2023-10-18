package main;

import threads.HiloCalculador;

public class MainCalculador {
	
	// SE QUIERE OBTENER LA SUMA DE TODOS LOS NUMEROS UE VAN DEL 1 AL 40.000.000
	
	public static void main(String[] args) {
		
		long[] resultados = new long[2];
		
		HiloCalculador hc1 = new HiloCalculador(1, 19999999, resultados, 0);
		HiloCalculador hc2 = new HiloCalculador(20000000, 40000000, resultados, 1);
		
		hc1.start();
		hc2.start();
		
		try {
			hc1.join();
			hc2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("El resultado es: " + (resultados[0] + resultados[1]));

		
	}

}
