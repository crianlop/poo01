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
public class TarjetaCredito extends Tarjeta {
    public static void CrearSolicitud(String usuario,String lugartrabajo,String sueldo, String tarjetas,String deudas){
        int idSolicitud=ManejoArchivos.retornarPriximoId("solicitudes.txt");
        ManejoArchivos.CrearSolicitud(idSolicitud, usuario, "credito","no aplica", lugartrabajo, sueldo,tarjetas,deudas, "pendiente");
        
    
}
}
