//package oscar.servicio_ordenacion;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//public class Peticion implements Runnable {
//        Socket conexionParaAtender;
//
//        public Peticion ( Socket s ){
//                this.conexionParaAtender=s;
//        }
//        @Override
//        public void run() {
//                try{
//                        PrintWriter flujoEscritura=
//                                Utilidades.getFlujoEscritura(
//                                                this.conexionParaAtender
//                                                );
//                        BufferedReader flujoLectura=
//                                Utilidades.getFlujoLectura(
//                                                conexionParaAtender);
//                        String protocolo=
//                                        flujoLectura.readLine();
//                        int numVersion=
//                                        Protocolo.getNumVersion(protocolo);
//                        if (numVersion==1){
//                                String linea1=
//                                                flujoLectura.readLine();
//                                String linea2=
//                                                flujoLectura.readLine();
//                                //Linea 1 va despues en el
//                                if (linea1.compareTo(linea2)>0){
//                                         dicc
//                                        flujoEscritura.println(linea2);
//                                        flujoEscritura.println(linea1);
//                                        flujoEscritura.flush();
//                                } else {
//                                        flujoEscritura.println(linea1);
//                                        flujoEscritura.println(linea2);
//                                        flujoEscritura.flush();
//                                }
//                        }
//                }
//                catch (IOException e){
//                        System.out.println(
//                                        "No se pudo crear algún flujo");
//                        return ;
//                }
//        }
//}