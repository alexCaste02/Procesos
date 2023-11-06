package ejsdiapos.taller;

import java.util.ArrayList;

public class Taller {
    /*
     * Estamos  en  un  taller  de  pŕacticas,  donde  están  trabajando  5 alumnos  y en  el  que  tenemos
     *  un  banco  de  10 herramientas  para compartir entre los 5 alumnos.
     *
     * Herramienta bancoHerramientas=new Herramienta[10];
     *
     * Los  alumnos  están  continuamente  haciendo  prácticas,  para  las cuales   eligen   dos   herramientas
     * al   azar   y   cuando   las   tienen trabajan  un  tiempo  aleatorio,  entre  2  y  3  segundos,  y
     * después descansan un tiempo aleatorio, entre 1 y 2 segundos después de devolver las herramientas.
     * Para Herramienta únicamente necesitamos un identificador   para los mensajes.Muestra  la  evolución
     * de  la  simulación,  de  que  alumnos están trabajando con que herramienta y cudno están descansando.
     * */
    public static void main(String[] args) throws InterruptedException {


        Herramienta[] bancoHerramientas = new Herramienta[10];
        for (int i = 0; i < 10; i++) {
            bancoHerramientas[i] = new Herramienta();
        }


        // SOBRA BASTISIMO
        Thread[] threads = new Thread[5];
        ArrayList<Alumno> alumnoList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Alumno a = new Alumno(bancoHerramientas);
            alumnoList.add(a);
            threads[i] = new Thread(a);
        }

        for (Thread hiloAlum : threads) {
            hiloAlum.start();
        }

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println("========================");
            for (Alumno alumno : alumnoList) {
                System.out.println(alumno);
            }

            System.out.println("========================");
            Thread.sleep(1000L);
        }




    }



}
