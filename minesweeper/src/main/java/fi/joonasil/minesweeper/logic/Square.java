package fi.joonasil.minesweeper.logic;

public class Square {
    private int adjacentMines;
    private boolean mine;
    private boolean isOpen;
    private Marker marker;
    
    public Square(){
        this.adjacentMines = 0;
        this.marker = Marker.EMPTY;
        this.mine = false;
        this.isOpen = false;
    }
    
    public Square(boolean mine){
        this.adjacentMines = 0;
        this.marker = Marker.EMPTY;
        this.mine = mine;
        this.isOpen = false;
    }
    
    public boolean isMine(){
        return mine;
    }
    
    public int getAdjacentMines(){
        return adjacentMines;
    }
    
    public Marker getMarker(){
        return marker;
    }
    
    public void open(){
        this.isOpen = true;
    }
    
    public boolean isOpen(){
        return this.isOpen;
    }
    
    public void setMine(){
        mine = true;
    }
    
    public void setMine(boolean x){
        mine = x;
    }
    
    public void setAdjacentMines(int x){
        adjacentMines = x;
    }
    
    public void setFlag(){
        marker = Marker.FLAG;
    }
    
    public void setQuestionM(){
        marker = Marker.QUESTIONMARK;
    }
    
    public void setEmpty(){
        marker = Marker.EMPTY;
    }
    
    @Override
    public String toString(){
        if(marker == Marker.FLAG)
            return "F";
        else if(marker == Marker.QUESTIONMARK)
            return "?";
        else if(isOpen && mine)
            return "#";
        else if(isOpen && adjacentMines == 0)
            return "x";
        else if(isOpen)
            return Integer.toString(adjacentMines);
        else
            return "0";
    }
}


