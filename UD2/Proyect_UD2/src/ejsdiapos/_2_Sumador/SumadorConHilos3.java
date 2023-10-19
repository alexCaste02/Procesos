package ejsdiapos._2_Sumador;

import java.util.ArrayList;
import java.util.List;

class Acumulador {
    long acumulador = 0;

    synchronized void acumular(long l) {
        acumulador += l;
    }

    public long getAcumulador() {
        return acumulador;
    }
}

class HiloSumador3 implements Runnable {

    int n1, n2;
    Acumulador acu;

    public HiloSumador3(int n1, int n2, Acumulador a) {
        this.n1 = n1;
        this.n2 = n2;
        this.acu = a;
    }

    @Override
    public void run() {
        for (int i = n1; i <= n2; i++) {
            acu.acumular(i);
        }
    }
}

public class SumadorConHilos3 {

    static Acumulador suma;

    public static void main(String[] args) {
        suma = new Acumulador();
        int nInicial = 1;
        int nFinal = 100000;
        int step = (nFinal - nInicial + 1) / 10;

        int fragStart;
        int fragEnd;

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fragStart = nInicial + (step * i);
            fragEnd = fragStart + (step - 1);
            threadList.add(new Thread(new HiloSumador3(fragStart, fragEnd, suma)));
        }
        try {
            for (Thread t : threadList) {
                t.start();
                t.join();
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Suma:" + suma.getAcumulador());
    }
}
