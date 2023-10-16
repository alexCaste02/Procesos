package psp.sumador;

public class U2EG5_Sumador {
    public static void main(String[] args) {
        double numero1 = Double.parseDouble(args[0]);
        double numero2 = Double.parseDouble(args[1]);
        double resultado = 0;
        for (double i = numero1; i <= numero2; i++) {
            resultado = resultado + i;
        }
        System.out.println(resultado);
    }
}