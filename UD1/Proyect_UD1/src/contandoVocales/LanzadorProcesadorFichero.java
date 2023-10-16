package contandoVocales;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanzadorProcesadorFichero {

    public static void main(String[] args) throws IOException, InterruptedException {

        String ficheroEntrada = args[0];
        String[] vocales = {"a", "e", "i", "o", "u"};

        // Creamos una lista para almacenar los Procesos
        List<Process> processList = new ArrayList<>();


        ProcessBuilder pb;


        for (String vocal : vocales) {

            startProcess(ficheroEntrada, vocal);

        }


    }

    private static void startProcess(String ficheroEntrada, String vocal) {
        ProcessBuilder pb;

        File ficheroSalida = new File("out/production/Procesos/contandoVocales/resultados");
        ficheroSalida.mkdirs();

        pb = new ProcessBuilder("java",
                "contandoVocales.Ej8_ProcesadorFichero",
                ficheroEntrada,
                vocal,
                "contandoVocales/resultados/"+vocal+".txt"
        );

        pb.directory(new File(System.getProperty("user.dir")+"/out/production/Procesos/"));
        System.out.println(pb.directory());
        pb.inheritIO();

        try {
            Process p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}