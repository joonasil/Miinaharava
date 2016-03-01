package fi.joonasil.minesweeper.gui.menus;
import javafx.event.ActionEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 * Luokka luo ponnahdusikkunan, jolla voi vahvistaa käyttäjän komentoja.
 * 
 * @author Joonas Ilvonen
 */
public class PromtWindow {
    private static final TextField input = new TextField();
    private static String name;
    /**
     * Metodi luo ponnahdusikkunan ja palauttaa käyttäjän valitseman nimimerkin.
     * 
     * @param title Ponnahdusikkunan otsikko
     * @param message Ponnahdusikkunan viesti
     * 
     * @return käyttäjän valinta 
     */
    public static String gameWon(String title, String message) {
        
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setOnCloseRequest(e -> e.consume());
        window.setTitle(title);
        window.setMinWidth(270);
        Label label = new Label();
        label.setText(message);
        input.setPromptText("Name");
        Button confirm = new Button("Confirm");

        confirm.setOnAction((ActionEvent e) -> {
            name = input.getText();
            if(name.length() > 0) {
                window.close();
            }     
        });

        VBox layout = new VBox(10);

        layout.getChildren().addAll(label, input, confirm);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        return name;
    }
}
