/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.joonasil.minesweeper.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 *
 * @author Joonas
 */
public class MinefieldTest {
    
    Minefield field;
    
    public MinefieldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        field = new Minefield(9,9,10);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void minefieldConstructorSetsRightNumberOfMines(){
        assertEquals(10,field.getMines());
    }
    
    @Test
    public void minefieldConstructorSetsRightSize(){
        assertEquals(81,field.getSize());
    }
    
    @Test
    public void mineIndexesReturnRightSizedList(){
        int mines = 0;
         for(int i = 0; i < field.getSize(); i++){
             if(field.getSquares().get(i).isMine())
                 mines++;
         }
         assertEquals(10,mines);
    }
      
    @Test
    public void minefieldHasRightNumberOfSquares(){
        Minefield board = new Minefield(10,10,10);
        assertEquals(100,board.getSquares().size());
    }
   
    @Test
    public void openSquare(){
        int i;
        for(i = 0; i < field.getSize();){
            if(field.getSquares().get(i).getAdjacentMines() == 0 && !field.getSquares().get(i).isMine()) {
                field.openSquares(i);
                break;
            }
            i++;
        }
        assertEquals(true,field.getSquares().get(i).isOpen());
    }
    
    @Test
    public void openSquares(){
        int i;
        for(i = 0; i < field.getSize();){
            if(field.getSquares().get(i).getAdjacentMines() == 0 && !field.getSquares().get(i).isMine()) {
                field.openSquares(i);
                break;
            }
            i++;
        }
        assertEquals(true,field.getSquares().get(i+1).isOpen());
    }
    
    @Test
    public void changeMarker(){
        field.changeMarker(0);
        assertEquals(Marker.FLAG,field.getSquares().get(0).getMarker());
    }
    
    @Test
    public void changeMarkerTwice(){
        field.changeMarker(0);
        field.changeMarker(0);
        assertEquals(Marker.QUESTIONMARK, field.getSquares().get(0).getMarker());
    }
    
    @Test
    public void changeMarkerThrice(){
        field.changeMarker(0);
        field.changeMarker(0);
        field.changeMarker(0);
        assertEquals(Marker.EMPTY, field.getSquares().get(0).getMarker());
    }
    
    @Test
    public void unopenedSquares(){
        assertEquals(true,field.isUnopenedSquares());
    }
    
    @Test
    public void noUnopenedSquares() {
        ArrayList<Square> sq = field.getSquares();
        for (int i = 0; i < field.getSize(); i++) {
            if (!sq.get(i).isMine() && !sq.get(i).isOpen()) {
                field.openSquares(i);
            }
        }
        assertEquals(false,field.isUnopenedSquares());
    }
    
    @Test
    public void testMinesLeft(){
        assertEquals(10,field.getMinesLeft());
    }
    
    @Test
    public void testMinesLeftAfterRightClick(){
        field.changeMarker(0);
        assertEquals(9,field.getMinesLeft());
    }
    
    @Test
    public void testMinesLeftAfterTwoRightClicks(){
        field.changeMarker(0);
        field.changeMarker(0);
        assertEquals(10,field.getMinesLeft());
    }
    
    @Test
    public void testOpenSquares() {
        int i;
        HashSet<Integer> opened = new HashSet<>();
        for(i = 0; i < field.getSize();){
            if(field.getSquares().get(i).getAdjacentMines() != 0 && !field.getSquares().get(i).isMine()) {
                opened = field.openSquares(i);
                break;
            }
            i++;
        }
        assertEquals(1,opened.size());
    }
    
    @Test
    public void testOpenMultipleSquares() {
        int i;
        HashSet<Integer> opened = new HashSet<>();
        for(i = 0; i < field.getSize();){
            if(field.getSquares().get(i).getAdjacentMines() == 0 && !field.getSquares().get(i).isMine() && i < 9) {
                opened = field.openSquares(i);
                break;
            }
            i++;
        }
        boolean answer = false;
        if(opened.size() >= 9) {
            answer = true;
        }
        assertEquals(true, answer);
    }
    
}
