package pspT2.ejemplos._5_elPuente;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que respresenta las personas que cruzan el puente
 * 
 * @author jmartinezs
 *
 */
public class Persona implements Runnable{

	private final String idPersona;
	private final int peso;
	private final int tMinPaso,tMaxPaso;
	private final Puente puente;
	
	Persona(Puente puente,int peso,int tMinPaso,int tMaxPaso,String idP){
		this.peso=peso;
		this.tMinPaso=tMinPaso;
		this.tMaxPaso=tMaxPaso;
		this.idPersona=idP;
		this.puente=puente;
	}
	
	public int getPeso() {
		return this.peso;
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.print("-- "+idPersona+" de "+peso+" kg quiere cruzar.");
		System.out.println("En puente hay un peso de "+puente.getPeso()+" y "+puente.getNumPersonas()+" persona"+((puente.getNumPersonas()==1)?"s":""));
		
		//Espera autorización para pasar
		boolean autorizado=false;
		while (!autorizado) {
			synchronized (this.puente) {
				autorizado=this.puente.autorizacionPaso(this);
				if (!autorizado) {					
					try {
						System.out.println("~ "+idPersona+" tiene que esperar");
						this.puente.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("Interrupción mientras espera "+idPersona);
					}
				}				
			}
		}
		
		// Autorizado
		System.out.print("> "+idPersona+" con peso "+peso+" puede cruzar.");
		System.out.println("En puente hay un peso de "+puente.getPeso()+" y "+puente.getNumPersonas()+" persona"+((puente.getNumPersonas()==1)?"s":""));
		
		int tiempoPaso=ThreadLocalRandom.current().nextInt(tMinPaso, tMaxPaso);
		try {
			System.out.println(idPersona+" tardará "+tiempoPaso+" en cruzar");
			Thread.sleep(1000*tiempoPaso);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("Interrupción mientras pasa "+idPersona);
		}
		
		// Sale del puente
		synchronized (this.puente) {
			this.puente.terminaPaso(this);
			System.out.print("< "+idPersona+" con peso "+peso+" sale del puente.");
			System.out.println("En puente hay un peso de "+puente.getPeso()+" y "+puente.getNumPersonas()+" persona"+((puente.getNumPersonas()==1)?"s":""));
			puente.notifyAll();
		}
	}

}
