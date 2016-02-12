package fi.joonasil.minesweeper.logic;

/**
 * Luokka yksittäisen peliruudun logiikalle.
 * 
 * @author Joonas
 */
public class Square {
    private int adjacentMines;
    private boolean isMine;
    private boolean isOpen;
    private Marker marker;
    
    public Square(){
        this.adjacentMines = 0;
        this.marker = Marker.EMPTY;
        this.isMine = false;
        this.isOpen = false;
    }
    
    public Square(boolean mine){
        this.adjacentMines = 0;
        this.marker = Marker.EMPTY;
        this.isMine = mine;
        this.isOpen = false;
    }
    
    public Square(int mines){
        this.adjacentMines = mines;
        this.marker = Marker.EMPTY;
        this.isMine = false;
        this.isOpen = false;
    }
    
    public boolean isMine(){
        return this.isMine;
    }
    
    public int getAdjacentMines(){
        return adjacentMines;
    }
    
    public Marker getMarker(){
        return marker;
    }
    
    public boolean isOpen(){
        return this.isOpen;
    }
    
     public void open(){
        this.isOpen = true;
    }
    
//    public void setMine(){
//        this.isMine = true;
//    }
//    
//    public void setMine(boolean x){
//        this.isMine = x;
//    }
    
    public void setAdjacentMines(int x){
        if(1 <= x && x <= 8)
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
    
    /**
     * Metodi luokan tietojen muuttamiseksi tallennettavaan muotoon.
     * 
     * @return luokan tiedot tallennettavassa muodossa.
     */
    public String toSaveFormat(){
        String save = "";
        save += (this.isOpen() ? "1" : "0");
        save += (this.isMine() ? "1" : "0");
        save += this.getAdjacentMines();
        switch(this.getMarker()){
            case EMPTY:
                save += "0";
                break;
            case FLAG:
                save += "1";
                break;
            case QUESTIONMARK:
                save += "2";
                break;
        }     
        save += "|";
        return save;
    }
    
    @Override
    public String toString(){
        if(marker == Marker.FLAG)
            return "F";
        else if(marker == Marker.QUESTIONMARK)
            return "?";
        else if(isOpen && this.isMine())
            return "#";
        else if(isOpen && adjacentMines == 0)
            return "x";
        else if(isOpen)
            return Integer.toString(adjacentMines);
        else
            return "0";
    }
}


