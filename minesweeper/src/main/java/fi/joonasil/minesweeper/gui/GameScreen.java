
package fi.joonasil.minesweeper.gui;

import fi.joonasil.minesweeper.gui.menus.MenuBarSetUp;
import fi.joonasil.minesweeper.Main;
import fi.joonasil.minesweeper.gui.square.SquareGui;
import fi.joonasil.minesweeper.gui.timer.Timer;
import fi.joonasil.minesweeper.logic.Minefield;
import fi.joonasil.minesweeper.other.ImageLoader;
import fi.joonasil.minesweeper.other.Minesweeper;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;


/**
 * Luokka rakentaa ikkunan näkymän ja tällä hetkellä myös hoitaa valikoiden 
 * tepahtumat. (anonymous inner classes)
 * 
 * @author Joonas Ilvonen
 */
public final class GameScreen {
    
    private final Scene scene;
    private final ArrayList<SquareGui> squares = new ArrayList<>();
    private final Label minesLeft;
    private final Label time;
    private HBox info;
    
    /**
     * Konstruktori luo pelin käyttölittymän ulkoasun.
     * 
     * @param x Ruutujen määrä vaakasuorassa.
     * @param y Ruutujen määrä pystysuorassa.
     */
    public GameScreen(int x, int y) {
        VBox layout = new VBox();
        minesLeft = new Label(Integer.toString(Minesweeper.getBoard().getMinesLeft()));
        time = new Label(Minesweeper.getTimer().toString());
        
        layout.getChildren().addAll(MenuBarSetUp.setMenus(), setInfoBar(minesLeft, time), constructBoard(x, y));

        scene = new Scene(layout, (x + 1) * 32, (y + 2.3) * 32);
    }
    
    /**
     * Metodi luo palkin pelin tiedoille kuten jäljellä oleville miinoille
     * ja ajastimelle.
     * 
     * @param mines Miinoja jäljellä.
     * @param time Peliaika.
     * @return Ulkoasu pelin tietopalkille.
     */
    public HBox setInfoBar(Label mines, Label time) {
         //HBox For Mines Left and Timer
        info = new HBox();
        Label minesLeft = new Label("Mines Left:");
        Label timer = new Label("  Time:");
        info.getChildren().addAll(minesLeft, mines, timer, time);
        info.setAlignment(Pos.CENTER);
        info.setSpacing(1);
        return info;
    }
    
    /**
     * Luo peliruudukon miinaharavalle.
     * 
     * @param x Ruudukon leveys ruuduissa.
     * @param y Ruudukon korkeus ruuduissa.
     * @return luotu peliruudukko.
     */
    public GridPane constructBoard(int x, int y) {
        ArrayList<Image> imgs;
        ImageLoader load = new ImageLoader();
        imgs = load.getImages();
        GridPane layout = new GridPane();
        layout.setMaxSize(x * 32, y * 32);
        layout.setMinSize(x * 32, y * 32);
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                squares.add(new SquareGui(imgs, i * x + j));
                GridPane.setConstraints(squares.get(i * x + j).getCurrent(), j, i);
                layout.getChildren().add(squares.get(i * x + j).getCurrent());
            }
        }
        layout.setPadding(new Insets(5, 0, 10, 15));
        return layout;
    }
    
    public Scene getScene() {
        return this.scene;
    }
    
    /**
     * Päivittää pelikellon näytölle.
     * 
     * @param s Kulunut aika.
     */
    public void setTime(String s) {
        time.setText(s);
    }
    
    /**
     * Päivittää jäljellä olevien miinojen määrän näytölle.
     * 
     * @param s Miinoja jäljellä.
     */
    public void setMinesLeft(String s) {
        minesLeft.setText(s);
    }
    
    /**
     * Asettaa ruudulle uuden kuvan.
     * 
     * @param index Ruudun indeksi.
     * @param imgIndex Kuvan indeksi.
     */
    public void setImage(int index, int imgIndex) {
        this.squares.get(index).setCurrent(imgIndex);
    }
    
    /**
     * Piirtää hävisit pelin- ilmoituksen näytölle.
     */
    public void gameOver() {
        info.getChildren().clear();
        Text gameOver = new Text("GAME OVER!");
        gameOver.setStyle("-fx-font-weight: bold");
        gameOver.setStyle("-fx-font-size: 16");
        info.getChildren().add(gameOver);
    }
}
