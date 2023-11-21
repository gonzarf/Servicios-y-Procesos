package shared;

import java.util.ArrayList;

public class ListaCompartida {
	
	private ArrayList<String> lista;
	public static final int CAPACIDAD = 10;

	public ListaCompartida(ArrayList<String> lista) {
		this.lista = lista;
	}
	
	public ListaCompartida() {
		lista = new ArrayList<String>();
	}



	public synchronized void agregar(String s) {
		
		while(lista.size() == CAPACIDAD) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(lista);
		lista.add(s);
		notifyAll();
	}

	
	public synchronized String extraer() {
		
		while(lista.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(lista);
		notifyAll();
		return lista.remove(0);
	}
	
	
	

}

