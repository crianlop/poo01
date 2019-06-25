/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;
import Usuario.Cliente;
import java.io.*;

/**
 *
 * @author Administrator
 */

public class EdicionArchivos {
    public static void EscribirUsuarios(Cliente cliente,char perfil){
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        try{
            String file="cuentas.txt";            
            w= new FileWriter("cuentas.txt");
            bw=new BufferedWriter(w);
            wr=new PrintWriter (bw);
            wr.write(cliente.getNombre()+","+cliente.getApellido()+","+cliente.getUsuario()+","+cliente.getContrasena()+","+perfil+"/n");
            
            
        }catch (Exception e){
            
            
        }
        
        
    }
    public static boolean Login(String usuario, String contrasena){
        FileReader r;
        BufferedReader br;
        try{
            r= new FileReader("cuentas.txt");
            br=new BufferedReader(r);
            String bfread;
            while ((bfread=br.readLine())!=null){
                String[] lista=bfread.split(",");
                if (lista[2].equals(usuario) && lista[3].equals(contrasena))
                    return true;
            }
        }catch (Exception e){
            
        }
        return false;
    }
    public static String retornarPerfil(String usuario, String contrasena){
        FileReader r;
        BufferedReader br;
        try{
            r= new FileReader("C:\\Users\\Administrator\\Documents\\NetBeansProjects\\SistemaBancario\\src\\main\\java\\Archivos\\cuentas.txt");
            br=new BufferedReader(r);
            String bfread;
            while ((bfread=br.readLine())!=null){
                String[] lista=bfread.split(",");
                if (lista[2].equals(usuario) && lista[3].equals(contrasena))
                    return lista[4];
            }            
        }catch (Exception e){ 
        }
        return "A";
    }
    
}
