package fi.joonasil.minesweeper;

public class GameSettings {
    private int mines;
    private int x;
    private int y;
    private int difficulty;
    
    public GameSettings(int mines, int x, int y, int diff){
        this.mines = mines;
        this.x = x;
        this.y = y;
        this.difficulty = diff;
    }
    
    public GameSettings(){
        this.mines = 10;
        this.x = 9;
        this.y = 9;
        this.difficulty = 0;
    }
    
    public int getDifficulty(){
        return this.difficulty;
    }

    public void setDifficulty(int value){
        switch(value){
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
