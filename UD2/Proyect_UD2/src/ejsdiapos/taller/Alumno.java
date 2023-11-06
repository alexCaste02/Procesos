package ejsdiapos.taller;

import java.util.Arrays;
import java.util.SimpleTimeZone;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Alumno implements Runnable {


    private static AtomicInteger idCounter = new AtomicInteger(0);
    private final int id;
    private final String nombre;
    private final Herramienta[] toolbox;

    private String status;
    private Herramienta[] usedTools;

    public Alumno(Herramienta[] toolbox) {
        this.id = idCounter.incrementAndGet();
        this.nombre = "Alumno " + id;
        this.toolbox = toolbox;
        this.usedTools = new Herramienta[2];
        status = "Stopped";
    }

    @Override
    public void run() {

        for (int i = 0; i < Integer.MAX_VALUE; i++) {

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
                status = String.format(
                        "Ready   (Tools: %d - %d)",
                        syncMax.getId(), syncMin.getId()
                );

                synchronized (syncMax) {
                    synchronized (syncMin) {

                        status = String.format(
                                "Working (Tools: %d - %d)",
                                syncMax.getId(), syncMin.getId()
                        );

                        Thread.sleep(useTime);

                        status = "Resting";
                    }
                }

                Thread.sleep(pauseTime);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public String toString() {
        return String.format("[%-8s] Status: %s", nombre, status);
    }
}
