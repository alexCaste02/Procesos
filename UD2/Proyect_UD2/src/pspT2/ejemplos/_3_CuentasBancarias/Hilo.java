package pspT2.ejemplos._3_CuentasBancarias;

public class Hilo implements Runnable{

	Cuenta c1,c2;
	String nombreHilo;
	
	Hilo(Cuenta c1,Cuenta c2,String nombre){
		this.c1=c1;
		this.c2=c2;
		this.nombreHilo=nombre;
	}

	@Override
	public void run() {
		int dinero=10;
		int numeroTransferencias=0;
		for (int i=0;i<10000;i++) {
			if (GestorCuentas.transferencia(c1, c2, dinero)) {
				numeroTransferencias++;
			}
		}
		System.out.printf("Fin de %s, %d transferencias realizadas de %s a %s.\n",
				this.getNombreHilo(),numeroTransferencias,c1.getNumCuenta(),c2.getNumCuenta());		
	}
	
	public String getNombreHilo() {
		return nombreHilo;
	}

}
