package main;

import java.util.ArrayList;

import threads.CuentaBancaria;
import threads.HiloCliente;

public class Main {

	public static void main(String[] args) {
		CuentaBancaria cuenta = new CuentaBancaria();
		ArrayList<HiloCliente> clientes = new ArrayList<>();
		
		for(int i=0;i<500;i++) {
			HiloCliente hc = new HiloCliente(cuenta);
			
			clientes.add(hc);
			hc.start();
		}
		
		try {
			
			for(int i=0;i<25;i++) {
				
				clientes.get(i).join();
			}
			
		}catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
		
		System.out.println(cuenta.getSaldo());
		System.out.println(cuenta.getRegistro());
		System.out.println(cuenta.getNumIngresos());
	}

}
