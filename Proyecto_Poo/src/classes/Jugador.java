package classes;

import java.util.Date;

/**
 *
 * @author estudiante
 */
public class Jugador {
    
    private String nombre;
    private String fecha;
    private String puntos;
    private String nivel;
    
    public Jugador(String nombre, String fecha, String puntos, String nivel) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.puntos = puntos;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }            
}
