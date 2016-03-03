package fi.joonasil.minesweeper.highscores;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *Luokka pelin huipputuloksille.
 * 
 * @author Joonas Ilvonen
 */
public class HighScores {
    ArrayList<Score> easy;
    ArrayList<Score> medium;
    ArrayList<Score> hard;
    
    
    /**
     * Konstruktori luo listat eri vaikeusasteiden tuloksille.
     */
    public HighScores() {
        easy = new ArrayList();
        medium = new ArrayList();
        hard = new ArrayList();
        
    }
    
    /**
     * Metodi lisää uuden huipputuloksen.
     * 
     * @param name Pelaajan nimi.
     * @param time Pelin aika.
     * @param difficulty Pelin vaikeusaste.
     */
    public void add(String name, String time, int difficulty) {
        switch (difficulty) {
            case 0:
                easy = load(0);
                easy.add(new Score(name, time));
                Collections.sort(easy);
                break;
            case 1:
                medium = load(1);
                medium.add(new Score(name, time));
                Collections.sort(medium);
                break;
            case 2:
                hard = load(2);
                hard.add(new Score(name, time));
                Collections.sort(hard);
                break;
        }
        save(difficulty);
    }
    
    private void save(int difficulty) {
        Path path = Paths.get(System.getProperty("user.dir") + "/highscores/easy.txt");
        ArrayList<Score> tosave = easy;
        if (difficulty == 1) {
            path = Paths.get(System.getProperty("user.dir") + "/highscores/medium.txt");
            tosave = medium;
        } else if (difficulty == 2) {
            path = Paths.get(System.getProperty("user.dir") + "/highscores/hard.txt");
            tosave = hard;
        }
        try (BufferedWriter writer = Files.newBufferedWriter(path,
            StandardCharsets.UTF_8, StandardOpenOption.WRITE)) {
            for (Score save : tosave) {
                writer.write(save.toString() + "\n");
            }
        } catch (Exception ex) {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Lataa huippitulokset tiedostosta.
     * 
     * @param difficulty Vaikeuaste, jnoka tulokset ladataan.
     * @return Lista Tuloksista.
     */
    public ArrayList<Score> load(int difficulty) {
        Path dir = Paths.get(System.getProperty("user.dir") + "/highscores");
        if (!Files.exists(dir)) {
            try {
                Files.createDirectory(dir);
            } catch (IOException ex) {
                Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Path path = Paths.get(System.getProperty("user.dir") + "/highscores/easy.txt");
        if (difficulty == 1) {
            path = Paths.get(System.getProperty("user.dir") + "/highscores/medium.txt");
        } else if (difficulty == 2) {
            path = Paths.get(System.getProperty("user.dir") + "/highscores/hard.txt");
        }
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException ex) {
                Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        List<String> lines = new ArrayList();
        String time, name;

        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(HighScores.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<Score> scores = new ArrayList();
        int x = 1;
        for (String s : lines) {
            if (s.length() < 8) {
                continue;
            }
            time = s.substring((s.length() - 8));
            name = s.substring(0, (s.length() - 8));
            Score score = new Score(name, time);
            score.setPosition(x);
            scores.add(score);
            x++;
        }
        return scores;
    }
}
