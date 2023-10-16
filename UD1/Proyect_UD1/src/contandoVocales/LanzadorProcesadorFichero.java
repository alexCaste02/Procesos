package contandoVocales;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LanzadorProcesadorFichero {

    public static void main(String[] args) throws IOException, InterruptedException {


        String ficheroEntrada = args[0];
        String[] vocales = {"a", "e", "i", "o", "u"};

        List<Process> processList = new ArrayList<>();

        for (String vocal : vocales) {
            processList.add(startProcess(ficheroEntrada, vocal));
        }

        for (Process process : processList) {
            process.waitFor();
        }

        int sum = 0;
        for (String vocal : vocales) {
            sum += readResultFile("out/production/Procesos/contandoVocales/resultados/" + vocal);
        }

        System.out.println(sum);
    }

    private static Process startProcess(String ficheroEntrada, String vocal) {
        try {
            File ficheroSalida = new File("out/production/Procesos/contandoVocales/resultados");
            ficheroSalida.mkdirs();

            ProcessBuilder pb = new ProcessBuilder(
                    "java",
                    "contandoVocales.Ej8_ProcesadorFichero",
                    ficheroEntrada,
                    vocal,
                    "contandoVocales/resultados/" + vocal
            );

            pb.directory(new File(System.getProperty("user.dir") + "/out/production/Procesos/"));
            System.out.println(pb.directory());

            return pb.start();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int readResultFile(String path) {
        try (BufferedReader br = Ej7_UtilidadesFicheros.getBufferedReader(path)) {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
