package fi.joonasil.minesweeper.gui.menus;
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
    private static boolean answer;
    
    /**
     * Metodi luo ponnahdusikkunan ja palauttaa käyttäjän valitseman vastauksen.
     * 
     * @param title Ponnahdusikkunan otsikko
     * @param message Ponnahdusikkunan viesti
     * 
     * @return käyttäjän valinta totuusarvona
     */
    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label();
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);

        layout.getChildren().addAll(label, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
