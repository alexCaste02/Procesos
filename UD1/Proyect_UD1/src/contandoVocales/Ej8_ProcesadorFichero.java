package contandoVocales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;


public class Ej8_ProcesadorFichero {
    // Dado un fichero de entrada y una letra
    // contamos cuantas veces aparece dicha letra
    // y dejamos el recuento en un fichero de salida

    public static void hacerRecuento(String fichEntrada, String letra, String fichSalida) throws FileNotFoundException, IOException {

        BufferedReader br;
        br = Ej7_UtilidadesFicheros.getBufferedReader(fichEntrada);
        PrintWriter pw;
        pw = Ej7_UtilidadesFicheros.getPrintWriter(fichSalida);
        String lineaLeida;
        lineaLeida = br.readLine();
        int totalVocales = 0;
        //Mientras no queden líneas....
        while (lineaLeida != null) {
            //...recorremos la linea...
            for (int i = 0; i < lineaLeida.length(); i++) {
                char letraLeida = Character.toLowerCase(lineaLeida.charAt(i));
                char letraPasada = Character.toLowerCase(letra.charAt(0));
                // incrementamos el contador
                if (isSearchedCharacter(letraLeida,letraPasada)) {
                    totalVocales++;
                }
            }
            // Pasamos a la siguiente linea
            lineaLeida = br.readLine();
        }
        //Escribimos el total de vocales
        //en el fichero de salida
        pw.println(totalVocales);
        pw.flush();
        //Y cerramos los ficheros
        pw.close();
        br.close();
    }

    private static boolean isSearchedCharacter(char letraLeida, char letraBuscada) {
        char letraSinAcento;

        switch (letraLeida){
            case 'á' -> letraSinAcento = 'a';
            case 'é' -> letraSinAcento = 'e';
            case 'í' -> letraSinAcento = 'i';
            case 'ó' -> letraSinAcento = 'o';
            case 'ú' -> letraSinAcento = 'u';
            default -> letraSinAcento = letraLeida;
        }

        return letraBuscada == letraSinAcento;
    }


    /**
     * Dado un fichero pasado como argumento, contará cuantas
     * apariciones hay de una cierta vocal (pasada como argumento)
     * y dejará la cantidad en otro fichero (también pasado como
     * argumento)
     *
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("Test");

        String nombreFicheroEntrada = args[0];
        String letra = args[1];

        String nombreFicheroResultado = args[2];
        hacerRecuento(nombreFicheroEntrada, letra, nombreFicheroResultado);

    }
}
