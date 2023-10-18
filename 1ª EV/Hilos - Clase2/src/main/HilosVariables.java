package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import threads.HiloProductor;

public class HilosVariables {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<HiloProductor> hilos =  new ArrayList<>();
		int[] numeros;
		int cantidad;
		
		System.out.println("Introduce la cantidad de numeros que quieres: ");
		cantidad = sc.nextInt();
		
		numeros = new int[cantidad];
		
		for(int i =0; i<cantidad;i++ ) {
			//CREAMOS NUEVO HILO Y LE PASAMOS SU POSICION
			HiloProductor newHilo = new HiloProductor(numeros, i);
			
			//AÑADIMOS HILO AL ARRAYLIST
			hilos.add(newHilo);
			//ARRANCAMOS EL HILO
			newHilo.start();
		}
		
		try {
			
			//ESPERAR A TODOS LOS HILOS
			for(HiloProductor hilo : hilos) {
				hilo.join();
			}
			
			//MOSTRAR EL ARRAY
			System.out.println(Arrays.toString(numeros));
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
	}

}
