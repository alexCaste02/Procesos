package oscar.servicio_ordenacion;

import java.io.*;
import java.net.Socket;

public class Utilidades {
    /* Obtiene un flujo de escritura
    a partir de un socket*/
    public PrintWriter getFlujoEscritura
    (Socket s) throws IOException {
        OutputStream os=s.getOutputStream();
        PrintWriter pw=new PrintWriter(os);
        return pw;
    }
    /* Obtiene un flujo de lectura
    a partir de un socket*/
    public BufferedReader
    getFlujoLectura(Socket s)
            throws IOException{
        InputStream is=s.getInputStream();
        InputStreamReader isr=
                new InputStreamReader(is);
        BufferedReader bfr=new BufferedReader(isr);
        return bfr;
    }
}
