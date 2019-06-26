/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuenta;

import Archivo.ManejoArchivos;
import Chequera.Chequera;

/**
 *
 * @author Administrator
 */
public class CuentaCorriente extends Cuenta {

    private Chequera chequera;

    public CuentaCorriente(String usuario) {
        int primerCheque = ManejoArchivos.retornarValorCheque("cuentas.txt");
        chequera = new Chequera(primerCheque);
        numeroCuenta = (int) Math.floor(Math.random() * 1000000000 + (100000000));
        while (ManejoArchivos.ValidarNumeroCuenta(Integer.toString(numeroCuenta), "cuentas.txt")) {
            numeroCuenta = (int) Math.floor(Math.random() * 1000000000 + (100000000));
        }
        int idsolicitud = ManejoArchivos.retornarPriximoId("cuentas.txt");
        ManejoArchivos.EscribirCuenta(idsolicitud, usuario, "corriente", numeroCuenta, "no aplica plan", primerCheque + 50);
    }

    public Chequera getChequera() {
        return chequera;
    }

    public void setChequera(Chequera chequera) {
        this.chequera = chequera;
    }
    
}
