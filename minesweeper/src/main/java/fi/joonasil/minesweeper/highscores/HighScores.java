package fi.joonasil.minesweeper.highscores;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Joonas
 */
public class HighScores {
    ArrayList<Score> easy;
    ArrayList<Score> medium;
    ArrayList<Score> hard;
    
    public HighScores() {
        easy = new ArrayList();
        medium = new ArrayList();
        hard = new ArrayList();
        
    }
    
    public void addEasy(String name, String time) {
        easy.add(new Score(name, time));
    }
    
    public void saveEasy() {
        for(Score save : easy) {
            try (PrintWriter out = new PrintWriter("highscores/easy.txt")) {
                out.println( save.toString() );
            } catch (FileNotFoundException e) {
                System.out.println("You Failed!");
            }
        }
    }
}
