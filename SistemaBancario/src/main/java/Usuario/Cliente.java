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
//    public void setNombre(String nombre_dado){
//        nombre=nombre_dado;
//    }
//    public void setApellido(String apellido_dado){
//        apellido=apellido_dado;
//    }
//    public void setUsuario(String usuario_dado){
//        usuario=usuario_dado;
//    }
//    public void setContrasena(String contrasena_dada){
//        contrasena=contrasena_dada;
//    }
//    public String getNombre(){
//        return nombre;
//    }
//    public String getApellido(){
//        return apellido;
//    }
//    public String getUsuario(){
//        return usuario;
//    }
//    public String getContrasena(){
//        return contrasena;
//    }
//            
}
    
    

