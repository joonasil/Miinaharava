package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.Minesweeper;
import fi.joonasil.minesweeper.gui.GameScreen;
import fi.joonasil.minesweeper.logic.Minefield;
import fi.joonasil.minesweeper.other.MineFactory;
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
        int x = MineFactory.getSettings().getX();
        int y = MineFactory.getSettings().getY();
        int mines = MineFactory.getSettings().getMines();
        MineFactory.getTimer().reset();
        Minefield newField = new Minefield(x, y, mines);
        GameScreen newScreen =  new GameScreen(x, y);
        MineFactory.setBoard(newField);
        MineFactory.setScreen(newScreen);
        Minesweeper.setScene(MineFactory.getScreen().getScene());
        MineFactory.getScreen().setMinesLeft(Integer.toString(MineFactory.getBoard().getMinesLeft()));
        
    }

}
