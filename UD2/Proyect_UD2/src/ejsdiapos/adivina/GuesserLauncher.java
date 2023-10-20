package ejsdiapos.adivina;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GuesserLauncher {

    static GuessManager gm;

    public static void main(String[] args) {
        
        double generatedNumber = ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE);
        gm = new GuessManager(generatedNumber);
        System.out.println("Numero generado: "+generatedNumber);

        final int ThreadAmount = 10;

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < ThreadAmount; i++) {
            Thread newThread =new Thread(new GuesserThread(gm));
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
    String name;
    GuessManager gm;
    //TODO: contar intentos

    static int threadCounter = 1;

    public GuesserThread(GuessManager gm) {
        this.gm = gm;
        this.name = "[Thread "+(threadCounter++)+"]";
    }

    @Override
    public void run() {
        int result;
        System.out.println(name+": Busqueda iniciada");
        do {
            result = gm.checkGuess(ThreadLocalRandom.current().nextInt(Integer.MAX_VALUE));
        } while (result == 0);

        if(result==1){
            System.out.println(name+": He encontrado el numero");
        } else {
            System.out.println(name+": Numero encontrado por otro hilo");
        }
    }


}

class GuessManager {
    double value;
    boolean found = false;

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


