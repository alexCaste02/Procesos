package ejsdiapos.adivina;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GuesserLauncher {

    static GuessManager gm;

    public static void main(String[] args) {
        double topValue = 50;
        double generatedNumber = ThreadLocalRandom.current().nextInt((int) topValue);
        gm = new GuessManager(generatedNumber);
        System.out.println("Numero generado: " + generatedNumber);

        final int threadAmount = 10;
        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < threadAmount; i++) {
            Thread newThread = new Thread(new GuesserThread(gm,topValue));
            threadList.add(newThread);
            newThread.start();
        }

        for (Thread t : threadList) {
            try {
                t.join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

class GuesserThread implements Runnable {
    private final String name;
    private final GuessManager gm;
    private final long startTime = System.currentTimeMillis();
    private static int threadCounter = 1;
    private final double maxNumber;

    private long tries;

    public GuesserThread(GuessManager gm, double maxNumber) {
        this.gm = gm;
        this.maxNumber = maxNumber;
        this.name = "[Thread " + (threadCounter++) + "]";
    }

    private long currentRuntime (){
        return (System.currentTimeMillis()-startTime);
    }

    @Override
    public void run() {
        System.out.println(name + ": Busqueda iniciada");

        int result;
        do {
            result = gm.checkGuess(ThreadLocalRandom.current().nextInt((int) maxNumber));
            tries++;
        } while (result == 0);

        if (result == 1) {
            System.out.printf("%s: He encontrado el numero (%d intentos)%n", name,tries);
        } else {
            System.out.printf("%s: Numero encontrado por otro hilo (%d intentos)%n", name,tries);
        }

    }
}

class GuessManager {
    private final double value;
    private boolean found = false;

    public GuessManager(double maxValue) {
        this.value = maxValue;
    }

    /**
     * @param n Numero que se quiere comprobar
     * @return -1: Encontrado por otro
     * 0: No acertado
     * 1: Acertado
     */
    synchronized int checkGuess(double n) {
        if (found) {
            return -1;
        } else if (n == value) {
            found = true;
            return 1;
        }
        return 0;
    }
}
