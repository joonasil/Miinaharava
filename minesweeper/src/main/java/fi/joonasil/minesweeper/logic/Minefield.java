package fi.joonasil.minesweeper.logic;
import java.util.*;

public class Minefield {
    private ArrayList<Square> board = new ArrayList<>();
    private final int X;
    private final int Y;
    
    public Minefield(int x, int y, int mines){
        if(x < 9)
            x = 9;
        if(y < 9)
            y = 9;
        this.X = x;
        this.Y = y;
        int size = x*y;
        if (mines > size)
            mines = (int)size/2;
      
        Square sq;
        ArrayList<Integer> mineId = mineIndex(mines);
        int j = 0;
        for(int i = 0; i < (size) ;i++){
            if(mineId.get(j) == i && j < mines){
                sq = new Square(true);
                board.add(sq);
//                System.out.println(i + ": Added a mine to the board!");
                j++;
                if(j == mines){
//                    System.out.println("ADDED TOTAL OF " + j + " MINES!");
                    j = 0;
                }
            }else{
                sq = new Square();
                board.add(sq);
//                System.out.println(i + ": Added a empty square to the board!");
            }          
        }
        countAdjacentMines();
    }
    
    private ArrayList<Integer> mineIndex(int mines){
        ArrayList<Integer> mineId = new ArrayList<>();
        Random rand = new Random();
        while(mineId.size() < mines){
            int r = rand.nextInt((X*Y));
            if(!mineId.contains(r))
                mineId.add(r);
        }
        Collections.sort(mineId);
        return mineId;
    }
    
    private void countAdjacentMines(){
        int mines;
        ArrayList<Integer> adjacentId; 
        for(int i = 0; i < board.size(); i++){
            mines = 0;
            if(!(board.get(i).isMine())){
                adjacentId = adjacentIndexes(i);
                for(int j = 0; j < adjacentId.size(); j++){
                    if(board.get(adjacentId.get(j)).isMine())
                        mines++;
                }
                board.get(i).setAdjacentMines(mines);
//                System.out.println("I set adjacent mines!");
            }
        }
    }   
    private ArrayList<Integer> adjacentIndexes(int index){
//        int size = (int)Math.sqrt(board.size());
//        System.out.println("Size: " + size);
        int x = index % X;
        int y = index / X;
//        System.out.println("x: " + x);
//        System.out.println("y: " + y);
//        System.out.print(index + ". IDs added: ");
        ArrayList<Integer> adjacentId = new ArrayList<>();
        for(int dx = (x > 0 ? -1 : 0); dx <= (x < X-1 ? 1 : 0); ++dx){
            for(int dy = (y > 0 ? -1 : 0); dy <= (y < Y-1 ? 1 : 0); ++dy){
                if(dx != 0 || dy != 0){
//                    System.out.print((((dy+y)*X)+(dx+x)) + ", ");
                    adjacentId.add((((dy+y)*X)+(dx+x)));
                }
            }
        }
        System.out.println();
        return adjacentId;
    }
    
    public boolean openSquares(int index){
        Square current = board.get(index);
        if(current.getMarker() == Marker.EMPTY){
                current.open();
                System.out.println("I opened a square!");
            if(current.isMine())
                return false;
            if(current.getAdjacentMines() == 0){
                ArrayList<Integer> adjacent = adjacentIndexes(index);
                for(Integer list : adjacent){
                    current = board.get(list);
                    if(!current.isOpen()){
                        current.open();
                        if(current.getAdjacentMines() == 0)
                            openSquares(list);
                    }
                }
            }
        }else{
            System.out.println("Can't open flag or questionmark.");
        }
        
        return true;
    }
    
    public int getX(){
        return this.X;
    }
    
    public int getY(){
        return this.Y;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < board.size(); i++){
            s = s + board.get(i).toString();
        }
        return s;
    }
}
