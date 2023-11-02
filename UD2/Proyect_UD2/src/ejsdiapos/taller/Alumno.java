package ejsdiapos.taller;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Alumno implements Runnable {


    private static AtomicInteger idCounter = new AtomicInteger(0);
    private final int id;
    private final String nombre;
    private final Herramienta[] toolbox;

    public Alumno(Herramienta[] toolbox) {
        this.id = idCounter.incrementAndGet();
        this.nombre = "Alumno " + id;
        this.toolbox = toolbox;
    }

    @Override
    public void run() {

        for (int i = 0; i < Integer.MAX_VALUE; i++)  {

            int useTime = ThreadLocalRandom.current().nextInt(2000, 3001);
            int pauseTime = ThreadLocalRandom.current().nextInt(1000, 2001);

            StringBuilder tools = new StringBuilder("0123456789");
            int toolPos1 = Character.getNumericValue(tools.charAt(ThreadLocalRandom.current().nextInt(0, tools.length())));
            tools.deleteCharAt(toolPos1);
            int toolPos2 = Character.getNumericValue(tools.charAt(ThreadLocalRandom.current().nextInt(0, tools.length())));


            Herramienta h1 = toolbox[toolPos1];
            Herramienta h2 = toolbox[toolPos2];

            Herramienta syncMax;
            Herramienta syncMin;

            if (h1.getId() > h2.getId()) {
                syncMax = h1;
                syncMin = h2;
            } else {
                syncMax = h2;
                syncMin = h1;
            }


            try {

                synchronized (syncMax) {
                    synchronized (syncMin) {
                        System.out.println(nombre + " ha cogido las herramientas " + syncMax.getId() + " y " + syncMin.getId());
                        Thread.sleep(useTime);
                        System.out.println(nombre + " ha soltado las herramientas, y ha empezado a descansar");
                    }
                }

                Thread.sleep(pauseTime);
                System.out.println(nombre + " ha terminado de descansar");

            } catch (InterruptedException e) {throw new RuntimeException(e);}

        }
    }


}
