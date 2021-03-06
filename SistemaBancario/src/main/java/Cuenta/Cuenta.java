
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuenta;

import Archivo.ManejoArchivos;
import Usuario.Cliente;
import Interfaz.Transaccionable;

/**
 *
 * @author Administrator
 */
public class Cuenta implements Transaccionable{

    protected Cliente cliente;
    protected int numeroCuenta;

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public void consultarEstado(String usuario) {
        ManejoArchivos.ConsultaEstadoCuenta("cuentas.txt", usuario);
    }

    @Override
    public void desactivar(String usuario, String numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
