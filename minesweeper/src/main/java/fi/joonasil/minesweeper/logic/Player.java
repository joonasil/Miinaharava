package fi.joonasil.minesweeper.logic;

public class Player {
    Minefield board;
    
    public Player(int difficulty){
        switch(difficulty){
            case 0:
                this.board = new Minefield(9,9,10);
                break;
            case 1:
                this.board = new Minefield(16,16,40);
                break;
            case 2:
                this.board = new Minefield(30,16,99);
                break;
            default:
                this.board = new Minefield(9,9,10);
                break;
        }
    }
    
    public Player(int x, int y, int mines){
        this.board = new Minefield(x,y,mines);
    }
    
   public boolean leftClick(int index){
       if(board.openSquares(index)){
           return true;
       }else{
           System.out.println("GAME OVER!");
           return false;
       }
   }
   
   public void rightClick(int index){
       board.changeMarker(index);
   }
   
   public boolean gameWon(){
       return !(board.isUnopenedSquares());
   }
   
   @Override
   public String toString(){
       String s = board.toString();
       String output = "";
       for(int j = 0; j < s.length(); j++){
           output = output + s.charAt(j);
           if((j+1)%board.getX() == 0){
               output = output + "\n";
           }
       }
       return output;
   }
}
