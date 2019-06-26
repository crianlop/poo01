/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuenta;

import Archivo.ManejoArchivos;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class CuentaAhorro extends Cuenta {

    private String plan;

    public CuentaAhorro(String plan,String usuario) {
        this.plan = plan;
        numeroCuenta = (int) Math.floor(Math.random() * 1000000000 + (100000000));
        while (ManejoArchivos.ValidarNumeroCuenta(Integer.toString(numeroCuenta), "cuentas.txt")) {
            numeroCuenta = (int) Math.floor(Math.random() * 1000000000 + (100000000));
        }
        int idsolicitud=ManejoArchivos.retornarPriximoId("cuentas.txt");
        ManejoArchivos.EscribirCuenta(idsolicitud, usuario, "ahorro", numeroCuenta, plan);
    }

}
