package threads;

public class HiloCalculador extends Thread{
	private int min;
	private int max;
	private long[] resultados;
	private int pos;

	
	public HiloCalculador(int min, int max, long[] resultados, int pos) {
		this.min = min;
		this.max = max;
		this.resultados = resultados;
		this.pos = pos;
	}



	public void run() {
		
		long suma = 0;
		
		while (min <= max) {
			suma += min++;
		}
		
		resultados[pos] = suma;
	}
}
