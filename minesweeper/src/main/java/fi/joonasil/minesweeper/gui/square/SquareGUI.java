/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.joonasil.minesweeper.gui.square;

import fi.joonasil.minesweeper.other.MineFactory;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class SquareGUI extends Rectangle{
    ArrayList<Image> images;
    ImageView current;
    final int index;
    
    public SquareGUI(ArrayList<Image> imgs, int index){
        this.images = imgs;
        current = new ImageView(imgs.get(0));
        this.index = index;
    }

    public ImageView getCurrent() {
        return current;
    }

    public void setCurrent(int index) {
        this.current.setImage(images.get(index));
    }
    
    public int getIndex(){
        return this.index;
    }
  
}
