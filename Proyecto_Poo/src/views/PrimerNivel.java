package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.AnchorPane;

/**
 *
 * @author estudiante
 */
public class PrimerNivel extends Application {
    
    private AnchorPane root;
    
    private String nombreUsuario;
    
    public PrimerNivel(String usuario) {
        root = new AnchorPane();
        
        this.nombreUsuario = usuario;
    }
    
    @Override
    public void start(Stage stage) {
        
        Scene scene = new Scene(root, 500.0, 700.0);
        stage.setScene(scene);
        stage.setTitle("Atrapando Insectos");
        stage.setResizable(false);
        stage.show();
    }
}
