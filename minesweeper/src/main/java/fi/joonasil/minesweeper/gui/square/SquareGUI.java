package fi.joonasil.minesweeper.gui.square;

import fi.joonasil.minesweeper.logic.Marker;
import fi.joonasil.minesweeper.other.MineFactory;
import java.util.ArrayList;
import java.util.HashSet;
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
public class SquareGui implements EventHandler<MouseEvent> {
    private final ArrayList<Image> images;
    private final ImageView current;
    private final int index;
    
    public SquareGui(ArrayList<Image> imgs, int index) {
        this.images = imgs;
        current = new ImageView(imgs.get(12));
        this.index = index;
        current.setOnMousePressed(e -> handle(e));
        current.setOnMouseReleased(e -> handle(e));
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

    @Override
    public void handle(MouseEvent event) {
        MineFactory.getTimer().play();
        if (MineFactory.getBoard().isGameOver()) {
            return;
        }
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            leftClick(event);
        }
        if (event.getButton().equals(MouseButton.SECONDARY)) {
            rightClick(event);
        }
    }
    
    public void setMarker(){
        if (MineFactory.getBoard().getSquares().get(this.getIndex()).isOpen()) {
            return;
        }
        Marker mark = MineFactory.getBoard().getSquares().get(this.getIndex()).getMarker();
        if (mark == Marker.FLAG) {
            this.setCurrent(10);
            MineFactory.getScreen().setMinesLeft(Integer.toString(MineFactory.getBoard().getMinesLeft()));
        }
        if (mark == Marker.QUESTIONMARK) {
            this.setCurrent(11);
            MineFactory.getScreen().setMinesLeft(Integer.toString(MineFactory.getBoard().getMinesLeft()));
        }
        if (mark == Marker.EMPTY) {
            this.setCurrent(12);
        }
    }
    
    public void rightClick(MouseEvent event){
        if (MineFactory.getBoard().getSquares().get(this.getIndex()).isOpen()) {
            return;
        }
        if(event.getX() > 0 && event.getX() < 32 && event.getY() > 0 && event.getY() < 32) {
            if(event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                MineFactory.getBoard().changeMarker(this.getIndex());
                setMarker();
            }
        } else {
            setMarker();
        }
    }
    
    public void leftClick(MouseEvent event){
        if (MineFactory.getBoard().getSquares().get(this.getIndex()).getMarker() != Marker.EMPTY) {
            return;
        }
        if (event.getX() > 0 && event.getX() < 32 && event.getY() > 0 && event.getY() < 32) {
            if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
                HashSet<Integer> opened = MineFactory.getBoard().openSquares(this.getIndex());
                if (opened.isEmpty() && MineFactory.getBoard().getSquares().get(this.getIndex()).isMine()) {
                    MineFactory.getScreen().setImage(this.getIndex(), 9);
                }
                opened.stream().forEach(this::setOpen);
            }
            if(event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
                if (!MineFactory.getBoard().getSquares().get(this.getIndex()).isOpen()) {
                    this.setCurrent(0);
                }
            }
        } else {
            setOpen(this.getIndex());
        }
        if (!MineFactory.getBoard().isUnopenedSquares()) {
            System.out.println("Game Won!");
            MineFactory.getTimer().stop();
        }
    }
    
    public void setOpen(int i) {
        MineFactory.getScreen().setImage(i, Integer.parseInt(MineFactory.getBoard().getSquares().get(i).toString()));
    }
}
