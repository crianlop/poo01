/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transferencia;
import Archivo.ManejoArchivos;

/**
 *
 * @author dylan
 */
public class Transferencia {
    private int idtransferencia;
    public Transferencia(String tipo, String cuenta, double monto,String banco,String titular,String cedula, String descripcion){
        idtransferencia=ManejoArchivos.retornarProximaTransferencia("transferencias.txt");
        ManejoArchivos.EcribirTransferencia(Integer.toString(idtransferencia), tipo, cuenta, Double.toString(monto), banco, titular, cedula, descripcion);
        
    }
    
}
