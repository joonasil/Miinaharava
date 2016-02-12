package fi.joonasil.minesweeper;
import fi.joonasil.minesweeper.gui.menus.GameScreen;
import fi.joonasil.minesweeper.other.MineFactory;
import javafx.application.*;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class Minesweeper extends Application{
    
    private static Stage window;
    
    public static void main(String[]args){
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        primaryStage.setTitle("Minesweeper");
        MineFactory.getSettings();
        MineFactory.getBoard();
        window.setScene(MineFactory.getScreen().getScene());
        window.show();
    }
    
    public static void quitGame(){
        window.close();
    }
    
    public static void setScene(Scene scene){
        window.setScene(scene);
    }
}
