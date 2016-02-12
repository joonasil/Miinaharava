package fi.joonasil.minesweeper.other;

import fi.joonasil.minesweeper.gui.square.SquareGUI;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MouseInput implements EventHandler<MouseEvent>{
    
    SquareGUI current;
    
    @Override
    public void handle(MouseEvent event) {
        if(event.getButton() == MouseButton.PRIMARY){
            if(event.equals(MouseEvent.MOUSE_PRESSED)){
                MineFactory.getScreen().setImage(0, 1);
            }else if(event.equals(MouseEvent.MOUSE_RELEASED)){
                MineFactory.getScreen().setImage(0, 0);
            }
        }else if(event.getButton() == MouseButton.SECONDARY){
            
        }
        
        
    }
    
    public void handleLeftPressed(MouseEvent event){
        
    }
    
}
