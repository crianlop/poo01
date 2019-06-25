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
public class Empleado extends Usuario{
    
    public Empleado(String Nombre, String Apellido, String Usuario, String Contrasena){ // Cuando no se da tipo de acceso a constructor es protected por defecto
        nombre=Nombre;
        apellido=Apellido;
        usuario=Usuario;
        contrasena=Contrasena;
        ManejoArchivos.EscribirUsuarios(this, "E");
    }

//    public String getNombre() {
//        return nombre;
//    }
//
//    public void setNombre(String nombre) {
//        this.nombre = nombre;
//    }
//
//    public String getApellido() {
//        return apellido;
//    }
//
//    public void setApellido(String apellido) {
//        this.apellido = apellido;
//    }
//
//    public String getUsuario() {
//        return usuario;
//    }
//
//    public void setUsuario(String usuario) {
//        this.usuario = usuario;
//    }
//
//    public String getContrasena() {
//        return contrasena;
//    }
//
//    public void setContrasena(String contrasena) {
//        this.contrasena = contrasena;
//    }
    
}