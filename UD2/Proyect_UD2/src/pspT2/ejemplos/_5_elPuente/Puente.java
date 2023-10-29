package pspT2.ejemplos._5_elPuente;

/**
 * Clase para el control de los requisitos
 * 
 * @author jmartinezs
 *
 */
public class Puente {

	private static final int PESO_MAXIMO=200;
	private static final int MAX_PERSONAS=3;
	
	private int peso=0;
	private int numPersonas=0;
	
	synchronized public int getPeso() {
		return peso;
	}
	
	synchronized public int getNumPersonas() {
		return numPersonas;
	}
	
	synchronized public boolean autorizacionPaso(Persona persona) {
		boolean resultado;
		if (this.peso+persona.getPeso()<=Puente.PESO_MAXIMO && this.numPersonas<Puente.MAX_PERSONAS) {
			this.numPersonas++;
			this.peso+=persona.getPeso();
			resultado=true;
		}
		else
			resultado=false;
		return resultado;
	}
	
	synchronized public void terminaPaso(Persona persona) {
		this.peso-=persona.getPeso();
		this.numPersonas--;
	}
}
