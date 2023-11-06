package pspT2.ejemplos._5_elPuente;

/**
 * Clase para el control de los requisitos
 *
 * @author jmartinezs
 */
public class Puente {

    private static final int PESO_MAXIMO = 200;
    private static final int MAX_PERSONAS_NORTE = 3;
    private static final int MAX_PERSONAS_SUR = 3;
    private int peso = 0;
    private int numPersonasNorte = 0;
    private int numPersonasSur = 0;

    public synchronized int getPeso() {
        return peso;
    }

    public synchronized int getNumPersonas(Heading rumbo) {
        if(rumbo==Heading.NORTE){
            return numPersonasNorte;
        } else {
            return numPersonasSur;
        }
    }

    public synchronized boolean autorizacionPaso(Persona persona) {
        boolean resultado;

        if (persona.getRumbo() == Heading.NORTE) {

            if (this.peso + persona.getPeso() <= Puente.PESO_MAXIMO && this.numPersonasNorte < Puente.MAX_PERSONAS_NORTE) {
                this.numPersonasNorte++;
                this.peso += persona.getPeso();
                resultado = true;
            } else
                resultado = false;

        } else {

            if (this.peso + persona.getPeso() <= Puente.PESO_MAXIMO && this.numPersonasSur < Puente.MAX_PERSONAS_SUR) {
                this.numPersonasSur++;
                this.peso += persona.getPeso();
                resultado = true;
            } else
                resultado = false;

        }

        return resultado;
    }

    public synchronized void terminaPaso(Persona persona) {
        this.peso -= persona.getPeso();

        if(persona.getRumbo()==Heading.NORTE){
            this.numPersonasNorte--;
        } else {
            this.numPersonasSur--;
        }
    }
}
