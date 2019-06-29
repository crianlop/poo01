package solicitud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.util.Date;

/**
 *
 * @author Adminitrador
 */
public class Solicitud implements TRANSACCIONABLE{
    
    private String idSolicitud;
    private String usuario;
    private String tipo;
    private String cuenta;
    private String lugarTrabajo;
    private double sueldo;
    private int tarjetas;
    private double deudas;

    public Solicitud(String idSolicitud, String usuario, String tipo, String cuenta, String lugarTrabajo, double sueldo, int tarjetas, double deudas) {
        this.idSolicitud = idSolicitud;
        this.usuario = usuario;
        this.tipo = tipo;
        this.cuenta = cuenta;
        this.lugarTrabajo = lugarTrabajo;
        this.sueldo = sueldo;
        this.tarjetas = tarjetas;
        this.deudas = deudas;
    }        

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }        
    
    @Override
    public void consultarEstado() {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        Date fecha = new Date();
        try {
            r = new FileReader("solicitudes.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[1].equals(usuario)) {
                    if (lista[2].equals("debito")){
                        System.out.println("Su solicitud de tarjeta de debito con número: "
                                + lista[0] + " tiene estado " + lista[8].toUpperCase() + 
                                " a la fecha" + fecha);
                    } else if (lista[2].equals("credito")){
                        System.out.println("Su solicitud de tarjeta de debito con número: "
                                + lista[0] + " tiene estado " + lista[8].toUpperCase() + 
                                " a la fecha" + fecha);
                    }
                }
            }
            br.close();
            r.close();
            
            r = new FileReader("cuentas.txt");
            br = new BufferedReader(r);            
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[1].equals(usuario)) {
                    System.out.println("Su solicitud de creacion de cuenta con número: "
                                + lista[0] + " tiene estado " + lista[4].toUpperCase() + 
                                " a la fecha" + fecha);
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }        
    }
}


