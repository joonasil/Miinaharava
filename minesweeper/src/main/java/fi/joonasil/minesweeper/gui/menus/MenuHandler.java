package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.Main;
import fi.joonasil.minesweeper.gui.GameScreen;
import fi.joonasil.minesweeper.logic.Minefield;
import fi.joonasil.minesweeper.other.Minesweeper;

/**
 * Luokka menujen tapahtumien hoitamiselle.
 * 
 * @author Joonas
 */
public class MenuHandler {

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
    
    /**
     * Metodi avaa huipputulos ikkunan.
     * 
     * @param difficulty Vaikeusaste, jonka huipputulokset avataan.
     */
    public static void handleHighScore(int difficulty) {
        Minesweeper.getHighScore().load(difficulty);
        Minesweeper.getHighScore().draw();
    }

}
