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
    
    /**
     * Luo uuden tyhjän ruudun.
     */
    public Square() {
        this.adjacentMines = 0;
        this.marker = Marker.EMPTY;
        this.isMine = false;
        this.isOpen = false;
    }
    
    /**
     * Luo uuden ruudun joko miinaksi tai tyhjäksi ruuduksi riippuen
     * parametrin arvosta.
     * 
     * @param mine Onko ruutu miina.
     */
    public Square(boolean mine) {
        this.adjacentMines = 0;
        this.marker = Marker.EMPTY;
        this.isMine = mine;
        this.isOpen = false;
    }
    
    public boolean isMine() {
        return this.isMine;
    }
    
    public int getAdjacentMines() {
        return adjacentMines;
    }
    
    public Marker getMarker() {
        return marker;
    }
    
    public boolean isOpen() {
        return this.isOpen;
    }
    
    /**
     * Asettaa ruudun avatuksi.
     */
    public void open() {
        this.isOpen = true;
    }
   
    /**
     * Asettaa tiedon ruudun viereisien miinojen määrästä.
     * @param x Ruudun viereisten miinojen määrä.
     */
    public void setAdjacentMines(int x) {
        if (1 <= x && x <= 8) {
            adjacentMines = x;
        } else {
            adjacentMines = 0;
        }
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }
    
    /**
     * Asettaa ruudun lipuksi.
     */
    public void setFlag() {
        marker = Marker.FLAG;
    }
    
    /**
     * Asettaa ruudun kysymysmerkiksi.
     */
    public void setQuestionM() {
        marker = Marker.QUESTIONMARK;
    }
    
    /**
     * Asettaa ruudun normaaliksi.
     */
    public void setEmpty() {
        marker = Marker.EMPTY;
    }
    
    @Override
    public String toString() {
        if (marker == Marker.FLAG) {
            return "10";
        } else if (marker == Marker.QUESTIONMARK) {
            return "11";
        } else if (isOpen && this.isMine()) {
            return "9";
        } else if (isOpen && adjacentMines == 0) {
            return "0";
        } else if (isOpen) {
            return Integer.toString(adjacentMines);
        } else {
            return "12";
        }
    }
}


