package fi.joonasil.minesweeper;

/**
 * Luokka pelin asetuksille. Asetuksia voi asettaa ja hakea.
 *
 * @author Joonas Ilvonen
 */
public class GameSettings {
    private int mines;
    private int x;
    private int y;
    private int difficulty;
    
    /**
     * Konstruktori luo pelin asetukset oletuksena helpolla vaikeusasteella.
     */
    public GameSettings() {
        this.mines = 10;
        this.x = 9;
        this.y = 9;
        this.difficulty = 0;
    }
    
    public int getDifficulty() {
        return this.difficulty;
    }
    
    /**
     * Asettaa vaikeusasteen helpoksi.
     */
    public void setEasy() {
        this.mines = 10;
        this.x = 9;
        this.y = 9;
        this.difficulty = 0;
    }
    
    /**
    * Asettaa vaikeusasteen keskivaikeaksi.
    */
    public void setMedium() {
        this.mines = 40;
        this.x = 16;
        this.y = 16;  
        this.difficulty = 1;
    }
    
    /**
    * Asettaa vaikeusasteen vaikeaksi.
    */
    public void setHard() {
        this.mines = 99;
        this.x = 30;
        this.y = 16;
        this.difficulty = 2;
    }
    
    public int getMines() {
        return mines;
    }

    public void setMines(int mines) {
        this.mines = mines;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "Size: " + x + " x " + y + " Mines: " + mines + " Difficulty: " + difficulty;
    }
}
