package fi.joonasil.minesweeper;
import fi.joonasil.minesweeper.other.Minesweeper;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;

/**
 * Ohjelman Main luokka.
 * @author Joonas Ilvonen
 */
public class Main extends Application {
    
    private static Stage window;
    
    /**
     * Käynnistää javafx ikkunan.
     * @param args Komentorivillä annetut argumentit käynnistettäessä java ohjelma.
     */
    public static void main(String[]args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        primaryStage.setTitle("Minesweeper");
        Minesweeper.getSettings();
        Minesweeper.getBoard();
        window.setScene(Minesweeper.getScreen().getScene());
        window.setResizable(false);
        window.show();
    }
    
    /**
     * Sulkee ohjelman.
     */
    public static void quitGame() {
        window.close();
    }
    
    /**
     * Asettaa ohjelman näkymäksi uuden Scene olion.
     * @param scene Uusi näkymä
     */
    public static void setScene(Scene scene) {
        window.setScene(scene);
    }
}
