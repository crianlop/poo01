/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivo;

import Usuario.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;

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
//            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
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
//            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
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

    public static void EscribirCuenta(int idSolicitud, String usuario, String tipodecuenta, int NumeroCuenta, String plan) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        Date fecha = new Date();
        try {
            archivo = new File("cuentas.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
//            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
            linea.write("\n" + idSolicitud + "," + usuario + "," + tipodecuenta + "," + NumeroCuenta + "," + "pendiente,0," + plan + "," + fecha);
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }

    }

    public static void EscribirCuenta(int idSolicitud, String usuario, String tipodecuenta, int NumeroCuenta, String plan, int idchequera) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        Date fecha = new Date();
        try {
            archivo = new File("cuentas.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
//            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
            linea.write("\n" + idSolicitud + "," + usuario + "," + tipodecuenta + "," + NumeroCuenta + ",pendiente," + idchequera + "," + plan + "," + fecha);
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }

    }

    public static int retornarPriximoId(String archivo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero = bfread.split(",")[0];
            }
            br.close();
            r.close();
            if (numero.equals("Idsolicitud")) {
                numero = "0";
            }
        } catch (Exception e) {

        }
        int numero1 = Integer.parseInt(numero) + 1;
        return numero1;
    }

    public static int retornarValorCheque(String archivo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while (((bfread = br.readLine()) != null)) {
                String val = bfread.split(",")[5];
                if (!(val.equals("0"))) {
                    numero = bfread.split(",")[5];
                }
            }
            br.close();
            r.close();
            if (numero.equals("idchequera")) {
                numero = "0";
            }
        } catch (Exception e) {

        }
        int numero1 = Integer.parseInt(numero);
        return numero1;
    }

    public static int retornarProximaTransferencia(String archivo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero = bfread.split(",")[0];
            }
            br.close();
            r.close();
            if (numero.equals("Idtransferencia")) {
                numero = "0";
            }
        } catch (Exception e) {

        }
        int numero1 = Integer.parseInt(numero) + 1;
        return numero1;
    }

    public static String retornarTitular(String archivo, String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero = bfread.split(",")[2];
                if (numero.equals(usuario)) {
                    numero = bfread.split(",")[0] + " " + bfread.split(",")[1];
                }
                return numero;
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return "x";
    }

    public static boolean hacerTransferencia(String archivo, String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        String sol = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero = bfread.split(",")[1];
                sol = bfread.split(",")[4];
                if (numero.equals(usuario) && !(sol.equals("pendiente"))) {
                    return true;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return false;
    }

    public static void EcribirTransferencia(String idtransferencia, String tipo, String cuenta, String monto, String banco, String titular, String cedula, String descripcion) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("transferencias.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
//            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
            linea.write("\n" + idtransferencia + "," + tipo + "," + cuenta + "," + monto + "," + banco + "," + titular + "," + cedula + "," + descripcion);
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }
    }

    public static void CrearSolicitud(int Idsolicitud, String usuario, String tipo, String cuenta, String lugartrabajo, String sueldo, String tarjetas, String deudas, String estado) {
        File archivo;
        FileWriter escribir;
        BufferedWriter linea;
        try {
            archivo = new File("solicitudes.txt");
            escribir = new FileWriter(archivo, true);
            linea = new BufferedWriter(escribir);
//            linea.write("\n" + cliente.getNombre() + "," + cliente.getApellido() + "," + cliente.getUsuario() + "," + cliente.getContrasena() + "," + perfil + "");
            linea.write("\n" + Idsolicitud + "," + usuario + "," + tipo + "," + cuenta + "," + lugartrabajo + "," + sueldo + "," + tarjetas + "," + deudas + "," + estado + "");
            linea.close();
            escribir.close();

        } catch (Exception e) {

        }

    }

    public static int retornarProximaSolicitud(String archivo) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero = bfread.split(",")[0];
            }
            br.close();
            r.close();
            if (numero.equals("Idsolicitud")) {
                numero = "0";
            }
        } catch (Exception e) {

        }
        int numero1 = Integer.parseInt(numero) + 1;
        return numero1;
    }

    public static String NumeroCuenta(String usuario, String archivo, String cuenta) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        String numero = null;
        String estado = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                numero = bfread.split(",")[1];
                estado = bfread.split(",")[4];
                if (numero.equals(usuario) && !(estado.equals("pendiente")) && !(estado.equals("desactivado")) && cuenta.equals(bfread.split(",")[3])) {
                    return "s";
                } else if (numero.equals(usuario) && (estado.equals("pendiente")) && cuenta.equals(bfread.split(",")[3])) {
                    return "p";
                } else {
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return "x";
    }

    public static String NumeroTarjetas(String archivo, String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        int numero = 0;
        String estado = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                if (usuario.equals(bfread.split(",")[1]) && !(bfread.split(",")[8].equals("pendiente"))) {
                    numero++;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        return Integer.toString(numero);
    }

    public static void ConsultaEstadoTarjetas(String archivo, String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        Date fecha = new Date();
        int numero = 0;
        String estado = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                if (usuario.equals(bfread.split(",")[1])) {

                    System.out.println("Su solicitud de tarjeta de " + bfread.split(",")[2] + " con número: " + bfread.split(",")[0]
                            + " tiene estado " + bfread.split(",")[8] + " a la fecha " + fecha);

                    numero++;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        if (numero == 0) {
            System.out.println("No se encontraron solicitudes.");
        }
    }

    public static void ConsultaEstadoCuenta(String archivo, String usuario) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        Date fecha = new Date();
        int numero = 0;
        String estado = null;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                if (usuario.equals(bfread.split(",")[1])) {
                    System.out.println("Su solicitud de cuenta de " + bfread.split(",")[2] + " con número: " + bfread.split(",")[0]
                            + " tiene estado " + bfread.split(",")[4] + " a la fecha " + fecha);

                    numero++;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        if (numero == 0) {
            System.out.println("No se encontraron solicitudes.");
        }
    }

    public static void ConsultarSolicitud(String archivo, String estado) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        int numero = 0;
        try {
            BufferedWriter linea2 = new BufferedWriter(new FileWriter(archivo));
            linea2.write("");
            linea2.close();
            BufferedWriter linea1 = new BufferedWriter(new FileWriter(archivo));
            r = new FileReader("cuentas.txt");
            br = new BufferedReader(r);
            String bfread1;
            while ((bfread1 = br.readLine()) != null) {
                linea1.write('\n' + bfread1);
            }
            linea1.close();
            br.close();
            r.close();

            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            br.readLine();
            while ((bfread = br.readLine()) != null) {
                if (estado.equals(bfread.split(",")[4])) {
                    numero++;
                    System.out.println(numero + ") IdSolicitud: " + bfread.split(",")[0]);
                }

            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
        if (numero == 0) {
            System.out.println("No se encontraron solicitudes.");
        }
    }

    public static int ContadorSolicitudes(String archivo, String estado) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        int numero = 0;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            br.readLine();
            while ((bfread = br.readLine()) != null) {
                if (estado.equals(bfread.split(",")[4])) {

                    numero++;
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return numero;

    }

    public static void ConsultarCuenta(String archivo, String Idsolicitud) {
        FileReader r;
        BufferedReader br;
        BufferedWriter bw;
        try {
            r = new FileReader(archivo);
            br = new BufferedReader(r);
            String bfread;
            while ((bfread = br.readLine()) != null) {
                if (Idsolicitud.equals(bfread.split(",")[0])) {
                    System.out.println("Tipo de cuenta:" + bfread.split(",")[2]
                            + "\n Numero de cuenta: " + bfread.split(",")[3]
                            + "\n Usuario: " + bfread.split(",")[1]
                            + "\n Plan: " + bfread.split(",")[6]);
                }
            }
            br.close();
            r.close();
        } catch (Exception e) {

        }
    }

    public static void CambiarEstado(String archivo, String archivoDeLectura, String Idsolicitud) {
        FileReader r;
        BufferedReader br;
        FileReader r2;
        BufferedReader br2;
        try {
//            BufferedWriter linea1 = new BufferedWriter(new FileWriter(archivoDeLectura));
//            r = new FileReader(archivo);
//            br = new BufferedReader(r);
//            String bfread1;
//            while ((bfread1 = br.readLine()) != null) {
//                linea1.write(bfread1);
//            }
            BufferedWriter linea = new BufferedWriter(new FileWriter(archivo));
            linea.write("");
            linea.close();
            linea = new BufferedWriter(new FileWriter(archivo));
            r = new FileReader(archivoDeLectura);
            br = new BufferedReader(r);
            String bfread;
            br.readLine();
            linea.write(br.readLine());
            while ((bfread = br.readLine()) != null) {
                if (Idsolicitud.equals(bfread.split(",")[0])) {
                    linea.write( "\n"+bfread.split(",")[0] + "," + bfread.split(",")[1] + "," + bfread.split(",")[2] + "," + bfread.split(",")[3] + ",activo," + bfread.split(",")[5] + "," + bfread.split(",")[6] + "," + bfread.split(",")[7]);
                } else {
                    linea.write( "\n"+bfread.split(",")[0] + "," + bfread.split(",")[1] + "," + bfread.split(",")[2] + "," + bfread.split(",")[3] + "," + bfread.split(",")[4] + "," + bfread.split(",")[5] + "," + bfread.split(",")[6] + "," + bfread.split(",")[7]);
                }
            }
            br.close();
            r.close();
            linea.close();

        } catch (Exception e) {

        }

    }
    public static void Desactivar(String tipo, String usuario, String numero){
        
    }

}
