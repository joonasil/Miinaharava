package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.Main;
import fi.joonasil.minesweeper.gui.GameScreen;
import fi.joonasil.minesweeper.logic.Minefield;
import fi.joonasil.minesweeper.other.Minesweeper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Luokka menujen tapahtumien hoitamiselle.
 * 
 * @author Joonas
 */
public class MenuHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Metodi hoitaa uusi peli- painikkeen toiminnan.
     */
    public static void handeNewGame() {
        int x = Minesweeper.getSettings().getX();
        int y = Minesweeper.getSettings().getY();
        int mines = Minesweeper.getSettings().getMines();
        Minesweeper.getTimer().reset();
        Minefield newField = new Minefield(x, y, mines);
        GameScreen newScreen =  new GameScreen(x, y);
        Minesweeper.setBoard(newField);
        Minesweeper.setScreen(newScreen);
        Main.setScene(Minesweeper.getScreen().getScene());
        Minesweeper.getScreen().setMinesLeft(Integer.toString(Minesweeper.getBoard().getMinesLeft()));
        
    }
    
    
    public static void handleHighScore(int difficulty) {
        Minesweeper.getHighScore().load(difficulty);
        Minesweeper.getHighScore().draw();
    }

}
