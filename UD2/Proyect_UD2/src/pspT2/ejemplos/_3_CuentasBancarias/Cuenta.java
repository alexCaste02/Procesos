package pspT2.ejemplos._3_CuentasBancarias;

import java.util.concurrent.atomic.AtomicInteger;

public class Cuenta {

    int saldo;
    final String numCuenta;

    static AtomicInteger idCounter = new AtomicInteger(0);
    int id;

    public Cuenta(String numCuenta, int saldoInicial) {
        this.numCuenta = numCuenta;
        this.saldo = saldoInicial;
        this.id = idCounter.incrementAndGet();
    }

    public synchronized int getSaldo() {
        return saldo;
    }

    public synchronized void ingresar(int cantidad) {
        saldo += cantidad;
    }

    public synchronized void sacar(int cantidad) {
        saldo -= cantidad;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public int getId() {
        return id;
    }
}
