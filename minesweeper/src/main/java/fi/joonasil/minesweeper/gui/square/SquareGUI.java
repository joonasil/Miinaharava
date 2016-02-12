package fi.joonasil.minesweeper.gui.square;

import fi.joonasil.minesweeper.other.MineFactory;
import java.util.ArrayList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

/**
 * Luokka yksittäisen ruudun esittämiseen graafisessa käyttöliittymässä.
 * 
 * @author Joonas Ilvonen
 */
public class SquareGui extends ImageView {
    ArrayList<Image> images;
    ImageView current;
    final int index;
    
    public SquareGui(ArrayList<Image> imgs, int index) {
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
    
    public int getIndex() {
        return this.index;
    }
}
