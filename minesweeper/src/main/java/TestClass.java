
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import fi.joonasil.minesweeper.logic.*;
public class TestClass {
    public static void main(String[] args){     
        System.out.println("Test starts here!");
         Minefield game = new Minefield(9,9,10);
        Scanner input = new Scanner(System.in);
        int x = 1;
        int y = 1;
        int mines = 1;
        boolean gameOn = true;

       
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
            }
            System.out.println(game.toString());

        }
      
        System.out.println("Test ends here!");
        
    }
}
