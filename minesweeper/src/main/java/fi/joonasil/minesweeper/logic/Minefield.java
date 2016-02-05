package fi.joonasil.minesweeper.logic;
import java.util.*;

public class Minefield {
    private ArrayList<Square> board = new ArrayList<>();
    private final int X;
    private final int Y;
    private final int MINES;
    
    public Minefield(int x, int y, int mines){
        if(x < 9)
            x = 9;
        if(y < 9)
            y = 9;
        if(mines < (int)(x*y)/8)
            mines = (int)(x*y)/8;
        this.X = x;
        this.Y = y;
        int size = x*y;
        if (mines > size)
            mines = (int)size/2;
        this.MINES = mines;    
        addSquares(size);
        countAdjacentMines();
    }
    
    public Minefield(){
        this.X = 9;
        this.Y = 9;
        this.MINES = 10;
        int size = 81;
        Square sq;
        int j = 0;
        for(int i = 0; i < (size); i++){
            if(i%2 == 0 && j < this.getMines()){
                sq = new Square(true);
                j++;
            }else{
                sq = new Square();
            }
            board.add(sq);
        }     
        countAdjacentMines();
    }
    
    private void addSquares(int size){
        Square sq;
        ArrayList<Integer> mineId = mineIndexes(10);
        int j = 0;
        for(int i = 0; i < (size); i++){
            if(mineId.get(j) == i && j < 10){
                sq = new Square(true);
                j++;
                if(j == 10){
                    j = 0;
                }
            }else{
                sq = new Square();
            }
            board.add(sq);
        }     
    }
    
    private ArrayList<Integer> mineIndexes(int mines){
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
            }
        }
    }   
    private ArrayList<Integer> adjacentIndexes(int index){
        int x = index % this.getX();
        int y = index / this.getX();
        ArrayList<Integer> adjacentId = new ArrayList<>();
        for(int dx = (x > 0 ? -1 : 0); dx <= (x < X-1 ? 1 : 0); ++dx){
            for(int dy = (y > 0 ? -1 : 0); dy <= (y < Y-1 ? 1 : 0); ++dy){
                if(dx != 0 || dy != 0){
                    adjacentId.add((((dy+y)*X)+(dx+x)));
                }
            }
        }
        return adjacentId;
    }
    
    public boolean openSquares(int index){
        Square current = board.get(index);
        if(current.getMarker() == Marker.EMPTY){
                current.open();
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
        }
        return true;
    }
    
    public void changeMarker(int index){
        Square current = board.get(index);
        if(current.getMarker() == Marker.EMPTY && !current.isOpen())
            current.setFlag();
        else if(current.getMarker() == Marker.FLAG)
            current.setQuestionM();
        else
            current.setEmpty();
    }
    
    public int getX(){
        return this.X;
    }
    
    public int getY(){
        return this.Y;
    }
    
    public int getMines(){
        return this.MINES;
    }
    
    public ArrayList<Square> getSquares(){
       return this.board; 
    } 
            
            
    public boolean isUnopenedSquares(){
        int size = this.getX()*this.getY();
        int unopened = 0;
        for(int i = 0; i < size; i++){
            if(!board.get(i).isOpen())
                unopened++;
        }
        if(unopened == this.getMines())
            return false;
        return true;
    }
    
    @Override
    public String toString(){
        String s = "";
        for(int i = 0; i < board.size(); i++){
            if((i)%this.getX() == 0 && i != 0){
               s = s + "\n";
           }
            s = s + board.get(i).toString();
        }
       return s;
    }
}
