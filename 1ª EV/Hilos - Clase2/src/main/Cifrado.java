package main;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import threads.HiloCifrado;
import threads.HiloProductor;

public class Cifrado {

	public static void main(String[] args) {
		//EL USUARIO INTRODUCE UNA CADENA
		//INTRODUCIMOS UN NUMERO DE CIFRADO QUE ES UN ENTERO
		//CONVERTIR LA CADENA EN UNA CADENA CIFRADA
		//CODIGO DE CIFRADO: 20 
		//HOLA
		//H --> H + 20
		//O --< O +20
		//ETC
		Scanner sc = new Scanner(System.in);
		ArrayList<HiloCifrado> hilos =  new ArrayList<>();
		

		
		System.out.println("Introduce una contrasena: ");
		String password = sc.nextLine();

		char[] newPassword = new char[password.length()];
		
		System.out.println("Introduce el codigo de cifrado: ");
		int codigo = sc.nextInt();
		
		for (int i = 0; i<password.length(); i++) {
			
			HiloCifrado newHilo = new HiloCifrado(password,newPassword,i,codigo);

			hilos.add(newHilo);
			
			newHilo.start();
		}
		
		try {
			
			for(HiloCifrado hilo : hilos) {
				
				hilo.join();
			}
			
			String resultado = ""; 
			for(int i=0; i<newPassword.length; i++) {
				resultado += newPassword[i];
			}
			System.out.println("Contraseña cifrada: " + resultado);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			
		}
		
		
	}

}
