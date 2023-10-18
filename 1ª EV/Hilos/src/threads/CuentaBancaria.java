package threads;

public class CuentaBancaria{
	private double saldo;
	private int numIngresos;
	private String registro ="";

	public CuentaBancaria() {

	}
	
	public synchronized void ingresar(double cantidad) {
		saldo+= cantidad;
		registro+= "sado: " + saldo + "\n";
		numIngresos++;
	}
	
	
	public int getNumIngresos() {
		return numIngresos;
	}

	public void setNumIngresos(int numIngresos) {
		this.numIngresos = numIngresos;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
