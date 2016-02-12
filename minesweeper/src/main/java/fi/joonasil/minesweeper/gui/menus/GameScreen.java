
package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.Minesweeper;
import fi.joonasil.minesweeper.gui.square.SquareGUI;
import fi.joonasil.minesweeper.logic.Minefield;
import fi.joonasil.minesweeper.other.ImageLoader;
import fi.joonasil.minesweeper.other.MineFactory;
import fi.joonasil.minesweeper.other.MouseInput;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class GameScreen {
    
    Scene scene;
    ArrayList<SquareGUI> squares = new ArrayList<>();
    ArrayList<Image> imgs;
    MouseInput handler = new MouseInput();
    
    public GameScreen(int x, int y){
        ImageLoader load = new ImageLoader();
        imgs = load.getImages();
        VBox layout = new VBox();
        layout.getChildren().addAll(constructMenuBar(),constructInfoBar(),constructBoard(x,y));
        setActions();
        scene = new Scene(layout, (x+1)*32, (y+2.3)*32);
    }
    
    
    public MenuBar constructMenuBar(){
        //Main menu bar
        MenuBar menuBar = new MenuBar();
        
        //Game menu
        Menu gameMenu = new Menu("Game");
        
        //Game menu items
        MenuItem newGame = new MenuItem("New Game");
        MenuItem loadGame = new MenuItem("Load Game");
        MenuItem saveGame = new MenuItem("Save Game");
        MenuItem quitGame = new MenuItem("Quit Game");
        
        //Game menu actions
        newGame.setOnAction(e -> {
            int x = MineFactory.getSettings().getX();
            int y = MineFactory.getSettings().getY();
            int mines = MineFactory.getSettings().getMines();
            Minefield newField = new Minefield(x,y,mines);
            GameScreen newScreen =  new GameScreen(x,y);
            MineFactory.setNewGame(newField, newScreen);
            Minesweeper.setScene(newScreen.getScene());
        });
        loadGame.setOnAction(e -> System.out.println("To be implemented"));
        saveGame.setOnAction(e -> System.out.println("To be implemented"));
        quitGame.setOnAction(e -> Minesweeper.quitGame());
        
        gameMenu.getItems().addAll(newGame, loadGame, saveGame, quitGame);
       
         //Difficulty menu
        Menu diffMenu = new Menu("Difficulty");
        
        //Game menu items
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        
        //Toggle group for difficulty
        ToggleGroup dif = new ToggleGroup();
        easy.setToggleGroup(dif);
        medium.setToggleGroup(dif);
        hard.setToggleGroup(dif);
        switch(MineFactory.getSettings().getDifficulty()){
            case 0:
                dif.selectToggle(easy);
                break;
            case 1:
                dif.selectToggle(medium);
                break;
            case 2:
                dif.selectToggle(hard);
                break;
            default:
                dif.selectToggle(easy);
        }
        
        //Difficulty menu actions
        easy.setOnAction(e -> MineFactory.getSettings().setDifficulty(0));
        medium.setOnAction(e -> MineFactory.getSettings().setDifficulty(1));
        hard.setOnAction(e -> MineFactory.getSettings().setDifficulty(2));
        
        diffMenu.getItems().addAll(easy,medium,hard);
        
        menuBar.getMenus().addAll(gameMenu, diffMenu);
        return menuBar;
    }
    
    public HBox constructInfoBar(){
        //HBox For Mines Left and Timer
        HBox info = new HBox();
        Label minesLeft = new Label("Mines Left: x");
        Label time = new Label("  Time: 0:00:00");
        info.getChildren().addAll(minesLeft,time);
        info.setAlignment(Pos.CENTER);
        return info;
    }
    
    public GridPane constructBoard(int x, int y){
        GridPane layout = new GridPane();
        layout.setMaxSize(x*32, y*32);
        layout.setMinSize(x*32, y*32);
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                squares.add(new SquareGUI(imgs,i*x+j));
                GridPane.setConstraints(squares.get(i*x+j).getCurrent(), j, i);
                layout.getChildren().add(squares.get(i*x+j).getCurrent());
            }
        }
        layout.setPadding(new Insets(5,0,10,15));
        return layout;
    }
    
    public Scene getScene(){
        return this.scene;
    }
    
    public void setImage(int index, int imgIndex){
        this.squares.get(index).setCurrent(imgIndex);
    }
    
    public void setActions(){
        for(SquareGUI sq : squares){
            sq.setOnMousePressed(e -> handler.handle(e));
            sq.setOnMouseReleased(e -> handler.handle(e));
            sq.setOnMouseDragEntered(e -> handler.handle(e));
            sq.setOnMouseDragExited(e -> handler.handle(e));
        }
    }
}
