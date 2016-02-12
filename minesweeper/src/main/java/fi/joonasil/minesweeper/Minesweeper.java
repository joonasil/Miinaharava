package fi.joonasil.minesweeper;
import fi.joonasil.minesweeper.gui.menus.GameScreen;
import fi.joonasil.minesweeper.other.MineFactory;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Ohjelman Main luokka.
 * @author Joonas Ilvonen
 */
public class Minesweeper extends Application {
    
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
        MineFactory.getSettings();
        MineFactory.getBoard();
        window.setScene(MineFactory.getScreen().getScene());
        window.show();
    }
    
    /**
     * Sulkee ohjelman.
     */
    public static void quitGame() {
        window.close();
    }
    
    /**
     * Asettaa ohjelman näkymäksi uuden Scene olion
     * @param scene Uusi näkymä
     */
    public static void setScene(Scene scene) {
        window.setScene(scene);
    }
}
