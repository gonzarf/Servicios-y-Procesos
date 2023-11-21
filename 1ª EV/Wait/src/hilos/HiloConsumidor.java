package hilos;

import shared.ListaCompartida;

public class HiloConsumidor extends Thread{
	
	private ListaCompartida listaCompartida;
	
	public HiloConsumidor(ListaCompartida listaCompartida) {
		this.listaCompartida = listaCompartida;
	}




	@Override
	public void run() {
		
		for(int i = 0; i< 10;i++) {
			System.out.println(listaCompartida.extraer());
		}
		
	}
}
