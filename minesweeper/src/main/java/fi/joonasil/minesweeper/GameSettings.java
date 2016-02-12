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
     * Asettaa vaikeusasteen parametrina annetun luvun perusteella.
     * (vaikeusaste mahdollisesti muuttuu integeristä enum tyypiksi)
     * @param value uusi vaikeusaste
     */
    public void setDifficulty(int value) {
        switch(value) {
            case 0:
                this.mines = 10;
                this.x = 9;
                this.y = 9;
                this.difficulty = value;
                break;
            case 1:
                this.mines = 40;
                this.x = 16;
                this.y = 16;
                this.difficulty = value;
                break;
            case 2:
                this.mines = 99;
                this.x = 30;
                this.y = 16;
                this.difficulty = value;
                break;
            default:
                this.mines = 10;
                this.x = 9;
                this.y = 9;
                this.difficulty = 0;
                break;
        }
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
    
    
}
