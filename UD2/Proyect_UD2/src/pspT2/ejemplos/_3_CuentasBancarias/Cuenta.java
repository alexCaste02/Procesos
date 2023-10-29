package pspT2.ejemplos._3_CuentasBancarias;

public class Cuenta {

	int saldo;
	final String numCuenta;
	
	public Cuenta(String numCuenta, int saldoInicial) {
		this.numCuenta=numCuenta;
		this.saldo=saldoInicial;
	}
	
	public synchronized int getSaldo() {
		return saldo;		
	}
	
	public synchronized void ingresar(int cantidad) {
		saldo+=cantidad;
	}
	
	public synchronized void sacar(int cantidad) {
		saldo-=cantidad;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
}
