/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarjeta;
import Archivo.ManejoArchivos;
import Interfaz.Transaccionable;
/**
 *
 * @author dylan
 */
public class Tarjeta implements Transaccionable {
    int numero;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void consultarEstado(String usuario) {
        ManejoArchivos.ConsultaEstadoTarjetas("solicitudes.txt", usuario);
    }

    @Override

    
    
}
