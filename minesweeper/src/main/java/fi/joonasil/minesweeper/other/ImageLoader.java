package fi.joonasil.minesweeper.other;

import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Luokka kuvien lataamiseen resursseista.
 * 
 * @author Joonas Ilvonen
 */
public class ImageLoader {
    private ArrayList<Image> images = new ArrayList<>();
   
    /**
     * Metodi Lataa tarvittavat kuvat resursseista ja asettaa ne taulukkoon.
     */
    public void loadImages() {
        images.add(new Image(getClass().getClassLoader().getResource("openedEmpty.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened1.png").toString()));
        images.add(new Image(getClass().getClassLoader().getResource("opened2.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened3.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened4.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened5.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened6.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened7.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("opened8.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("openedMine.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("flag.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("questionmark.png").toString())); 
        images.add(new Image(getClass().getClassLoader().getResource("unopenedNew.png").toString())); 
    }
  
    /**
     * Metodi palauttaa pelin tarvitsemat kuvat.
     * @return Lista kuvista.
     */
    public ArrayList<Image> getImages() {
        loadImages();
        return this.images;
    }
   
}
