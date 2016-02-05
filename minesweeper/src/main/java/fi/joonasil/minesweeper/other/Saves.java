package fi.joonasil.minesweeper.other;

import java.nio.file.*;
import fi.joonasil.minesweeper.logic.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;


public class Saves {
    Charset utf8 = StandardCharsets.UTF_8;
    ArrayList<String> save = new ArrayList<>();
    
    public Saves(){
        
    }
    
    public void saveGame(String data){
        Scanner scan = new Scanner(data);
        while(scan.hasNextLine()){
            this.save.add(scan.nextLine());
            System.out.println("Added a line!!!");
        }
        try {

        Files.write(Paths.get("save1.txt"), this.save, this.utf8);

        } catch (IOException e) {
        e.printStackTrace();
        }  
    }
}

