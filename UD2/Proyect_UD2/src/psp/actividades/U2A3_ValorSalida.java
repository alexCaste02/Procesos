package psp.actividades;

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

    public static void main(String[] args) throws Exception {
        String test = "cmd /c dir";
        ProcessBuilder pb = new ProcessBuilder(test.split(" "));

        Process p = pb.start();

//        p.waitFor();
//
//        p.exitValue();
//        pb.command().add(0,"notepad.exe");
//
//        pb.start();



    }
}
