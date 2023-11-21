package hilos;

import shared.ListaCompartida;

public class HiloProductor extends Thread{
	
	private ListaCompartida listaCompartida;
	
	
	public HiloProductor(ListaCompartida listaCompartida) {
		this.listaCompartida = listaCompartida;
	}



	@Override
	public void run() {
		
		for(int i = 0; i< 10;i++) {
			listaCompartida.agregar("Vuelta " + i);
		}
	}
}
