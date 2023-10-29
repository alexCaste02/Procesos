package pspT2.ejemplos._4_IncrementaDecrementa;

public class IncrementaDecrementa {

	private static final int NUM_HILOS_INC=10;
	private static final int NUM_HILOS_DEC=10;

	public static void main(String[] args) {
		Contador c=new Contador(0);
		Thread[] hilosInc=new Thread[NUM_HILOS_INC];
		for (int i=0;i<NUM_HILOS_INC;i++) {
			Thread h=new Thread(new HiloInc("INC"+i,c));
			hilosInc[i]=h;
		}
		Thread[] hilosDec=new Thread[NUM_HILOS_DEC];
		for (int i=0;i<NUM_HILOS_DEC;i++) {
			Thread h=new Thread(new HiloDec("DEC"+i,c));
			hilosDec[i]=h;
		}
		
		for (int i=0;i<NUM_HILOS_INC;i++) {
			hilosInc[i].start();
		}
		for (int i=0;i<NUM_HILOS_DEC;i++) {
			hilosDec[i].start();
		}
	}
}

class Contador{
	private int cuenta;
	
	Contador(int valorInicial){
		cuenta=valorInicial;
	}
	
	synchronized public int getCuenta() {
		return cuenta;
	}
	
	synchronized int incrementa() {
		cuenta++;
		return cuenta;
	}
	
	synchronized int decrementa() {
		cuenta--;
		return cuenta;
	}	
}

class HiloInc implements Runnable{
	
	private final String id;
	private final Contador cont;
	
	HiloInc(String id,Contador c){
		this.id=id;
		cont=c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			// Hace falta el bloque, porque son dos operaciones, incrementar y mostrar la cuenta
			// Podría ser que se incremente, pero el valor no sea correcto.
			synchronized (this.cont) {
				this.cont.incrementa();
				System.out.println("Hilo "+id+" se incrementa, valor contador:"+cont.getCuenta());
			}
		}
	}	
}

class HiloDec implements Runnable{
	
	private final String id;
	private final Contador cont;
	
	HiloDec(String id,Contador c){
		this.id=id;
		cont=c;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			synchronized (this.cont) {
				this.cont.decrementa();
				System.out.println("Hilo "+id+" se decrementa, valor contador:"+cont.getCuenta());
			}
		}
	}	
}
