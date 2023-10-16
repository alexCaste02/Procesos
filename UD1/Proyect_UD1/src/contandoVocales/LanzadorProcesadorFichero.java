package contandoVocales;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LanzadorProcesadorFichero {

    public static void main(String[] args) throws IOException, InterruptedException {

        String ficheroEntrada = args[0];
        String[] vocales = {"a", "e", "i", "o", "u"};

        // Creamos una lista para almacenar los Procesos
        List<Process> processList = new ArrayList<>();

        Arrays.stream(vocales).forEach(v -> processList.add(startProcess(ficheroEntrada, v)));

        for (Process process : processList) {
            process.waitFor();
        }

        int sum=0;
        for (String vocal : vocales) {
            BufferedReader br = Ej7_UtilidadesFicheros.getBufferedReader("out/production/Procesos/contandoVocales/resultados/" + vocal);
            sum += Integer.parseInt(br.readLine());
        }

        System.out.println(sum);


    }

    private static Process startProcess(String ficheroEntrada, String vocal) {
        ProcessBuilder pb;

        try {
            File ficheroSalida = new File("out/production/Procesos/contandoVocales/resultados");
            ficheroSalida.mkdirs();

            pb = new ProcessBuilder("java"
                    , "contandoVocales.Ej8_ProcesadorFichero"
                    , ficheroEntrada
                    , vocal
                    , "contandoVocales/resultados/" + vocal);

            pb.directory(new File(System.getProperty("user.dir") + "/out/production/Procesos/"));
            System.out.println(pb.directory());


            return pb.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}