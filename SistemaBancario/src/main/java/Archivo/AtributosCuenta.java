/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import java.util.Date;

/**
 *
 * @author Manager
 */
public class AtributosCuenta {
    private int Idsolicitud;
    private String usuario;
    private String tipocuenta;
    private int numerocuenta;
    private String estado;
    private int idchequera;
    private int tipoplan;
    private Date fechacreacion;
    public AtributosCuenta(){
    }

    public AtributosCuenta(int Idsolicitud, String usuario, String tipocuenta, int numerocuenta, String estado, int idchequera, int tipoplan, Date fechacreacion) {
        this.Idsolicitud = Idsolicitud;
        this.usuario = usuario;
        this.tipocuenta = tipocuenta;
        this.numerocuenta = numerocuenta;
        this.estado = estado;
        this.idchequera = idchequera;
        this.tipoplan = tipoplan;
        this.fechacreacion = fechacreacion;
    }
    
    
    
}
