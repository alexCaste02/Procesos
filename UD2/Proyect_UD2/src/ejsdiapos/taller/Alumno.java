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
        while (true) {
            int useTime = ThreadLocalRandom.current().nextInt(2000, 3001);
            int pauseTime = ThreadLocalRandom.current().nextInt(1000, 2001);

            StringBuilder tools = new StringBuilder("0123456789");
            int toolPos1 = Character.getNumericValue(tools.charAt(ThreadLocalRandom.current().nextInt(0, tools.length())));
            tools.deleteCharAt(toolPos1);
            int toolPos2 = Character.getNumericValue(tools.charAt(ThreadLocalRandom.current().nextInt(0, tools.length())));

            Herramienta h1 = toolbox[toolPos1];
            Herramienta h2 = toolbox[toolPos2];

            Herramienta syncH1;
            Herramienta syncH2;

            if (h1.getId() > h2.getId()) {
                syncH1 = h1;
                syncH2 = h2;
            } else {
                syncH1 = h2;
                syncH2 = h1;
            }

            try {


                synchronized (syncH1) {
                    synchronized (syncH2) {
                        System.out.println(nombre + " ha cogido las herramientas " + syncH1.getId() + " y " + syncH2.getId());
                        Thread.sleep(useTime);
                    }
                }

                System.out.println(nombre + " ha soltado las herramientas, y ha empezado a descansar");
                Thread.sleep(pauseTime);
                System.out.println(nombre + " ha terminado de descansar");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }


}
