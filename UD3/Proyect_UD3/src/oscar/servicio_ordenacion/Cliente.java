//package oscar.servicio_ordenacion;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.net.InetSocketAddress;
//import java.net.Socket;
//
//public class Cliente {
//        public void ordenar(String s1, String s2) throws IOException {
//                InetSocketAddress direccion=
//                                new InetSocketAddress("10.13.0.20", 9876);
//                Socket conexion=
//                                new Socket();
//                conexion.connect(direccion);
//                System.out.println("Conexion establecida");
//                /* Ahora hay que crear flujos de salida, enviar
//                 * cadenas por allí y esperar los resultados.
//                 */
//                try{
//
//                        BufferedReader flujoLectura=
//                                Utilidades.getFlujoLectura(conexion);
//                        PrintWriter flujoEscritura=
//                                Utilidades.getFlujoEscritura(conexion);
//
//                        flujoEscritura.println("1");
//                        flujoEscritura.println(s1);
//                        flujoEscritura.println(s2);
//                        flujoEscritura.flush();
//                        String linea1=flujoLectura.readLine();
//                        String linea2=flujoLectura.readLine();
//                        System.out.println("El servidor devolvió "+
//                                        linea1 + " y "+linea2);
//                } catch (IOException e){
//
//                }
//        }
//        public static void main(String[] args) {
//                Cliente c=new Cliente();
//                try {
//                        c.ordenar("aaa", "bbb");
//                } catch (IOException e) {
//                        System.out.println("Fallo la conexion o ");
//                        System.out.println("los flujos");
//                } //Fin del catch
//        } //Fin del main
//} //Fin de la clase