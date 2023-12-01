package oscar.pruebas;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Conector {
    public static void main(String[] args) {
        System.out.println("Iniciando...");

        String destino = "172.18.185.243";
        int puertoDestino = 80;
        InetSocketAddress direccion = new InetSocketAddress(destino, puertoDestino);

        try (Socket socket = new Socket()) {
            socket.connect(direccion);
            //Si llegamos aquí es que la conexión sí se hizo.

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            //Flujos que manejan caracteres
            InputStreamReader isr =
                    new InputStreamReader(is);
            OutputStreamWriter osw =
                    new OutputStreamWriter(os);

            //Flujos de líneas
            BufferedReader bReader =
                    new BufferedReader(isr);
            PrintWriter pWriter =
                    new PrintWriter(osw);


            pWriter.println("GET /psp.html");
            pWriter.flush();
            String linea;
            FileWriter escritorArchivo = new FileWriter("resultado.html");
            while ((linea = bReader.readLine()) != null) {
                escritorArchivo.write(linea);
            }
            escritorArchivo.close();
            pWriter.close();
            bReader.close();
            isr.close();
            osw.close();
            is.close();
            os.close();
        } catch (IOException e) {
            System.out.println(
                    "No se pudo establecer la conexion " + " o hubo un fallo al leer datos."
            );
        } //Fin del catch
    } //Fin del main
} //Fin de la clase Conector