
package fi.joonasil.minesweeper.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args){
        
        System.out.println("Test starts here!");
        Scanner input = new Scanner(System.in);
        int x = 1;
        int y = 1;
        int mines = 1;
        boolean gameOn = true;

        Player player1 = new Player(x,y,mines);
        while(gameOn){
            System.out.println(player1.toString());
            System.out.println("Left or right click? (L/R)");
            String in = input.next();
            if(in.equalsIgnoreCase("l")){
                gameOn = player1.leftClick(input.nextInt());
                if(gameOn && player1.gameWon()){
                    System.out.println(player1.toString());
                    System.out.println("CONGRATULATIONS! GAME WON");
                    break;
                }
            }else if(in.equalsIgnoreCase("r")){
                player1.rightClick(input.nextInt());
            }
        }

        System.out.println("Test ends here!");
        
    }
    
    private static int[] adjacentIndexes(int index){
        int size = 8;
        int x = index % size;
        int y = index / size;
        ArrayList<Integer> adjacentId = new ArrayList<>();
        for(int dx = (x > 0 ? -1 : 0); dx <= (x < size-1 ? 1 : 0); ++dx){
            for(int dy = (y > 0 ? -1 : 0); dy <= (y < size-1 ? 1 : 0); ++dy){
                if(dx != 0 || dy != 0){
                    adjacentId.add((((dy+y)*size)+(dx+x)));
                }
            }
        }
        int[] output = new int[adjacentId.size()];
        for(int i = 0; i < adjacentId.size(); i++){
            output[i] = adjacentId.get(i);
        }
        return output;
    }
    
    private static int[] mineIndex(int size, int mines){
        ArrayList<Integer> mineId = new ArrayList<>();
        int[] outputMines = new int[mines];
        Random rand = new Random();
        while(mineId.size() < mines){
            int x = rand.nextInt((size*size));
            if(!mineId.contains(x))
                mineId.add(x);
        }
        Collections.sort(mineId);
        for(int i = 0; i < mines ; i++){
            outputMines[i] = mineId.get(i);
        }
        return outputMines;
    }
}
