package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.Main;
import fi.joonasil.minesweeper.other.Minesweeper;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

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

        MenuBar menuBar = new MenuBar();
        
        Menu gameMenu = new Menu("Game");
        
        MenuItem newGame = new MenuItem("New Game");
        MenuItem quitGame = new MenuItem("Quit Game");
        
        newGame.setOnAction(e -> MenuHandler.handeNewGame());
        quitGame.setOnAction(e -> Main.quitGame());
        
        gameMenu.getItems().addAll(newGame, quitGame);
       
        Menu diffMenu = new Menu("Difficulty");
        
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        
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
        
        easy.setOnAction(e -> Minesweeper.getSettings().setEasy());
        medium.setOnAction(e -> Minesweeper.getSettings().setMedium());
        hard.setOnAction(e -> Minesweeper.getSettings().setHard());
        
        diffMenu.getItems().addAll(easy,medium,hard);
        
        Menu hsMenu = new Menu("High Scores");
        
        MenuItem easyScore = new MenuItem("Easy");
        MenuItem mediumScore = new MenuItem("Medium");
        MenuItem hardScore = new MenuItem("Hard");
        
        easyScore.setOnAction(e -> MenuHandler.handleHighScore(0));
        mediumScore.setOnAction(e -> MenuHandler.handleHighScore(1));
        hardScore.setOnAction(e -> MenuHandler.handleHighScore(2));
        
        hsMenu.getItems().addAll(easyScore, mediumScore, hardScore);
        
        menuBar.getMenus().addAll(gameMenu, diffMenu, hsMenu);
        return menuBar;
    }
}
