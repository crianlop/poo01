package views;

import classes.Jugador;

import java.io.FileReader;
import java.io.BufferedReader;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.text.Font;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Estudiante
 */
public class Menu extends Application {
    
    // Atributos para mostrar el historial si este existiera
    final private String file = "src/files/historial.txt";
    private boolean history = false;
    
    @Override
    public void start(Stage stage) {        
        // Verifica historial
        verificarHistory();

        // Creacion de objeto root
        AnchorPane root = new AnchorPane();

        // Uso de un Hbox para los botones
        HBox botones = new HBox();
        botones.setSpacing(55);

        // Creacion del boton menú
        Button btnuevojuego = new Button("Nuevo Juego");
        btnuevojuego.setOnAction(e -> {
            System.out.println("Bienvenido jugador..");
            NuevoJuego nuevo_juego = new NuevoJuego();
            nuevo_juego.start(stage);
        });

        //Creacion del boton de Historial de Jugadores
        Button bthistorial = new Button("Historial de Jugadores");
        bthistorial.setOnAction(e -> {
            if(this.history) {
                try {
                    tablaJugador(stage);
                }catch(Exception exception){
                    System.out.println("El error es: " + exception);
                    System.exit(1);
                }
            } else
                ventanaEmergente(stage);
        });        

        // Creacion de boton salir 
        Button btsalir = new Button("Salir");
        btsalir.setOnAction(e -> salida(stage));

        //Creacion del boton guia
        Button btguia = new Button("Instrucciones");
        btguia.setOnAction(e -> {
            // Hacer instrucciones
        });

        // Imagen de fondo de pantalla
        Image image = new Image(Menu.class.getResource("/res/menu.jpg").toExternalForm());
        ImageView view = new ImageView();
        view.setImage(image);

        // Guardado de los botones en el HBox
        botones.getChildren().addAll(bthistorial,btnuevojuego,btguia,btsalir);
        botones.setPadding(new Insets(20));

        // Ubicacion de los botones
        AnchorPane.setBottomAnchor(botones, 10.0);  

        // Agregado de las variables al layout principal
        root.getChildren().addAll(view, botones);


        // Setear valores para imprimirlos
        Scene scene = new Scene(root, 540, 275);
        stage.setTitle("Atrapando Insectos");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();        
    }
   
    @Override
    public void stop(){      
        System.out.println("Vuelva pronto..");
    }
   
    // Levanta toda la aplicacion
    public static void main (String[] args) {
        launch(args);
    }
    
