package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.Main;
import fi.joonasil.minesweeper.gui.menus.MenuHandler;
import fi.joonasil.minesweeper.gui.timer.Timer;
import fi.joonasil.minesweeper.other.Minesweeper;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

/**
 *
 * @author Joonas
 */
public class MenuBarSetUp {
    
    /**
     * Luo ikkunan yläreunassa olevan valikon.
     * 
     * @return Luotu valikko.
     */
    public static MenuBar setMenus() {
         //Main menu bar
        MenuBar menuBar = new MenuBar();
        
        //Game menu
        Menu gameMenu = new Menu("Game");
        
        //Game menu items
        MenuItem newGame = new MenuItem("New Game");
        MenuItem quitGame = new MenuItem("Quit Game");
        
        //Game menu actions
        newGame.setOnAction(e -> MenuHandler.handeNewGame());
        quitGame.setOnAction(e -> Main.quitGame());
        
        gameMenu.getItems().addAll(newGame, quitGame);
       
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
        switch(Minesweeper.getSettings().getDifficulty()){
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
        easy.setOnAction(e -> Minesweeper.getSettings().setEasy());
        medium.setOnAction(e -> Minesweeper.getSettings().setMedium());
        hard.setOnAction(e -> Minesweeper.getSettings().setHard());
        
        diffMenu.getItems().addAll(easy,medium,hard);
        
        //High Score menu
        Menu hsMenu = new Menu("High Scores");
        
        //High Score Menu items
        MenuItem easyScore = new MenuItem("Easy");
        MenuItem mediumScore = new MenuItem("Medium");
        MenuItem hardScore = new MenuItem("Hard");
        
        //High Score Menu actions
        easyScore.setOnAction(e -> MenuHandler.handleHighScore(0));
        mediumScore.setOnAction(e -> MenuHandler.handleHighScore(1));
        hardScore.setOnAction(e -> MenuHandler.handleHighScore(2));
        
        hsMenu.getItems().addAll(easyScore, mediumScore, hardScore);
        
        menuBar.getMenus().addAll(gameMenu, diffMenu, hsMenu);
        return menuBar;
    }
}
