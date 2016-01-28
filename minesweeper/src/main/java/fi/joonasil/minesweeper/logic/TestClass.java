
package fi.joonasil.minesweeper.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class TestClass {
    public static void main(String[] args){
        ArrayList<Square> squareList = new ArrayList<>();
        Marker lol = Marker.EMPTY;
        System.out.println("Test starts here!");
//        System.out.println(lol);
//        lol = Marker.QUESTIONMARK;
//        System.out.println(lol);
//        int a = 30;
//        int b = a % 8;
//        int c = a / 8;
//        int d = c*8+b;
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
        int x = 30;
        int y = 16;
        int mines = 10;
//        Minefield easy = new Minefield(x,y,10);
//        String board = easy.toString();
//        for(int i = board.length()-1; i >= 0; i--){
//            if((i)%x == 0)
//                System.out.println(board.charAt(i));
//            else
//                System.out.print(board.charAt(i));
//        }
//        System.out.println("");
//        int[] test;
        
//          test = mineIndex(9,10);
//        for(int j = 0; j < 64; j++){
//            test = adjacentIndexes(j);
//            for(int i = 0; i < test.length; i++){
//                System.out.print(test[i] + ", ");
//            }
//            System.out.println("");
//        }
        String s = "1\n2\n3";
        Player player1 = new Player(x,y,mines);
        System.out.println("This is a test: \n" + player1.toString());
       
//        Square sq = new Square();
//        System.out.println("This is a square: " + sq);
//        sq.setMine();
//        squareList.add(sq);
//        System.out.println("This is a mine: " + sq);
//        sq.setMine(false);
//        squareList.add(sq);
//        sq.setAdjacentMines(4);
//        squareList.add(sq);
//        System.out.println("This is a number: " + sq);
//        System.out.println("Number of elements in the list is: " + squareList.size());
        System.out.println("Test ends here!");
        
    }
    
    private static int[] adjacentIndexes(int index){
        int size = 8;
        int x = index % size;
        int y = index / size;
//        System.out.println("x: " + x);
//        System.out.println("y: " + y);
        System.out.print(index + ". IDs added: ");
        ArrayList<Integer> adjacentId = new ArrayList<>();
        for(int dx = (x > 0 ? -1 : 0); dx <= (x < size-1 ? 1 : 0); ++dx){
            for(int dy = (y > 0 ? -1 : 0); dy <= (y < size-1 ? 1 : 0); ++dy){
                if(dx != 0 || dy != 0){
//                    System.out.print((((dy+y)*size)+(dx+x)));
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
