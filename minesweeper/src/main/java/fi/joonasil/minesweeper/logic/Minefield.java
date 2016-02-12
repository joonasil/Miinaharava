package fi.joonasil.minesweeper.logic;
import java.util.Random;
import java.util.ArrayList;
import fi.joonasil.minesweeper.other.*;
import java.util.Collections;

/**
 * Luokka peliruudukon logiikalle.
 * 
 * @author Joonas
 */
public class Minefield {
    private ArrayList<Square> board = new ArrayList<>();
    private final int x;
    private final int y;
    private final int mines;
    private int minesLeft;
    
    
    public Minefield(int x, int y, int mines) {
        if (x < 9) {
            x = 9;
        }
        if (y < 9) {
            y = 9;
        }
        if (mines < (int) (x * y) / 8) {
            mines = (int) (x * y) / 8;
        }
        this.x = x;
        this.y = y;
        int size = x * y;
        if (mines > size) {
            mines = (int) size / 2;
        }
        this.mines = mines;
        minesLeft = this.getMines();
        addSquares(size);
        countAdjacentMines();
    }
    
    public Minefield() {
        this.x = 9;
        this.y = 9;
        this.mines = 10;
        int size = 81;
        Square sq;
        int j = 0;
        for (int i = 0; i < (size); i++) {
            if (i % 2 == 0 && j < this.getMines()) {
                sq = new Square(true);
                j++;
            } else {
                sq = new Square();
            }
            board.add(sq);
        }     
        countAdjacentMines();
    }
    
    private void addSquares(int size) {
        Square sq;
        ArrayList<Integer> mineId = mineIndexes(10);
        int j = 0;
        for (int i = 0; i < (size); i++) {
            if (mineId.get(j) == i && j < 10) {
                sq = new Square(true);
                j++;
                if (j == 10) {
                    j = 0;
                }
            } else {
                sq = new Square();
            }
            board.add(sq);
        }     
    }
    
    private ArrayList<Integer> mineIndexes(int mines) {
        ArrayList<Integer> mineId = new ArrayList<>();
        Random rand = new Random();
        while (mineId.size() < mines) {
            int r = rand.nextInt((x * y));
            if (!mineId.contains(r)) {
                mineId.add(r);
            }
        }
        Collections.sort(mineId);
        return mineId;
    }
    
    private void countAdjacentMines() {
        int mines;
        ArrayList<Integer> adjacentId; 
        for (int i = 0; i < board.size(); i++) {
            mines = 0;
            if (!(board.get(i).isMine())) {
                adjacentId = adjacentIndexes(i);
                for (int j = 0; j < adjacentId.size(); j++) {
                    if (board.get(adjacentId.get(j)).isMine()) {
                        mines++;
                    }
                }
                board.get(i).setAdjacentMines(mines);
            }
        }
    }   
    private ArrayList<Integer> adjacentIndexes(int index) {
        int x = index % this.getX();
        int y = index / this.getX();
        ArrayList<Integer> adjacentId = new ArrayList<>();
        for (int dx = (x > 0 ? -1 : 0); dx <= (x < this.x - 1 ? 1 : 0); ++dx) {
            for (int dy = (y > 0 ? -1 : 0); dy <= (y < this.y - 1 ? 1 : 0); ++dy) {
                if (dx != 0 || dy != 0) {
                    adjacentId.add((((dy + y) * this.x) + (dx + x)));
                }
            }
        }
        return adjacentId;
    }
    
    /**
     * Avaa ruutuja miinaharavan sääntöjen mukaan.
     * 
     * @param index Indeksi, jota on painettu hiirne vasemmalla painikkeella.
     * @return tulee muuttumaan int listaksi
     */
    public boolean openSquares(int index) {
        Square current = board.get(index);
        if (current.getMarker() == Marker.EMPTY) {
                current.open();
            if (current.isMine()) {
                return false;
            }
            if (current.getAdjacentMines() == 0) {
                ArrayList<Integer> adjacent = adjacentIndexes(index);
                for (Integer list : adjacent) {
                    current = board.get(list);
                    if (!current.isOpen()) {
                        current.open();
                        if (current.getAdjacentMines() == 0) {
                            openSquares(list);
                        }
                    }
                }
            }
        }
        return true;
    }
    
    /**
     * Pitää kirjaa onko ruutua painettu oikealla hiiren painikkeella.
     * Merkitsee ruudun "lipuksi" tai "kysymysmerkiksi".
     * 
     * @param index Indeksi, jota on painettu oikealla hiiren painikkeella.
     */
    public void changeMarker(int index) {
        Square current = board.get(index);
        if (current.getMarker() == Marker.EMPTY && !current.isOpen()) {
            current.setFlag();
            this.minesLeft--;
        } else if (current.getMarker() == Marker.FLAG) {
            current.setQuestionM();
            this.minesLeft++;
        } else {
            current.setEmpty();
        }
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getMines() {
        return this.mines;
    }
    
    public int getSize() {
        return this.getX() * this.getY();
    }
    
    public ArrayList<Square> getSquares() {
       return board; 
    }
   
    /**
     * Metodi tarkistaa onko kaikki mahdolliset ruudut avattu.
     * 
     * @return totuusarvo onko vielä avaamattomia ruutuja
     */        
    public boolean isUnopenedSquares() {
        int size = getX() * getY();
        int unopened = 0;
        for (int i = 0; i < size; i++) {
            if (!board.get(i).isOpen()) {
                unopened++;
            }
        }
        if (unopened == getMines()) {
            return false;
        }
        return true;
    }
    
    /**
     *  Metodi muuttaa pelilaudan tiedot tallennettavaan muotoon. Ei valmis!
     */
    public void saveGame() {
        String s = "";
       for (int i = 0; i < getSize(); i++) {
            if ((i) % this.getX() == 0 && i != 0 && i < this.getSize() - 1) {
               s += "$";
           }
            s += board.get(i).toSaveFormat();
        }
       Saves.saveGame(s);
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < this.getSize(); i++) {
            if ((i) % this.getX() == 0 && i != 0 && i < this.getSize() - 1) {
               s = s + "\n";
           }
            s = s + board.get(i).toString();
        }
       return s;
    }
}
