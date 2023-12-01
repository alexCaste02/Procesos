//package oscar.servicio_ordenacion;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class ServidorOrdenacion {
//        public void escuchar() throws IOException {
//                ServerSocket socket;
//                try{
//                        socket=new ServerSocket(9876);
//                }
//                catch(Exception e){
//                        System.out.println("No se pudo arrancar");
//                        return ;
//                }
//                while (true){
//                        System.out.println("Servidor esperando");
//                        Socket conexionCliente=
//                                        socket.accept();
//                        System.out.println("Alguien conectó");
//                        Peticion p=
//                                        new Peticion(conexionCliente);
//                        Thread hiloAsociado=
//                                        new Thread(p);
//                        hiloAsociado.start();
//                }
//        } // Fin del método escuchar
//        public static void  main(String[] argumentos){
//                ServidorOrdenacion s=
//                                new ServidorOrdenacion();
//                try {
//                        s.escuchar();
//                } catch (Exception e){
//                        System.out.println("No se pudo arrancar");
//                        System.out.println(" el cliente o el serv");
//                }
//        }
//}