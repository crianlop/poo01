package Main;

import Archivo.ManejoArchivos;
import java.util.Scanner;
import java.util.ArrayList;
import solicitud.Solicitud;
import Usuario.*;
import Cuenta.*;

/**
 *
 * @author Administrator
 */
public class MainMenu {
    
    private static ArrayList<Solicitud> arraySolicitudes = new ArrayList<>();
    
    private static ArrayList<String> arrayCuentas = new ArrayList<>();
    private static ArrayList<String> arraySolicitudesPendientes = new ArrayList<>();
    
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
                    String idx9 = sc.nextLine().toUpperCase(); // Validacion de contraseña
                    if (idx9.equals("S") && (idx4.equals("C"))) {
                        cliente = new Cliente(nombre, apellido, usuario, contrasena);
                    } else if (idx9.equals("S") && (idx4.equals("E"))) {
                        empleado = new Empleado(nombre, apellido, usuario, contrasena); // se debe guardar empleado no cliente

                    } else {
                    }
                } else if (idx3.equals("2")) {
                } else {
                    MainMenu.Error();
                }
            }

        } else if (Perfil.toUpperCase().equals("C")) {
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
                            CuentaAhorro cuentaAhorro = new CuentaAhorro(plan, nombreUsuario);
                        } else if (idxcliente.equals("n")) {
                        } else {
                            MainMenu.Error();
                        };
                    } else {
                        MainMenu.Error();
                    }
                } else if (opcion.equals("2")) {
                    if(ManejoArchivos.ValidarCuentaActiva(nombreUsuario)){
                        String tipoTransferencia;
                        System.out.print("Indique el tipo de Transferencia que quiere realizar:\n"
                                + "1. Directa\n"
                                + "2. Otros Banco\n"
                                + "Seleccione:");
                        tipoTransferencia = sc.nextLine();
                        while(!tipoTransferencia.equals("1") && !tipoTransferencia.equals("2")) {
                            System.out.print("Indique el tipo de Transferencia que quiere realizar:\n"
                                + "1. Directa\n"
                                + "2. Otros Banco\n"
                                + "Seleccione:");
                            tipoTransferencia = sc.nextLine();
                        }
                        
                        String numeroCuenta, banco = "", titular = "", cedula = "", descripcion = "";
                        double monto;
                        
                        if(tipoTransferencia.equals("1")) {
                            System.out.println("Ingrese el numero de cuenta: ");
                            numeroCuenta = sc.nextLine();
                            System.out.println("Ingrese el monto de la transaccion: ");
                            monto = sc.nextDouble();
                            while(monto > 25.0) {
                                System.out.println("Su saldo es insuficiente para realizar la transaccion\n"
                                        + "Ingrese el monto de la transaccion: ");
                                monto = sc.nextDouble();
                            }                         
                        } else {                                                   
                            System.out.println("Cuenta: ");
                            numeroCuenta = sc.nextLine();
                            
                            System.out.println("Banco: ");
                            banco = sc.nextLine();
                            
                            System.out.println("Titular: ");
                            titular = sc.nextLine();
                            
                            System.out.println("Cédula: ");
                            cedula = sc.nextLine();
                            while(cedula.length() != 10) {
                                Error();
                                System.out.println("Cédula: ");
                                cedula = sc.nextLine();
                            }
                            
                            System.out.println("Monto: ");
                            monto = sc.nextDouble();
                            while(monto > 25.0) {
                                System.out.println("Su saldo es insuficiente para realizar la transaccion\n"
                                        + "Ingrese el monto de la transaccion: ");
                                monto = sc.nextDouble();
                            }
                            
                            System.out.println("Descripción: ");
                            descripcion = sc.nextLine();
                        }
                        
                        String validacion;
                        System.out.println("¿Está Seguro de realizar esta transferencia (s/n)?: ");
                        validacion = sc.nextLine().toUpperCase();
                        
                        if(validacion.equals("S") && tipoTransferencia.equals("1")) {
                            titular = ManejoArchivos.EncontrarTitular(numeroCuenta);
                            ManejoArchivos.EscribirTransferencia(String.valueOf(ManejoArchivos.retornarPriximoId("transferencias.txt")), 
                                    tipoTransferencia, numeroCuenta, monto, "Mi Banco", titular, cedula, descripcion);
                        } else if(validacion.equals("S")) {
                            ManejoArchivos.EscribirTransferencia(String.valueOf(ManejoArchivos.retornarPriximoId("transferencias.txt")), 
                                    tipoTransferencia, numeroCuenta, monto, banco, titular, cedula, descripcion);
                        }                   
                        
                    } else Error();
                } else if (opcion.equals("3")) {
                    if(ManejoArchivos.ValidarCuentaActiva(nombreUsuario)){
                        String tipoSolicitud;
                        System.out.print("Indique el tipo de solicitud que quiere realizar:\n"
                                + "1. Tarjeta de Debito\n"
                                + "2. Tarjeta de Credito\n"                               
                                + "Seleccione:");
                        tipoSolicitud = sc.nextLine();
                        
                        while(!tipoSolicitud.equals("1") && !tipoSolicitud.equals("2")) {
                            System.out.print("Indique el tipo de solicitud que quiere realizar:\n"
                                + "1. Tarjeta de Debito\n"
                                + "2. Tarjeta de Credito\n"                               
                                + "Seleccione:");
                            tipoSolicitud = sc.nextLine();
                        }
                        
                        String numeroCuenta = "", trabajo = "";
                        double sueldo = 0.0, deudas = 0.0;
                        int tarjetas = 0;
                        
                        if(tipoSolicitud.equals("1")){
                            if(ManejoArchivos.ValidarExistenciaSolicitud(nombreUsuario, "debito") || 
                                    ManejoArchivos.ValidarCuentaActiva(nombreUsuario)){
                                System.out.println("Usted no puede realizar la solicitud!!"); 
                            } else {
                                System.out.println("Ingrese su nombre de usuario: ");
                                nombreUsuario = sc.nextLine();
                                
                                System.out.println("Ingrese su numero de cuenta: ");
                                numeroCuenta = sc.nextLine();                                                              
                            }
                        } else {
                            if(ManejoArchivos.ValidarExistenciaSolicitud(nombreUsuario, "credito")){
                                System.out.println("Usted no puede realizar la solicitud!"); 
                            } else {
                                System.out.println("Ingrese su nombre de usuario: ");
                                nombreUsuario = sc.nextLine();
                                
                                System.out.println("Ingrese el lugar de trabajo: ");
                                trabajo = sc.nextLine();
                                
                                System.out.println("Ingrese su sueldo mensual: ");
                                sueldo = sc.nextDouble();
                                
                                System.out.println("Ingrese sus deudas mensuales: ");
                                deudas = sc.nextDouble();
                                
                                System.out.println("Ingrese el numero de tarjetas: ");
                                tarjetas = sc.nextInt();
                            }
                        }
                        
                        String id = String.valueOf(ManejoArchivos.retornarPriximoId("solicitudes.txt"));
                        ManejoArchivos.EscribirSolicitud(id, nombreUsuario, tipoSolicitud, numeroCuenta, trabajo, sueldo, tarjetas, deudas, "pendiente");
                        arraySolicitudes.add(new Solicitud(id, nombreUsuario, tipoSolicitud, numeroCuenta, trabajo, sueldo, tarjetas, deudas));
                    }else Error();
                } else if (opcion.equals("4")) {
                    for(Solicitud solicitud: arraySolicitudes) {
                        if(solicitud.getUsuario().equals(nombreUsuario)) solicitud.consultarEstado();
                    }
                } else if (opcion.equals("5")) {
                    String desactivar;
                    System.out.print("Indique el proceso que desea realizar:\n"
                            + "1. Desactivar tarjeta de Credito\n"
                            + "2. Desactivar solicitud de tarjetas\n"
                            + "3. Desactivar cuenta\n"                               
                            + "Seleccione:");
                    desactivar = sc.nextLine();
                    
                    while(!desactivar.equals("1") && !desactivar.equals("2") && 
                            desactivar.equals("3")) {
                            System.out.print("Indique el proceso que desea realizar:\n"
                            + "1. Desactivar tarjeta de Credito\n"
                            + "2. Desactivar solicitud de tarjetas\n"
                            + "3. Desactivar cuenta\n"                               
                            + "Seleccione:");
                        desactivar = sc.nextLine();
                    }
                    
                    if(desactivar.equals("1")) desactivarOpciones(nombreUsuario, 0);
                    else if(desactivar.equals("2")) desactivarOpciones(nombreUsuario, 1);
                    else desactivarOpciones(nombreUsuario, 2);
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
        } else if (Perfil.toUpperCase().equals("E")) {
            MainMenu.lineas();
            MainMenu.menuEmpleado();
            MainMenu.lineas();
            String opcion = sc.nextLine();
            while (!opcion.equals("5")) {
                if(opcion.equals("1")){
                    arrayCuentas = ManejoArchivos.cuentasPendientes();
                    solicitudesCuenta();
                    for(int i = 0; i < arrayCuentas.size(); i++) {
                        System.out.println(i + ":" + " " + arrayCuentas.get(i).split(",")[0]);
                    }
                    int cuentaAAprobar;
                    System.out.println("Ingrese una opcion: ");
                    cuentaAAprobar = sc.nextInt();
                                       
                    lineas();
                    if(cuentaAAprobar > arrayCuentas.size()) {
                        System.out.println("Ingreso un numero equivocado");
                        lineas();
                    }
                    else {
                        String value = arrayCuentas.get(cuentaAAprobar);
                        String [] cuenta = value.split(",");
                        System.out.println("Tipo de cuenta: " + cuenta[2]);
                        System.out.println("Numero de cuenta: " + cuenta[3]);
                        System.out.println("Usuario: " + cuenta[1]);
                        System.out.println("Plan: " + tipoPlan(cuenta[6]));                        
                        lineas();
                                            
                        String aprobar;
                        System.out.println("¿Desea aprobar la creación de esta cuenta? (s/n): ");
                        aprobar = sc.nextLine().toUpperCase();
                        if(aprobar.equals("S")) {
                            arrayCuentas.remove(cuentaAAprobar);
                            cuenta[4] = "activa";
                            StringBuilder sb = new StringBuilder();                            
                            for(String a: cuenta) {
                                sb.append(a);
                                sb.append(",");
                            }
                            arrayCuentas.add(sb.toString());
                            // Cambiar en archivo
                            System.out.println("CUENTA APROBADA");
                        } else System.out.println("CUENTA NO APROBADA");
                    }                                        

                } else if(opcion.equals("2")) {
                    arraySolicitudesPendientes = ManejoArchivos.solicitudesPendientes();
                    solicitudesPendientes();
                    for(int i = 0; i < arraySolicitudesPendientes.size(); i++) {
                        System.out.println(i + ":" + " " + arraySolicitudesPendientes.get(i).split(",")[0]);
                    }
                    int cuentaAAprobar;
                    System.out.println("Ingrese una opcion: ");
                    cuentaAAprobar = sc.nextInt();
                                       
                    lineas();
                    if(cuentaAAprobar > arraySolicitudesPendientes.size()) {
                        System.out.println("Ingreso un numero equivocado");
                        lineas();
                    }
                    else {
                        String value = arraySolicitudesPendientes.get(cuentaAAprobar);
                        String [] cuenta = value.split(",");
                        System.out.println("Tipo de tarjeta: " + cuenta[2]);
                        System.out.println("Numero de cuenta: " + cuenta[3]);
                        System.out.println("Usuario: " + cuenta[1]);
                        System.out.println("Sueldo: " + cuenta[5]);                        
                        lineas();
                                            
                        String aprobar;
                        System.out.println("¿Desea aprobar la creación de esta cuenta? (s/n): ");
                        aprobar = sc.nextLine().toUpperCase();
                        if(aprobar.equals("S")) {
                            arraySolicitudesPendientes.remove(cuentaAAprobar);
                            cuenta[8] = "activa";
                            StringBuilder sb = new StringBuilder();                            
                            for(String a: cuenta) {
                                sb.append(a);
                                sb.append(",");
                            }
                            arraySolicitudesPendientes.add(sb.toString());
                            // Cambiar en archivo
                            System.out.println("CUENTA APROBADA");
                        } else System.out.println("CUENTA NO APROBADA");
                    }
                } else if(opcion.equals("3")) {
                    // Reportes
                } else if (opcion.equals("4")) {                    
                    System.out.println("Ingrese el monto:");
                    double monto= sc.nextDouble();
                    ManejoArchivos.Deposito(nombreUsuario, monto);
                } else if(opcion.equals("5")){
                } 
                else {
                    Error();
                    opcion = sc.nextLine();
                }
                MainMenu.lineas();
                MainMenu.menuEmpleado();
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
        System.out.println("1. Aprobar creación de cuentas\n" +
                           "2. Aprobar solicitudes de tarjetas\n" +
                           "3. Obtener reporte de clientes\n" +
                           "4. Deposito\n"+
                           "5. Salir");
    }
    
    private static void desactivarOpciones(String nombreUsuario, int caso) {
        switch(caso) {
            case 0:
                ManejoArchivos.desactivar(nombreUsuario, "solicitudes.txt", 0);
                break;
            case 1:
                ManejoArchivos.desactivar(nombreUsuario, "solicitudes.txt", 1);
                break;
            case 2:
                ManejoArchivos.desactivar(nombreUsuario, "cuentas.txt", 2);
                break;
        }
    }
    
    private static void solicitudesCuenta() {
        System.out.println("------------SOLICITUDES DE CREACIÓN DE CUENTAS-----------");
    }
    
    private static void solicitudesPendientes() {
        System.out.println("------------SOLICITUDES DE CREACIÓN DE TARJETAS-----------");
    }
    
    private static String tipoPlan(String numero) {
        switch(numero) {
            case "1":
                return "Plan Joven";                
            case "2":
                return "Plan Ahorro Casa";
            case "3":
                return "Plan Estándar";
        }
        return null;
    }
}
