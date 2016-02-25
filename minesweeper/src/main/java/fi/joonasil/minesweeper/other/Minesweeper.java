package fi.joonasil.minesweeper.other;

import fi.joonasil.minesweeper.GameSettings;
import fi.joonasil.minesweeper.gui.GameScreen;
import fi.joonasil.minesweeper.gui.timer.Timer;
import fi.joonasil.minesweeper.logic.Minefield;

/**
 * Luokka kaikkien komponenttien yhdistämiselle. Nimi voi muuttua.
 * 
 * @author Joonas Ilvonen
 */
public class Minesweeper {
    
    private static GameScreen screen;
    private static Minefield board;
    private static GameSettings settings;   
    private static Timer timer;
    
    public static void setScreen(GameScreen screen) {
        Minesweeper.screen = screen;
    }
    
    public static void setBoard(Minefield board) {
        Minesweeper.board = board; 
    }

    public static void setSettings(GameSettings settings) {
        Minesweeper.settings = settings;
    }
    
    /**
     * Palauttaa pelin käyttöliittymän ulkoasun, luo käyttöliittymän jos sitä ei ole vielä luotu.
     * 
     * @return Pelin käyttöliittymän olio.
     */
    public static GameScreen getScreen() {
        int x = getSettings().getX();
        int y = getSettings().getY();
        if (screen == null) {
            screen = new GameScreen(x, y);
        }
        return screen;
    }
   
    /**
     * Palauttaa pelin logiikan olion, jos peliä ei ole vielä luotu luo uuden pelin asetusten mukaan..
     * 
     * @return Pelin logiikan olio.
     */
    public static Minefield getBoard() {
        int x = getSettings().getX();
        int y = getSettings().getY();
        int mines = getSettings().getMines();
        if (board == null) {
            board = new Minefield(x, y, mines);
        }
        return board;
    }
    
    /**
     * Palauttaa pelin asetukset, luo asetukset jos niitä ei vielä ole luotu.
     * 
     * @return Pelin asetukset.
     */
    public static GameSettings getSettings() {
        if (settings == null) {
            settings = new GameSettings();
        }
        return settings;
    }
    
    /**
     * Palauttaa pelin kellon olion, luo pelin kellon jos sitä ei vieä ole luotu.
     * 
     * @return Pelin kello- olio.
     */
    public static Timer getTimer() {
        if (timer == null) {
            timer = new Timer();
        }
        return timer;
    }
}
