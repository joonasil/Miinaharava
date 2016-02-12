package fi.joonasil.minesweeper.other;

import fi.joonasil.minesweeper.GameSettings;
import fi.joonasil.minesweeper.gui.menus.GameScreen;
import fi.joonasil.minesweeper.logic.Minefield;


public class MineFactory {
    
    private static GameScreen screen;
    private static Minefield board;
    private static GameSettings settings;
    
    
    public static GameScreen getScreen(){
        if(screen == null)
            screen = new GameScreen(9,9);
        return screen;
    }


    public static void setNewGame(Minefield board, GameScreen screen) {
        MineFactory.board = board;
        MineFactory.screen = screen;
    }

    public static void setSettings(GameSettings settings) {
        MineFactory.settings = settings;
    }
    
    public static Minefield getBoard(){
        if(board == null)
            board = new Minefield(9,9,10);
        return board;
    }
    
    public static GameSettings getSettings(){
        if(settings == null)
            settings = new GameSettings();
        return settings;
    }
}
