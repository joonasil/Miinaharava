package fi.joonasil.minesweeper.highscores;

/**
 *
 * @author Joonas
 */
public class Score {
    private String name;
    private String time;
    
    public Score(String name, String time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
    
    public String getHighScore() {
        String out = name + "|" + time;
        return out;
    }
}
