package views;

import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/**
 *
 * @author estudiante
 */
public class NuevoJuego {
    
    private AnchorPane root;
    private VBox vbox;
    
    private TextField usuario;
    private Label lbtitulo;
    private Button comenzar;
    private final Label lberror = new Label("Ingrese un usuario para comenzar");
    
    public NuevoJuego() {
        root = new AnchorPane();
        vbox = new VBox();
        
        usuario = new TextField();
        lbtitulo = new Label("Ingrese su usuario para continuar:");
        comenzar = new Button("Iniciar Juego");
    }
        
    public void start(Stage primaryStage) {
        Stage stage = new Stage();
        
        comenzar.setOnAction(e -> {
            if(!usuario.getText().isEmpty()) {
                PrimerNivel primerNivel = new PrimerNivel(usuario.getText());
                primerNivel.start(primaryStage);
                stage.close();
            } else
                lberror.setVisible(true);
        });
        
        vbox.getChildren().addAll(lbtitulo, usuario, comenzar, lberror);
        lberror.setVisible(false);

        root.getChildren().add(vbox);
        
        Scene scene = new Scene(root, 350.0, 200.0);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Nuevo Juego");
        stage.show();        
    }
}
