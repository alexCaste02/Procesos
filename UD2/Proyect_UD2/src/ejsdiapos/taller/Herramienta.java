package ejsdiapos.taller;

import java.util.concurrent.atomic.AtomicInteger;

public class Herramienta {

    private static AtomicInteger idCounter = new AtomicInteger(0);
    private final int id;
    private final String nombre;

    public Herramienta() {
        this.id = idCounter.incrementAndGet();
        this.nombre = "Herramienta "+id;
    }

    public int getId() {
        return id;
    }
}