    // Metodo para verificar que el usuario quiera salir
    public void salida(Stage stage){
        AnchorPane anchor = new AnchorPane();
        Label mensaje = new Label("¿Desea salir del juego?");
        mensaje.setFont(new Font("Arial",20));        
        
        HBox botones = new HBox();
        Button si = new Button("Si");
        Button no = new Button("No");
        botones.setSpacing(60);
        
        botones.getChildren().addAll(si,no);
        
        AnchorPane.setBottomAnchor(botones, 20.0);
        AnchorPane.setLeftAnchor(botones, 70.0);
        AnchorPane.setTopAnchor(mensaje, 25.0);
        AnchorPane.setLeftAnchor(mensaje, 25.0);
        
        si.setOnAction(e -> stage.close());
        
        no.setOnAction(e -> start(stage));
        
        anchor.getChildren().addAll(mensaje, botones);
        
        Scene scene = new Scene(anchor,260,159);
        
        stage.setTitle("Aviso!");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
        
    
    // Verificar si hay data en el txt
    public void verificarHistory() {
        try{
            System.out.println("Historial cargado correctamente");
            String cadena;
            FileReader archivo = new FileReader(file);
            BufferedReader buffer = new BufferedReader(archivo);
            while((cadena = buffer.readLine()) != null){
                String[] array = cadena.split(",");
                if (array.length > 1) 
                    this.history = true;                
            }
            buffer.close();
        } catch(Exception e) {
            System.out.println("Error al trata de verificar el historial" + e);
        }        
    }
    
    // Ventana emergente
    public void ventanaEmergente(Stage stage){
        System.out.println("Entre");
        AnchorPane anchorpane =  new AnchorPane();
        
        // Imagen de fondo
        Image image = new Image(Menu.class.getResource("/res/fondoHistorial.jpg").toExternalForm());
        ImageView fondo = new ImageView(image);
        
        // Mensaje emergente
        Label lbmensaje = new Label("No se puede cargar los archivos"
                    + " porque no existen ganadores aun...");
        lbmensaje.setFont(new Font("Times New Roman",20));
        lbmensaje.setTextFill(Color.YELLOW);
        
        AnchorPane.setTopAnchor(lbmensaje, 15.0);
        AnchorPane.setLeftAnchor(lbmensaje, 10.0);
        AnchorPane.setRightAnchor(lbmensaje, 50.0);
        // Boton de salir
        Button btsalir = new Button("Regresar");
        AnchorPane.setBottomAnchor(btsalir, 25.0);
        AnchorPane.setLeftAnchor(btsalir, 160.0);
        AnchorPane.setRightAnchor(btsalir, 160.0);
        btsalir.setOnAction(e -> {            
            stage.close();
            start(stage);
        });
        anchorpane.getChildren().addAll(fondo, lbmensaje, btsalir);
        // Setear ambiente para correr
        Scene scene = new Scene(anchorpane,800 ,400);
        
        stage.setTitle("Ventana Emergente");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.show();
    }
    
    // Metodo que muestra la tabla de jugadores que han ganado
    public void tablaJugador(Stage stage){
        /*
         nombre;
    private String fecha;
    private String puntos;
    private String nivel;
        */
        TableView<Jugador> tabla = new TableView<>();
        Label label = new Label("JUGADORES GANADORES");
        label.setFont(new Font("Arial",20));
        
        tabla.setEditable(false);
        
        // Setear valores para presentar informacion en las columnas
        TableColumn<Jugador, String> usuario = new TableColumn<>("Usuario");
        TableColumn<Jugador, String> tiempo = new TableColumn<>("Fecha");
        TableColumn<Jugador, String> monedas = new TableColumn<>("Puntos");
        TableColumn<Jugador, String> fecha = new TableColumn<>("Nivel");        
        
        tabla.getColumns().addAll(usuario,tiempo,monedas,fecha);
        
        usuario.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tiempo.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        monedas.setCellValueFactory(new PropertyValueFactory<>("puntos"));
        fecha.setCellValueFactory(new PropertyValueFactory<>("nivel"));        
        
        // Mostrar data en el tableView
        try{
            System.out.println("Mostrando los jugadores ganadores");
            String cadena;
            FileReader archivo = new FileReader(file);
            BufferedReader buffer = new BufferedReader(archivo);
            while((cadena = buffer.readLine()) != null){
                String[] array = cadena.split(",");
                Jugador jugador = new Jugador(array[0],array[1],
                        array[2],array[3]);
                tabla.getItems().addAll(jugador);
            }
            buffer.close();
        } catch(Exception e) {
            System.out.println("Error al tratar de cargar los ganadores" + e);
        }
        
        // Resto de logica del tableView        
        Button regresar = new Button("Regresar");        
        regresar.setOnAction(e -> start(stage));
        
        AnchorPane anchor = new AnchorPane();
        
        AnchorPane.setTopAnchor(label, 20.0);
        AnchorPane.setLeftAnchor(label, 120.0);
        
        AnchorPane.setTopAnchor(tabla, 60.0);
        AnchorPane.setLeftAnchor(tabla, 55.0);
        
        AnchorPane.setBottomAnchor(regresar, 10.0);
        AnchorPane.setLeftAnchor(regresar, 225.0);
        
        anchor.getChildren().addAll(label,tabla,regresar);
        
        anchor.setStyle("-fx-background-color: AQUAMARINE;");
        Scene scene = new Scene(anchor,500,500);
        stage.setTitle("Tabla de jugadores, by: msdrc2402");

        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();        
    }
}
