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

/**
 *
 * @author Joonas
 */
public class SquareTest {
    
    Square square;
    
    public SquareTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        square = new Square();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void costructorSetsAdjacentMinesRight() {
        int answer = square.getAdjacentMines();
        assertEquals(0, answer);
    }
    
    @Test
    public void costructorSetsIsMineRight(){
        assertEquals(false, square.isMine());
    }
    
    @Test
    public void constructorSetsIsOpenedRight(){
        assertEquals(false, square.isOpen());
    }
    
    @Test
    public void toStringUnopened(){
        assertEquals("0", square.toString());
    }
    
    @Test
    public void toStringUnopenedMine(){
        Square mine = new Square(true);
        assertEquals("0",mine.toString());
    }
    
    @Test
    public void toStringOpened(){
        square.open();
        assertEquals("x",square.toString());
    }
    
    @Test
    public void toStringOpenedMine(){
        Square mine = new Square(true);
        mine.open();
        assertEquals("#",mine.toString());
    }
    
    @Test
    public void toStringUnopenedNumber(){
        square.setAdjacentMines(5);
        assertEquals("0", square.toString());
    }
    
    @Test
    public void toStringOpenedNumber(){
         square.setAdjacentMines(5);
         square.open();
        assertEquals("5", square.toString());
    }
    
    @Test
    public void toStringOpenedNumber8(){
         square.setAdjacentMines(8);
         square.open();
        assertEquals("8", square.toString());
    }
    
    @Test
    public void toStirngFlag(){
        square.setFlag();
        assertEquals("F", square.toString());
    }
    
    @Test
    public void toStirngQuestionmark(){
        square.setQuestionM();
        assertEquals("?", square.toString());
    }
    
    @Test
    public void setAdjacentMinesTo0(){
        Square sq = new Square(5);
        sq.setAdjacentMines(0);
        assertEquals(5, sq.getAdjacentMines());
    }
    
    @Test
    public void setAdjacentMinesTo8(){
        square.setAdjacentMines(8);
        assertEquals(8, square.getAdjacentMines());
    }
    
    @Test
    public void setAdjacentMinesTo9(){
        square.setAdjacentMines(9);
        assertEquals(0, square.getAdjacentMines());
    }
    
    @Test
    public void setAdjacentMinesToNegative(){
        square.setAdjacentMines(-1);
        assertEquals(0, square.getAdjacentMines());
    }
    
    @Test
    public void setAdjacentMinesTo1(){
        square.setAdjacentMines(1);
        assertEquals(1, square.getAdjacentMines());
    }
    
    @Test
    public void MarkerIsNotNull(){
        assertEquals(Marker.EMPTY, square.getMarker());
    }
    
    @Test
    public void setMarkerToEmpty(){
        square.setEmpty();
        assertEquals(Marker.EMPTY, square.getMarker());
    }
//    
//    @Test
//    public void setMine(){
//        square.setMine();
//        assertEquals(true, square.isMine());
//    }
//    
//    @Test
//    public void setToMine(){
//        square.setMine(true);
//        assertEquals(true, square.isMine());
//    }
//    
//    @Test
//    public void setToNotMine(){
//        square.setMine(false);
//        assertEquals(false, square.isMine());
//    }
}
