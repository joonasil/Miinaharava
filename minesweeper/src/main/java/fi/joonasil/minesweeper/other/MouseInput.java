package fi.joonasil.minesweeper.other;

import fi.joonasil.minesweeper.gui.square.SquareGui;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseInput implements EventHandler<MouseEvent>{
    
    ImageView current;
    
    @Override
    public void handle(MouseEvent event) {
        current = (ImageView)(event.getTarget());
        System.out.println(event.getEventType().toString());
        System.out.println(event.getEventType().equals(MouseEvent.MOUSE_PRESSED));
    }
    
    public void handleLeftPressed(MouseEvent event){
        
    }
    
}
