
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import fi.joonasil.minesweeper.logic.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class TestClass {
    public static void main(String[] args){     
        System.out.println("Test starts here!");
         Minefield game = new Minefield(9,9,10);
        Scanner input = new Scanner(System.in);
        int x = 1;
        int y = 1;
        int mines = 1;
        boolean gameOn = true;
        String asd = "1\n2\n3\n4";
        String test;
        System.out.println(asd);
        Scanner scan = new Scanner(asd);
        ArrayList<String> save = new ArrayList<>();
         while(scan.hasNextLine()){
            save.add(scan.nextLine());
        }
         System.out.println(save.size());
        while(gameOn){

            System.out.println(game.toString());
            System.out.println("Left or right click? (L/R)");
            String in = input.next();
            if(in.equalsIgnoreCase("l")){
                gameOn = game.openSquares(input.nextInt());
                if(gameOn && !game.isUnopenedSquares()){
                    System.out.println(game.toString());
                    System.out.println("CONGRATULATIONS! GAME WON");
                    break;
                }
            }else if(in.equalsIgnoreCase("r")){
                game.changeMarker(input.nextInt());
            }else if(in.equalsIgnoreCase("s"))
                game.saveGame(game.toString());
            System.out.println(game.toString());
            test = game.toString();
            scan = new Scanner(test);
            System.out.println("Board size: " + test.length());
            while(scan.hasNextLine()){
                System.out.println("Line:" + scan.nextLine());
            }
            
        }
      
        System.out.println("Test ends here!");
        
    }
    
    public void saveGame(String data){
        Charset utf8 = StandardCharsets.UTF_8;
        ArrayList<String> save = new ArrayList<>();
        Scanner scan = new Scanner(data);
        while(scan.hasNextLine()){
            save.add(scan.nextLine());
        }
        try {

        Files.write(Paths.get("save1.txt"), save, utf8);

        } catch (IOException e) {
        e.printStackTrace();
        }  
    }
    
}
