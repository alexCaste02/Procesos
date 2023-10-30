package ejsdiapos.taller;

import java.util.concurrent.atomic.AtomicInteger;

public class Alumno implements Runnable {

    private AtomicInteger idCounter = new AtomicInteger(0);
    private final int id;
    private final String nombre;

    public Alumno() {
        this.id = idCounter.incrementAndGet();
        this.nombre = "Alumno "+id;
    }

    @Override
    public void run() {

    }



}
