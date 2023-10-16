package psp.sumador;

import java.io.File;

public class U2EG6_SumadorLanzador {
    public static void main(String[] args) {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        U2EG6_SumadorLanzador ls = new U2EG6_SumadorLanzador();
        ls.lanzarSumador(1.0, 500000D);
        System.out.println("Ok");
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
    }
    public void lanzarSumador(Double n1, Double n2) {
        String clase = "psp.sumador.U2EG5_Sumador";
        ProcessBuilder pb;
        System.out.println("THIS:"+System.getProperty("user.dir"));
        try {
            pb = new ProcessBuilder("java", clase, n1.toString(), n2.toString());

            pb.directory(new File(System.getProperty("user.dir")+"\\out\\production\\Procesos"));
            System.out.println("THIS 2:"+System.getProperty("user.dir"));
            pb.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
