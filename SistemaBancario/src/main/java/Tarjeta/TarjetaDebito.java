/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjeta;

import Archivo.ManejoArchivos;

/**
 *
 * @author dylan
 */
public class TarjetaDebito extends Tarjeta {
        
    public TarjetaDebito(String linea){
        
    }
    public static void CrearSolicitud(String usuario, String numeroCuenta){
        int idSolicitud=ManejoArchivos.retornarPriximoId("solicitudes.txt");
        ManejoArchivos.CrearSolicitud(idSolicitud, usuario, "debito", numeroCuenta, "no aplica", "no aplica", "no aplica", "no aplica", "pendiente");
    }    
}
