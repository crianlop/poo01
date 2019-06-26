/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Archivo.ManejoArchivos;
import java.util.Scanner;
import Usuario.*;
import Cuenta.*;
import Tarjeta.*;
import Transferencia.Transferencia;

/**
 *
 * @author Aadministrator
 */
public class MainMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("           Bienvenido al Sistema           ");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        System.out.print("USUARIO: ");
        String usuario = sc.nextLine();
        System.out.print("CONTRASENA: ");
        String contrasena = sc.nextLine();
        boolean login = ManejoArchivos.Login(usuario, contrasena);
        while (!login) {
            MainMenu.Error();
            System.out.print("USUARIO: ");
            usuario = sc.nextLine();
            System.out.print("CONTRASENA: ");
            contrasena = sc.nextLine();
            login = ManejoArchivos.Login(usuario, contrasena);
        }
        String perfil;
        perfil = ManejoArchivos.retornarPerfil(usuario, contrasena);
        MainMenu.menu(usuario, perfil);

//    menu
    }

    private static void menu(String nombreUsuario, String Perfil) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente;
        Empleado empleado;
        if (Perfil.toUpperCase().equals("A")) {
            String idx3 = "";
            while (!(idx3.equals("2"))) {
                System.out.println("Menu Admin");
                System.out.println("1. Crear Usuario");
                System.out.println("2. Salir");
                System.out.print("Ingrese la opcion: ");
                idx3 = sc.nextLine();
                if (idx3.equals("1")) {
                    System.out.println("Que perfil tendra el nuevo usuario?");
                    System.out.println("1. Empleado (E)");
                    System.out.println("2. Cliente (C)");
                    System.out.print("Selecciones: ");
                    String idx4 = sc.nextLine();

//                    validacion
                    while (!(idx4.equals("E") || idx4.equals("C"))) {
                        System.out.println("error!");
                        System.out.println("Que perfil tendra el nuevo usuario?");
                        System.out.println("1. Empleado (E)");
                        System.out.println("2. Cliente (C)");
                        System.out.print("Selecciones: ");
                        idx4 = sc.nextLine();
                    }

                    System.out.print("Ingrese el nombre:");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese el apellido:");
                    String apellido = sc.nextLine();
                    System.out.print("Ingrese el usuario:");
                    String usuario = sc.nextLine();
                    while (ManejoArchivos.ValidacionCreacionUsuario(usuario)) {
                        MainMenu.Error();
                        System.out.print("Ingrese el usuario:");
                        usuario = sc.nextLine();
                    }
                    System.out.print("Ingrese el contrasena:");
                    String contrasena = sc.nextLine();
                    char char_1 = contrasena.charAt(0);
                    while (!(Character.isUpperCase(char_1)) || !(contrasena.length() <= 12) || !(contrasena.length() >= 8)) {
                        MainMenu.Error();
                        System.out.print("Contrasena nueva: ");
                        contrasena = sc.nextLine();
                        char_1 = contrasena.charAt(0);
                    }
                    System.out.println("La contrasena es valida");
                    System.out.print("Desea guardar los cambios realizados? (S/N)");
                    String idx9 = sc.nextLine();
                    if (idx9.equals("S") && (idx4.equals("C"))) {
                        cliente = new Cliente(nombre, apellido, usuario, contrasena);
//                        ManejoArchivos.EscribirUsuarios(cliente, idx4);
                    } else if (idx9.equals("S") && (idx4.equals("E"))) {
                        cliente = new Cliente(nombre, apellido, usuario, contrasena);

                    } else {
                    }
                } else if (idx3.equals("2")) {
                } else {
                    MainMenu.Error();
                }
            }

        }if(Perfil.toUpperCase().equals("E")){
            MainMenu.lineas();
            MainMenu.menuEmpleado();
            MainMenu.lineas();
            String opcion = sc.nextLine();
             while (!opcion.equals("4")) {
                 if (opcion.equals("1")) {
                     System.out.println("------Solicitudd de creaccion de cuentas---------");
                     ManejoArchivos.ConsultarSolicitud("SolicitudCuentas.txt","pendiente");
                      int contador;
                      contador=ManejoArchivos.ContadorSolicitudes("SolicitudCuentas.txt","pendiente");
                      if(contador>0){
                      System.out.println("Elija una opcion: ");
                      String opcionId=sc.nextLine();
                      ManejoArchivos.ConsultarCuenta("SolicitudCuentas.txt", opcionId);
                      System.out.print("Desea aprobar la creacion de esta cuenta (s/n): ");
                      String aprobar = sc.nextLine();
                      if(aprobar.equals("s")){
                          ManejoArchivos.CambiarEstado("cuentas.txt","SolicitudCuentas.txt",opcionId);
                          System.out.println("Cuenta Aprobada.");
                      }
                      
                      }       
                }else if(opcion.equals("2")) {
                }else if(opcion.equals("3")) {    
                }else if (opcion.equals("4")) {
                } else {
                    MainMenu.Error();
                    opcion = sc.nextLine();
                }
                MainMenu.lineas();
                MainMenu.menuEmpleado();
                MainMenu.lineas();
                opcion = sc.nextLine();
             }
            
        }
        else if (Perfil.toUpperCase().equals("C")) {
            MainMenu.lineas();
            MainMenu.menuCliente();
            MainMenu.lineas();
            String opcion = sc.nextLine();
            String cuenta;
            while (!opcion.equals("6")) {
                if (opcion.equals("1")) {
                    System.out.print("------Creación de Cuentas---------\n"
                            + "Usuario: " + nombreUsuario + "\n"
                            + "Tipo de cuenta: Corriente o de Ahorros (c/a):");
                    cuenta = sc.nextLine();
                    while (!cuenta.equals("a") && !cuenta.equals("c")) {
                        MainMenu.Error();
                        cuenta = sc.nextLine();
                    }
                    if (cuenta.equals("c")) {
                        System.out.print("¿Desea crear su cuenta (s/n)?:");
                        String idxcliente1 = sc.nextLine();
                        if (idxcliente1.equals("s")) {
                            System.out.println("Generando chequera......");
                            CuentaCorriente cuentacorriente = new CuentaCorriente(nombreUsuario);
                            MainMenu.lineas();
                            System.out.println("Se ha creado su cuenta con el código: " + cuentacorriente.getNumeroCuenta() + ".");
                        } else if (idxcliente1.equals("n")) {
                        } else {
                            MainMenu.Error();
                        }

                    } else if (cuenta.equals("a")) {
                        String plan;
                        System.out.print("Indique el tipo de plan al que quiere pertenecer:\n"
                                + "1. Plan Joven\n"
                                + "2. Plan Ahorro Casa\n"
                                + "3. Plan Estándar\n"
                                + "Seleccione:");
                        plan = sc.nextLine();
                        while (!plan.equals("1") && !plan.equals("2") && !plan.equals("3")) {
                            MainMenu.Error();
                            plan = sc.nextLine();
                        }
                        System.out.print("¿Desea crear su cuenta (s/n)?:");
                        String idxcliente = sc.nextLine();
                        if (idxcliente.equals("s")) {
                            CuentaAhorro cuentaahorro = new CuentaAhorro(plan, nombreUsuario);
                            System.out.println("Se ha creado su cuenta con el código:" + cuentaahorro.getNumeroCuenta() + ".\n"
                                    + "Recuerde que tiene 24 horas para realizar un depósito de al\n"
                                    + "menos 25 dólares para activar su cuenta.");
                        } else if (idxcliente.equals("n")) {
                        } else {
                            MainMenu.Error();
                        }
                    } else {
                        MainMenu.Error();
                    }
                } else if (opcion.equals("2")) {
                    MainMenu.lineas();
                    System.out.print("El tipo de transferencia es interna o externa? (i/e):");
                    String transferencia = sc.nextLine();
                    while (!(transferencia.equals("i")) && !(transferencia.equals("e"))) {
                        MainMenu.Error();
                        System.out.print("El tipo de transferencia es interna o externa? (i/e):");
                        transferencia = sc.nextLine();
                    }
                    Transferencia trans;
                    if (ManejoArchivos.hacerTransferencia("cuentas.txt", nombreUsuario)) {
                        if (transferencia.equals("i")) {
                            System.out.print("cuenta:");
                            String cuenta1 = sc.nextLine();
                            while (ManejoArchivos.retornarTitular("cuentas.txt", cuenta1).equals("x")) {
                                MainMenu.Error();
                            }
                            String titular = ManejoArchivos.retornarTitular("cuentas.txt", cuenta1);
                            System.out.print("monto:");
                            double monto = sc.nextInt();
                            System.out.print("cedula:");
                            String cedula = sc.next();
                            System.out.print("descripcion:");
                            String descripcion = sc.nextLine();
                            if (true) {
                                trans = new Transferencia(transferencia, cuenta1, monto, "interna", titular, cedula, descripcion);
                            }

                        } else {
                            System.out.print("cuenta:");
                            String cuenta1 = sc.nextLine();
                            while (ManejoArchivos.retornarTitular("cuentas.txt", cuenta1).equals("x")) {
                                MainMenu.Error();
                            }
                            String titular = ManejoArchivos.retornarTitular("cuentas.txt", cuenta1);
                            System.out.print("banco:");
                            String banco = sc.nextLine();
                            System.out.print("monto:");
                            double monto = sc.nextInt();
                            System.out.print("cedula:");
                            String cedula = sc.next();
                            System.out.print("descripcion:");
                            String descripcion = sc.nextLine();
                            if (true) {
                                trans = new Transferencia(transferencia, cuenta1, monto, banco, titular, cedula, descripcion);
                            }
                        }
                    }else{
                        System.out.println("no es posible realizar una transferencia");
                    }

                } else if (opcion.equals("3")) {
                    MainMenu.lineas();
                    System.out.println("Seleccione el tipo de tarjeta que desea solicitar");
                    System.out.print("cerdito/debito (c/d):");
                    String tarjetaseleccion = sc.nextLine();
                    while (!tarjetaseleccion.equals("c") && !tarjetaseleccion.equals("d")) {
                        MainMenu.Error();
                        tarjetaseleccion = sc.nextLine();
                    }
                    if (tarjetaseleccion.equals("d")) {
                        System.out.print("Ingrese su usuario:");
                        String usuario = sc.nextLine();
                        while (!usuario.equals(nombreUsuario)) {
                            MainMenu.Error();
                            System.out.print("Ingrese su usuario:");
                            usuario = sc.nextLine();
                        }
                        System.out.print("Ingrese su numero de cuenta:");
                        String numeroCuenta = sc.nextLine();
                        if (ManejoArchivos.NumeroCuenta(usuario, "cuentas.txt", numeroCuenta).equals("x")) {
                            MainMenu.Error();
                        } else if (ManejoArchivos.NumeroCuenta(usuario, "cuentas.txt", numeroCuenta).equals("p")) {
                            System.out.println("Su cuenta todavia no ha sido aprobada.");
                        } else {
                            TarjetaDebito.CrearSolicitud(usuario, numeroCuenta);
                            System.out.println("Su solicitud ha sido generada.");
                        }
                    } else {
                        System.out.print("Ingrese su usuario:");
                        String usuario = sc.nextLine();
                        while (!usuario.equals(nombreUsuario)) {
                            MainMenu.Error();
                            System.out.print("Ingrese su usuario:");
                            usuario = sc.nextLine();
                        }
                        System.out.print("Ingrese su lugar de trabajo:");
                        String trabajo = sc.nextLine();
                        System.out.print("Ingrese su sueldo:");
                        String sueldo = sc.nextLine();
                        System.out.print("Ingrese su cantidad de trajetas adquiridas:");
                        String tarjetas = sc.nextLine();
                        while (!tarjetas.equals(ManejoArchivos.NumeroTarjetas("solicitudes.txt", usuario))) {
                            MainMenu.Error();
                            System.out.print("Ingrese su cantidad de trajetas adquiridas:");
                            tarjetas = sc.nextLine();
                        }
                        System.out.print("Ingrese sus deudas:");
                        String deudas = sc.nextLine();
                        System.out.print("Desea generar la tarjeta (s/n)?");
                        String respuesta = sc.nextLine();
                        while (!respuesta.equals("s") && !respuesta.equals("n")) {
                            MainMenu.Error();
                            System.out.print("Desea generar la tarjeta (s/n)?");
                            respuesta = sc.nextLine();
                        }
                        if (respuesta.equals("s")) {
                            TarjetaCredito.CrearSolicitud(usuario, trabajo, sueldo, tarjetas, deudas);
                            System.out.println("Su solicitud ha sido generada.");
                        }
                    }
                } else if (opcion.equals("4")) {
                    System.out.println("1.-Cuentas");
                    System.out.println("2.-Tarjetas");
                    System.out.print("->");
                    String seleccion = sc.nextLine();
                    while (!seleccion.equals("1") && !seleccion.equals("2")) {
                        MainMenu.Error();
                        System.out.println("1.-Cuentas");
                        System.out.println("2.-Tarjetas");
                        System.out.print("->");
                        seleccion = sc.nextLine();
                    }
                    if (seleccion.equals("1")) {
                        Cuenta cuentafalsa = new Cuenta();
                        cuentafalsa.consultarEstado(nombreUsuario);
                    } else {
                        Tarjeta tarjetafalsa = new Tarjeta();
                        tarjetafalsa.consultarEstado(nombreUsuario);
                    }

                } else if (opcion.equals("5")) {
                    System.out.println("1.-Cuentas");
                    System.out.println("2.-Tarjetas");
                    System.out.print("->");
                    String seleccion = sc.nextLine();
                    while (!seleccion.equals("1") && !seleccion.equals("2")) {
                        MainMenu.Error();
                        System.out.println("1.-Cuentas");
                        System.out.println("2.-Tarjetas");
                        System.out.print("->");
                        seleccion = sc.nextLine();
                    }
                    if (seleccion.equals("1")) {
                    }

                } else if (opcion.equals("6")) {
                } else {
                    MainMenu.Error();
                    opcion = sc.nextLine();
                }
                MainMenu.lineas();
                MainMenu.menuCliente();
                MainMenu.lineas();
                opcion = sc.nextLine();
            }
        }
    }

    private static void Error() {
        MainMenu.lineas();
        System.out.println("error!");
        MainMenu.lineas();
    }

    private static void lineas() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
    }

    private static void menuCliente() {
        System.out.println(
                "1. Abrir cuenta bancaria\n"
                + "2. Realizar transferencia\n"
                + "3. Solicitar tarjeta\n"
                + "4. Consultar estado de solicitudes\n"
                + "5. Desactivar\n"
                + "6. Salir");
    }
    private static void menuEmpleado() {
        System.out.println(
                "1. Aprovar creacion de cuentas\n"
                + "2. Aprobar solicitudes de tarjeta\n"
                + "3. Obtener reporte de clientes\n"
        +"4. Salir");
    }
    
}
