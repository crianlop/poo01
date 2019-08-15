package classes;

import java.util.Date;

/**
 *
 * @author estudiante
 */
public class Jugador {
    
    private String nombre;
    private Date fecha;
    private int puntos;
    private int nivel;
    
    public Jugador(String nombre, Date fecha, int puntos, int nivel) {
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }            
}
