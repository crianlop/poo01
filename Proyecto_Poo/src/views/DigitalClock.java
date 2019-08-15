package views;

import javafx.geometry.VPos;
import javafx.scene.Parent;
import javafx.scene.Group;
import javafx.scene.effect.Lighting;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author estudiante
 */
public class DigitalClock extends Parent{
    
    // Atributos
    private final int boxHeight = 10;
    private final int boxWidth = boxHeight * 5 / 8;
    private final int scale = 5;
    
    final private Font FONT = new Font(10 * scale);
    
    final private HBox hbox = new HBox();
    final private Text[] digitos = new Text[2];
    final private Group[] digitoGrupos = new Group[2];
    
    //Constructor
    public DigitalClock(){
        configurarDigitos();
        configurarHBox();
        getChildren().add(hbox);
    }
    
    private void configurarHBox(){
        hbox.getChildren().addAll(digitoGrupos);
        hbox.setSpacing(2);
    }
    
    private void configurarDigitos(){
        for(int i = 0; i < digitos.length; i++){
            digitos[i] = new Text("0");
            digitos[i].setFont(FONT);
            digitos[i].setTextOrigin(VPos.TOP);
            digitos[i].setLayoutY(-10);
            Rectangle rectangulo = null;
            if(i == 0){
                rectangulo = crearBackground(Color.ANTIQUEWHITE, Color.BLACK);
                digitos[i].setFill(Color.BLACK);
            }
            if(i == 1){
                rectangulo = crearBackground(Color.RED, Color.BLACK);
                digitos[i].setFill(Color.WHITE);
            }
            digitoGrupos[i] = new Group(rectangulo, digitos[i]);
        }
    }
    
    private Rectangle crearBackground(Color fill, Color stroke){
        Rectangle bg = new Rectangle(boxWidth * scale, boxHeight * scale, fill);
        bg.setStroke(stroke);
        bg.setStrokeWidth(3);
        bg.setEffect(new Lighting());
        return bg;
    }
    
    public void refrescarDigitos(String numero){
        for(int i = 0; i < digitos.length; i++){
            digitos[i].setText(numero.substring(i, i + 1));
        }
    }
}