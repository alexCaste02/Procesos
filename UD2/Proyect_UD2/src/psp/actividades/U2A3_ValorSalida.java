package psp.actividades;

import java.io.IOException;

public class U2A3_ValorSalida {

    /*
    Prepara un programa que ejecute varios comandos (notepad, calc, comandos shell) uno detrás de otro,
    de forma secuencial y haz que tu programa obtenga el código de finalización de cada uno de ellos.
    Para cada programa imprime el nombre y su código de finalización.

    Prueba a poner aplicaciones que no existan o comandos con parámetros incorrectos.
    ¿Qué hace el entorno de programación si pones System.exit(10) para acabar tu programa?.
    Fíjate en la consola. ¿Qué hace el entorno de programación si pones System.exit(0) para
    acabar tu programa.? ¿Cuál es entonces el valor por defecto?
     */

    public static void main(String[] args) {
        try {
            // Ejecutar el comando "notepad"
            ProcessBuilder notepadBuilder = new ProcessBuilder("notepad");
            Process notepadProcess = notepadBuilder.start();
            int notepadExitCode = notepadProcess.waitFor();
            System.out.println("notepad - Código de finalización: " + notepadExitCode);

            // Ejecutar el comando "calc"
            ProcessBuilder calcBuilder = new ProcessBuilder("calc");
            Process calcProcess = calcBuilder.start();
            int calcExitCode = calcProcess.waitFor();
            System.out.println("calc - Código de finalización: " + calcExitCode);

            // Ejecutar un comando inexistente
            ProcessBuilder invalidCommandBuilder = new ProcessBuilder("comando_inexistente");
            Process invalidCommandProcess = invalidCommandBuilder.start();
            int invalidCommandExitCode = invalidCommandProcess.waitFor();
            System.out.println("comando_inexistente - Código de finalización: " + invalidCommandExitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Salir del programa con System.exit(10)
        System.exit(10);
    }
}
