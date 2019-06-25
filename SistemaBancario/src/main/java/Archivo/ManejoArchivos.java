package Archivo;

import Usuario.*;
import java.io.*;
import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class ManejoArchivos {

    public static void EscribirUsuarios(Cliente cliente, String perfil) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("usuarios.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }

    }

    public static void EscribirUsuarios(Empleado cliente, String perfil) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("usuarios.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write(cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "" + "\n");// Es necesario el salto de linea para que el ultima linea pueda leerse
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }

    }

    public static boolean Login(String usuario, String contrasena) {
        FileReader r;
        BufferedReader br;
        try {
            r = new FileReader("usuarios.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[2].equals(usuario) && lista[3].equals(contrasena)) {
                    return true;
                }
            }
            br.close();
            r.close();

        } catch (Exception e) {

        }
        return false;
    }

    public static String retornarPerfil(String usuario, String contrasena) {
        FileReader r;
        BufferedReader br;
        try {
            r = new FileReader("usuarios.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[2].equals(usuario) && lista[3].equals(contrasena)) {
                    return lista[4];
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {
        }
        return "ESTO NUNCA VA A SER DEVUELTO";
    }

    public static boolean ValidacionCreacionUsuario(String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader("usuarios.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[2].equals(usuario)) {
                    return true;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return false;
    }

    public static String generarReporte(String usuario, String tipoCuenta, String tipoPlan) {

        return null;
    }

    public static boolean ValidarNumeroCuenta(String numero, String archivo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[3].equals(numero)) {
                    return true;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return false;
    }

    public static void EscribirCuenta(String idSolicitud, String usuario, String tipodecuenta, int NumeroCuenta, String plan) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        Date fecha = new Date();
        try {
            archivo = new File("cuentas.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write("\n" + idSolicitud + "," + usuario + "," + tipodecuenta + "," + NumeroCuenta + "," + "pendiente,0," + plan + "," + fecha);
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }

    }
    
    public static boolean ValidarCuentaActiva(String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader("cuentas.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[1].equals(usuario)) {
                    if (lista[4].equals("activa")){
                        return true;
                    }                
                    else {
                        return false;
                    }
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return false;
    }

    public static boolean ValidarExistenciaSolicitud(String usuario, String tipo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader("solicitudes.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[1].equals(usuario)) {
                    if (lista[1].equals(usuario) && lista[2].equals(tipo)){
                        return true;
                    }                                    
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return false;
    }
    
    public static String EncontrarTitular(String numeroCuenta) {
        String titular = "";
        String usuario = "";
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader("cuentas.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[3].equals(numeroCuenta)) {
                    usuario = lista[1];
                }
            }
            br.close();
            r.close();
            
            r = new FileReader("usuarios.txt");
            br = new BufferedReader(r);
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[2].equals(usuario)) {
                    titular = lista[0] + " " + lista[1];
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return titular;
    }
    
    public static void EscribirCuenta(String idSolicitud, String usuario, String tipodecuenta, int NumeroCuenta, String plan, String idchequera) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        Date fecha = new Date();
        try {
            archivo = new File("cuentas.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write("\n" + idSolicitud + "," + usuario + "," + tipodecuenta + "," + NumeroCuenta + ",inactivo," + idchequera + "," + plan + "," + fecha);
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }
    }
    
    public static void EscribirTransferencia(String idtransferencia, String tipo, String cuenta, double monto, String banco, String titular, String cedula, String descripcion) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("transferencias.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write(idtransferencia + "," + tipo + "," + cuenta + "," + monto + "," + banco + "," +  titular + "," + cedula + "," + descripcion + "\n");
            linea.close();
            escribir.close();
        } catch (Exception e) {

        }
    }
    
    public static void EscribirSolicitud(String idtransferencia, String usuario, String tipo, String cuenta, String trabajo, double sueldo, int tarjeta, double deudas, String estado) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("solicitudes.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write(idtransferencia + "," + usuario + "," + tipo + "," + cuenta + "," + trabajo + "," +  sueldo + "," + tarjeta + "," + deudas + "," + estado + "\n");
            linea.close();
            escribir.close();
        } catch (Exception e) {

        }
    }

    public static int retornarPriximoId(String archivo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero=null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero=bfread.split(",")[0];
                }
            br.close();
            r.close();
            if (numero.equals("Idsolicitud"))
                numero="0";
        } catch (Exception e) {

        }
        int numero1=Integer.parseInt(numero)+1;
        return numero1;
    }
    
    public static ArrayList<String> cuentasPendientes() {
        ArrayList<String> array = new ArrayList<>();
        
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader("cuentas.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[4].equals("pendiente")) {
                    array.add(bfread);
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        
        return array;
    }
    
    public static ArrayList<String> solicitudesPendientes() {
        ArrayList<String> array = new ArrayList<>();
        
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader("solicitudes.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if (lista[8].equals("pendiente")) {
                    array.add(bfread);
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        
        return array;
    }
    
    public static void desactivar(String usuario, String archivo, int tipo) {
        String[] array = null;
        int count = 0;
        
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                switch(tipo) {
                    case 0 :
                        if(lista[1].equals(usuario) && lista[8].equals("aprobado")) {
                            System.out.println("Estimado" + usuario 
                                    + ", ya no podrá volver a utilizar su tarjeta de" +
                                    "crédito número " + lista[1] +". Si la necesita debe "
                                            + "solicitar una nueva.");
                        } else array[count++] = bfread;
                        break;
                    case 1:
                        if(lista[1].equals(usuario) && lista[8].equals("pendiente")) {
                            System.out.println("Estimado" + usuario 
                                    + ", esta solicitud ya no procede. Para" +
                                    "solicitar una tarjeta debe generar una nueva solicitud.");
                            lista[8] = "desactivado";
                            StringBuilder sb = new StringBuilder();
                            for(String a: lista) {
                                sb.append(a);
                                sb.append(",");
                            }
                            array[count++] = sb.toString();
                        } else array[count++] = bfread;
                        break;
                    case 2:
                        if(lista[1].equals(usuario)) {
                            System.out.println("Estimado" + usuario 
                                    + ", su cuenta ha sido desactivada. Para volver a" +
                                    "activarla, comuníquese con su asesor bancario.");
                            lista[4] = "desactivado";
                            StringBuilder sb = new StringBuilder();
                            for(String a: lista) {
                                sb.append(a);
                                sb.append(",");
                            }
                            array[count++] = sb.toString();
                        } else array[count++] = bfread;
                        break;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        
        File file;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            file = new File(archivo);
            escribir = new FileWriter(file, true);
            linea = new BufferedWriter(escribir);
            for(String a: array)
                linea.write(a);
            linea.close();
            escribir.close();
        } catch (Exception e) {

        }
    }
    
    public static void Deposito(String nombreUsuario, double monto){
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numeroCuenta= " ";
        try {
            r = new FileReader("cuentas.txt");
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                String[] lista = bfread.split(",");
                if(lista[1].equals(nombreUsuario)){
                    numeroCuenta = lista[3];
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
    
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("Deposito.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
            linea.write(numeroCuenta+","+monto);
            linea.close();
            escribir.close();
        } catch (Exception e) {

        }
    }    
}