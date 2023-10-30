package ejsdiapos.taller;

public class Taller {
    /*
     * Estamos  en  un  taller  de  pŕacticas,  donde  están  trabajando  5 alumnos  y en  el  que  tenemos
     *  un  banco  de  10 herramientas  para compartir entre los 5 alumnos.
     *
     * Herramienta bancoHerramientas=new Herramienta[10];
     *
     * Los  alumnos  están  continuamente  haciendo  prácticas,  para  las cuales   eligen   dos   herramientas
     * al   azar   y   cuando   las   tienen trabajan  un  tiempo  aleatorio,  entre  2  y  3  segundos,  y
     * después descansan un tiempo aleatorio, entre 1 y 2 segundos después de devolver las herramientas.
     * Para Herramienta únicamente necesitamos un identificador   para los mensajes.Muestra  la  evolución
     * de  la  simulación,  de  que  alumnos están trabajando con que herramienta y cudno están descansando.
     * */
    public static void main(String[] args) {

        Thread[] arrayAlumnos = new Thread[5];
        HerramientaManager hm = new HerramientaManager();
        hm.generateBanco();

        for (int i = 0; i < 5; i++) {
            new Thread(new Alumno());
        }




    }



}
