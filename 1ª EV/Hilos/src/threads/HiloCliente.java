package threads;

public class HiloCliente extends Thread{
	private CuentaBancaria cuenta;

	public HiloCliente(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}
	
	public void run() {
		cuenta.ingresar(100);
	}
	
}
