package fi.joonasil.minesweeper.gui.menus;

import fi.joonasil.minesweeper.highscores.HighScores;
import fi.joonasil.minesweeper.highscores.Score;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HighScoreGui {
    Stage window;
    HighScores hs;
    TableView table;
    ObservableList<Score> scores;
    
    public HighScoreGui() {    
        window = new Stage();
        hs = new HighScores();              
    }
    
    public void add(String name, String time, int difficulty) {
        hs.add(name, time, difficulty);
        scores.add(new Score(name, time));
        Collections.sort(scores);
        int x = 1;
        for(Score s : scores) {
            s.setPosition(x);
            x++;
        }
        load(difficulty);
    }
    
    public void load(int difficulty) {
        switch (difficulty) {
            case 0:
                window.setTitle("Highscores - Easy");
                break;
            case 1:
                window.setTitle("Highscores - Medium");
                break;
            case 2:
                window.setTitle("Highscores - Hard");
                break;                
        }
        List<Score> load = new ArrayList();
        load = hs.load(difficulty);
        ObservableList<Score> scores = FXCollections.observableArrayList();
        for(Score s : load) {
            scores.add(s);
        }
        this.scores = scores;
        draw();
    }
    
    public void draw() {
        TableColumn<Score, String> posColumn = new TableColumn<>("Position");
        posColumn.setMinWidth(80);
        posColumn.setMaxWidth(80);
        posColumn.setCellValueFactory(new PropertyValueFactory<>("position"));
        TableColumn<Score, TextField> nameColumn = new TableColumn("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn<Score, String> timeColumn = new TableColumn<>("Time");
        timeColumn.setMinWidth(90);
        timeColumn.setMaxWidth(90);
        timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
        
        table = new TableView();
        table.setItems(scores);
        table.getColumns().addAll(posColumn, nameColumn, timeColumn);
        VBox layout = new VBox();
        HBox buttons = new HBox();
        
        Button easyButton = new Button("Easy");
        easyButton.setOnAction(e -> load(0));
        
        Button mediumButton = new Button("Medium");
        mediumButton.setOnAction(e -> load(1));
        
        Button hardButton = new Button("Hard");
        hardButton.setOnAction(e -> load(2));
        
        Button closeButton = new Button("Close");
        closeButton.setOnAction(e -> window.close());

        easyButton.setMinWidth(77);
        mediumButton.setMinWidth(77); 
        hardButton.setMinWidth(77); 
        closeButton.setMinWidth(77); 
        
        buttons.getChildren().addAll(easyButton, mediumButton, hardButton, closeButton);
        buttons.setSpacing(18);
        buttons.setPadding(new Insets(5,5,5,5));
        layout.getChildren().addAll(table,buttons);
        Scene scene = new Scene(layout, 371, 300);
        
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }
}
