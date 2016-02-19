package fi.joonasil.minesweeper.other;

import java.nio.file.*;
import fi.joonasil.minesweeper.logic.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.ArrayList;

public class Saves {
    static Charset utf8 = StandardCharsets.UTF_8;
    static ArrayList<String> save = new ArrayList<>();
  
    /**
     * Metodi pelin tallentamiselle. Ei valmis!
     * 
     * @param data Tallennettava data.
     */
    public static void saveGame(String data) {
        Path filePath = Paths.get("saves/save1.txt");
        Saves.save.addAll(Arrays.asList(data.split("\\n")));   
        if (Files.exists(filePath)) {
            try {
                Files.delete(filePath);
            } catch (IOException e) { System.out.println("Implement error message!"); }
        }
        try {
            System.out.println("File saved to: " + Files.write(filePath, Saves.save, Saves.utf8).toString());
        } catch (IOException e) {
            System.out.println("Can't save");
        }  
    }
}

