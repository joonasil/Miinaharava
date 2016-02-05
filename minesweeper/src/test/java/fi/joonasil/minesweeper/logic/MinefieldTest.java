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
        field = new Minefield();
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
        assertEquals(81,field.getX()*field.getY());
    }
    
    @Test
    public void mineIndexesReturnRightSizedList(){
        int mines = 0;
         for(int i = 0; i < field.getX()*field.getY(); i++){
             if(field.getSquares().get(i).isMine())
                 mines++;
         }
         assertEquals(10,mines);
    }
    
//    @Test
//    public void MinefieldConstructorSetsRightSize2(){
//        Minefield board = new Minefield(9,9,10);
//        assertEquals(81,board.getX()*board.getY());
//    }
    
    @Test
    public void MinefieldConstructorSetsRightSize3(){
        Minefield board = new Minefield(0,0,10);
        assertEquals(81,board.getX()*board.getY());
    }
    
    @Test
    public void MinefieldConstructorSetsRightSize4(){
        Minefield board = new Minefield(10,10,10);
        assertEquals(100,board.getX()*board.getY());
    }
    
    @Test
    public void minefieldConstructorSetsRightNumberOfMines2(){
        Minefield board = new Minefield(9,9,10);
        assertEquals(10,board.getMines());
    }
    
    @Test
    public void minefieldConstructorSetsRightNumberOfMines3(){
        Minefield board = new Minefield(9,9,0);
        assertEquals(10,board.getMines());
    }
    
    @Test
    public void minefieldConstructorSetsRightNumberOfMines4(){
        Minefield board = new Minefield(9,9,10000);
        assertEquals(40,board.getMines());
    }
    
//    @Test
//    public void minefieldConstructorSetsRightSize5(){
//        Minefield board = new Minefield(8,8,10);
//        assertEquals(81,board.getX()*board.getY());
//    }
    
    @Test
    public void minefieldConstructorSetsRightX(){
        Minefield board = new Minefield(8,10,10);
        assertEquals(90,board.getX()*board.getY());
    }
    
    @Test
    public void minefieldConstructorSetsRightY(){
        Minefield board = new Minefield(10,8,10);
        assertEquals(90,board.getX()*board.getY());
    }
    
    @Test
    public void minefieldConstructorSetsRightX2(){
        Minefield board = new Minefield(9,10,10);
        assertEquals(90,board.getX()*board.getY());
    }
    
    @Test
    public void minefieldConstructorSetsRightY2(){
        Minefield board = new Minefield(10,9,10);
        assertEquals(90,board.getX()*board.getY());
    }
    
    @Test
    public void minefieldHasRightNumberOfSquares(){
        Minefield board = new Minefield(10,10,10);
        assertEquals(100,board.getSquares().size());
    }
    
    @Test
    public void openEmptySquare(){
        assertEquals(true,field.openSquares(9));
    }
    
    @Test
    public void openMine(){
        assertEquals(false,field.openSquares(2));
    }
    
    @Test
    public void openSquare(){
        field.openSquares(2);
        assertEquals(true,field.getSquares().get(2).isOpen());
    }
    
    @Test
    public void openSquares(){
        field.openSquares(40);
        assertEquals(true,field.getSquares().get(41).isOpen());
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
        assertEquals(Marker.QUESTIONMARK,field.getSquares().get(0).getMarker());
    }
    
    @Test
    public void unopenedSquares(){
        assertEquals(true,field.isUnopenedSquares());
    }
    
    @Test
    public void noUnopenedSquares(){
        ArrayList<Square> sq = field.getSquares();
        for(int i = 0; i < field.getX()*field.getY(); i++){
            if(!sq.get(i).isMine() && !sq.get(i).isOpen())
                field.openSquares(i);
        }
        assertEquals(false,field.isUnopenedSquares());
    }
}
