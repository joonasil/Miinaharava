package fi.joonasil.minesweeper.logic;
import java.util.Random;
import java.util.ArrayList;
import fi.joonasil.minesweeper.other.*;
import java.util.Collections;
import java.util.HashSet;

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
    private boolean gameOver;
    private boolean firstOpened;
    
    /**
     * Luo uuden pelilaudan.
     * 
     * @param x Peliruudukon ruutujen määrä vaakasuorassa.
     * @param y Peliruudukon ruutujen määrä pystysuorassa.
     * @param mines Miinojen määrä peliruudukossa.
     */
    public Minefield(int x, int y, int mines) {
        this.x = x;
        this.y = y;
        int size = x * y;
        this.mines = mines;
        firstOpened = false;
        minesLeft = this.getMines();
        gameOver = false;
        addSquares(size);
        countAdjacentMines();
    }
    
    private void addSquares(int size) {
        Square sq;
        ArrayList<Integer> mineId = mineIndexes(this.mines);
        int j = 0;
        for (int i = 0; i < (size); i++) {
            if (mineId.get(j) == i && j < this.mines) {
                sq = new Square(true);
                j++;
                if (j == this.mines) {
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
        int x = index % this.x;
        int y = index / this.x;
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
     * Avaa ruutuja miinaharavan sääntöjen mukaan. Jos ensimmäinen avattu
     * ruutu on miina, siirtyy miina yläkulmaan.
     * 
     * @param index Indeksi, jota on painettu hiirne vasemmalla painikkeella.
     * @return lista avattujen ruutujen indekseistä
     */
    public HashSet<Integer> openSquares(int index) {
        Square current = board.get(index);
        HashSet<Integer> openedSquares = new HashSet<>();
        if (!firstOpened && current.isMine()) {
            for (int i = 0; i < getSize(); i++) {
                if (!board.get(i).isMine()) {
                    board.get(i).setIsMine(true);
                    break;
                }
            }
            current.setIsMine(false);
            countAdjacentMines();
        }
        firstOpened = true;
        current = board.get(index);
        if (current.isMine()) {
            gameOver = true;
            return openedSquares;
        }
        if (current.getMarker() != Marker.EMPTY || current.isOpen()) {
            return openedSquares;
        }
        openedSquares.add(index);
        current.open();
        if (current.getAdjacentMines() != 0) {
            return openedSquares;
        }
        ArrayList<Integer> adjacent = adjacentIndexes(index);
        for (Integer list : adjacent) {
            current = board.get(list);
            if (current.getAdjacentMines() == 0) {
                openedSquares.addAll(openSquares(list));
            }
            current.open();
            openedSquares.add(list);  
        }
        return openedSquares;
    }
    /**
     * Pitää kirjaa onko ruutua painettu oikealla hiiren painikkeella.
     * Merkitsee ruudun "lipuksi" tai "kysymysmerkiksi".
     * 
     * @param index Indeksi, jota on painettu oikealla hiiren painikkeella.
     * 
     * @return Marker enum, joka kertoo onko ruutua painettu oikealla hiiren painikkeella ja kuinka monesti.
     */
    public Marker changeMarker(int index) {
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
        return current.getMarker();
    }

    public int getMines() {
        return this.mines;
    }
    
    public int getSize() {
        return this.x * this.y;
    }
    
    public ArrayList<Square> getSquares() {
        return board; 
    }

    public int getMinesLeft() {
        return minesLeft;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    /**
     * Metodi tarkistaa onko kaikki mahdolliset ruudut avattu.
     * 
     * @return totuusarvo onko vielä avaamattomia ruutuja
     */        
    public boolean isUnopenedSquares() {
        int size = getSize();
        int unopened = 0;
        for (int i = 0; i < size; i++) {
            if (!board.get(i).isOpen()) {
                unopened++;
            }
        }
        return unopened != getMines();
    }
}
