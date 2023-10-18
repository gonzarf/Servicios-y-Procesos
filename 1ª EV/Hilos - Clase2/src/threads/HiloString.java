package threads;

public class HiloString extends Thread {

	int min;
	int max;
	private String cadena;
	private char[] vocales = { 'A', 'E', 'I', 'O', 'U' };
	private int sum;

	public HiloString(String cadena, int sum, int min, int max) {

		this.cadena = cadena;
		this.sum = sum;
		this.min = min;
		this.max = max;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public void run() {

		cadena = cadena.toUpperCase();

		for (int i = min; i < max; i++) {

			for (int x = 0; x < vocales.length; x++) {
				
				if (cadena.charAt(i) == vocales[x]){
					sum++;
				}
			}
		}
	}

}
