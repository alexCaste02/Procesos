package ejsdiapos.adivina;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GuesserLauncher {

    static GuessManager gm;

    public static void main(String[] args) {
<<<<<<< Updated upstream
        
        double generatedNumber = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
=======
        double topValue = Integer.MAX_VALUE;
        double generatedNumber = ThreadLocalRandom.current().nextInt((int) topValue);
>>>>>>> Stashed changes
        gm = new GuessManager(generatedNumber);
        System.out.println("Numero generado: "+generatedNumber);

        final int ThreadAmount = 10;

        List<Thread> threadList = new ArrayList<>();
<<<<<<< Updated upstream
        for (int i = 0; i < ThreadAmount; i++) {
            Thread newThread =new Thread(new GuesserThread(gm));
=======

        for (int i = 0; i < threadAmount; i++) {
            Thread newThread = new Thread(new GuesserThread(gm,topValue));
            newThread.setDaemon(true);
            System.out.println(newThread.hashCode());
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
    String name;
    GuessManager gm;
    //TODO: contar intentos

    static int threadCounter = 1;
=======
    private final GuessManager gm;
    private final String name;
    private static int threadCounter = 1;
    private final double maxNumber;

    private final long startTime = System.currentTimeMillis();

    private long tries;
>>>>>>> Stashed changes

    public GuesserThread(GuessManager gm) {
        this.gm = gm;
<<<<<<< Updated upstream
        this.name = "[Thread "+(threadCounter++)+"]";
=======
        this.maxNumber = maxNumber;
        this.name = "[Thread " + (threadCounter++) + "]";
    }

    private double currentRuntime (){
        return (System.currentTimeMillis()-startTime);
>>>>>>> Stashed changes
    }

    @Override
    public void run() {
<<<<<<< Updated upstream
=======
        System.out.println(name + ": Busqueda iniciada");


>>>>>>> Stashed changes
        int result;
        System.out.println(name+": Busqueda iniciada");
        do {
            result = gm.checkGuess(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
        } while (result == 0);

<<<<<<< Updated upstream
        if(result==1){
            System.out.println(name+": He encontrado el numero");
=======
        if (result == 1) {
            System.out.printf("%s: He encontrado el numero (%d intentos) (%.2f secs)%n", name,tries,currentRuntime()/1000);
>>>>>>> Stashed changes
        } else {
            System.out.println(name+": Numero encontrado por otro hilo");
        }
    }


}

class GuessManager {
<<<<<<< Updated upstream
    double value;
    boolean found = false;
=======
    private final double value;
    private boolean found = false;
//    public int totalTries;
>>>>>>> Stashed changes

    //TODO: poner limite inferior
    public GuessManager(double maxValue) {
        this.value = maxValue;
    }


    /**
     *
     * @param n Numero que se quiere comprobar
     * @return -1: Encontrado por otro
     *          0: No acertado
     *          1: Acertado
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


