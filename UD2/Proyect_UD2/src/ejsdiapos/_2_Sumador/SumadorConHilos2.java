package ejsdiapos._2_Sumador;

import java.util.ArrayList;
import java.util.List;

class HiloSumador2 implements Runnable{
	
	int n1,n2;
	
	public HiloSumador2(int n1,int n2) {
		this.n1=n1;
		this.n2=n2;
	}

	@Override
	public void run() {
		long suma=0;
		for (int i=n1;i<=n2;i++) {
			suma+=i;
		}

		System.out.println(n1+" al "+n2+": "+suma);
	}	
}

public class SumadorConHilos2 {

	public static void main(String[] args) {
        int nInicial = 1;
        int nFinal = 100000;
        int step = (nFinal-nInicial+1)/10;

        int fragStart;
        int fragEnd;

        List<Thread> threadList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            fragStart = nInicial + (step*i);
            fragEnd = fragStart + (step-1);
            threadList.add(new Thread(new HiloSumador2(fragStart,fragEnd)));
        }
        try {
            for (Thread t : threadList) {
                t.start();
                t.join();

            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

	}
}
