package ejsdiapos.taller;

public class HerramientaManager {

    private Herramienta[] bancoHerramientas = new Herramienta[10];

    public void generateBanco() {
        for (int i = 0; i < 10; i++) {
            bancoHerramientas[i] = new Herramienta();
        }
    }

    public void pickHerramientas(Herramienta h1, Herramienta h2) {
        Herramienta syncH1;
        Herramienta syncH2;
        if (h1.getId() > h2.getId()) {
            syncH1 = h1;
            syncH2 = h2;
        } else {
            syncH1 = h2;
            syncH2 = h1;
        }


        synchronized (syncH1) {
            synchronized (syncH2) {

            }
        }
    }

}
