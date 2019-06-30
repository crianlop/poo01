/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import Archivo.ManejoArchivos;

/**
 *
 * @author Administrator
 */
public class Cliente extends Usuario{
    
    public Cliente(String Nombre, String Apellido, String Usuario, String Contrasena){
        nombre=Nombre;
        apellido=Apellido;
        usuario=Usuario;
        contrasena=Contrasena;
        ManejoArchivos.EscribirUsuarios(this, "C");
        

    }

}
    
    

