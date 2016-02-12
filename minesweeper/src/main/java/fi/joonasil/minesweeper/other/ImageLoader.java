package fi.joonasil.minesweeper.other;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ImageLoader {
    private ArrayList<Image> images = new ArrayList<>();
   
    public void loadImages(){
        images.add(new Image(getClass().getClassLoader().getResource("unopenedNew.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("openedEmpty.png").toString()));
    }
  
    public ArrayList<Image> getImages(){
        loadImages();
        return this.images;
    }
   
}
