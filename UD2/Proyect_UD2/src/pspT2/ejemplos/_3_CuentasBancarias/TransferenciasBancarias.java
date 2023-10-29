package pspT2.ejemplos._3_CuentasBancarias;

public class TransferenciasBancarias {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuenta c1=new Cuenta("ES12321235234623462123",11000);
		Cuenta c2=new Cuenta("ES11201243999100012301",9500);
		
		System.out.printf("Saldo inicial de %s:%d\n",c1.getNumCuenta(),c1.getSaldo());
		System.out.printf("Saldo inicial de %s:%d\n\n",c2.getNumCuenta(),c2.getSaldo());
			
		Thread h1=new Thread(new Hilo(c1,c2,"Hilo1"));
		Thread h2=new Thread(new Hilo(c2,c1,"Hilo2"));
		
		h1.start();
		h2.start();
		
		try {
			h1.join();
			h2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.printf("Saldo final de %s:%d\n",c1.getNumCuenta(),c1.getSaldo());
		System.out.printf("Saldo final de %s:%d\n",c2.getNumCuenta(),c2.getSaldo());
		
	}

}
