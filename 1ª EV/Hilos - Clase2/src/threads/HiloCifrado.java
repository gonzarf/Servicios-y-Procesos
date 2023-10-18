package threads;

public class HiloCifrado extends Thread{
	
	private String password;
	private char[] newPassword;
	private int pos;
	private int codigo;

	public HiloCifrado(String password, char[] newPassword, int pos, int codigo) {
		this.password = password;
		this.newPassword = newPassword;
		this.pos = pos;
		this.codigo = codigo;
	}



	public void run() {
		
		newPassword[pos] = (password.toCharArray()[pos] += codigo);
	}
}
