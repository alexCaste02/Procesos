package oscar.servicio_ordenacion;

public class Protocolo {
    private final String terminador="\n";
    public String getMensajeVersion(int version){
        Integer i=version;
        return i.toString()+terminador;
    }
    public int getNumVersion(String mensaje){
        Integer num=Integer.parseInt(mensaje);
        return num;
    }
    public String getMensaje(String cadena){
        return cadena+terminador;
    }
}