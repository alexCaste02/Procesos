package pspT2.ejemplos._5_elPuente;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Siulación del paso de personas por un puente. Pero este paso tiene restricciones, no se puede superar un peso máximo
 * no se pueden superar un número máximo de personas simultaneas
 *
 * @author jmartinezs
 */
public class MainPuente {

    public static void main(String[] args) {
        Puente elPuente = new Puente();

        int tMinNuevaPersona = 1;
        int tMaxNuevaPersona = 5;
        int tMinPasoPuente = 5;
        int tMaxPasoPuente = 10;

        int pesoMinpersona = 40;
        int pesoMaxPersona = 120;

        System.out.println("###################### Se abre el puente");
        int idPersona = 1;

        while (!Thread.currentThread().isInterrupted()) {
            int tiempoNuevoPersona = ThreadLocalRandom.current().nextInt(tMinNuevaPersona, tMaxNuevaPersona);
            int pesoNuevaPersona = ThreadLocalRandom.current().nextInt(pesoMinpersona, pesoMaxPersona);
            int nuevaDireccion = ThreadLocalRandom.current().nextInt(0, 2);
            Heading direccion = (nuevaDireccion == 0) ? Heading.NORTE : Heading.SUR;

            System.out.println("Siguiente persona en " + tiempoNuevoPersona + " segundos");
            try {
                Thread.sleep(1000L * tiempoNuevoPersona);
            } catch (InterruptedException e) {
                System.out.println("Interrumpido proceso princial");
            }
            Thread hiloPersona = new Thread(new Persona(elPuente, pesoNuevaPersona, tMinPasoPuente, tMaxPasoPuente, "Person" + idPersona, direccion));
            hiloPersona.start();
            idPersona++;
        }
    }

}
