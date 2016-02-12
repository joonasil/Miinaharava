
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import fi.joonasil.minesweeper.logic.*;
import fi.joonasil.minesweeper.other.ImageLoader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class TestClass extends Application{
    public static void main(String[] args){     
        System.out.println("Test starts here!");
//         Minefield game = new Minefield(9,9,10);
//        Scanner input = new Scanner(System.in);
//        int x = 1;
//        int y = 1;
//        int mines = 1;
//        boolean gameOn = true;


//        String asd = "1\n2\n3\n4";
//        String test;
//        System.out.println(asd);
//        Scanner scan = new Scanner(asd);
//        ArrayList<String> save = new ArrayList<>();
//         while(scan.hasNextLine()){
//            save.add(scan.nextLine());
//        }
//         System.out.println(save.size());
        int x = 9, y = 9;
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                System.out.println(i*y+j);
            }
        }
        launch(args);



//        game.getTimer().startStop();
//        while(gameOn){
//            
//            System.out.println(game.toString());
//            System.out.println("Left or right click? (L/R)");
//            String in = input.next();
//            if(in.equalsIgnoreCase("l")){
//                gameOn = game.openSquares(input.nextInt());
//                if(gameOn && !game.isUnopenedSquares()){
//                    System.out.println(game.toString());
//                    System.out.println("CONGRATULATIONS! GAME WON");
//                    break;
//                }
//            }else if(in.equalsIgnoreCase("r")){
//                game.changeMarker(input.nextInt());
//            }else if(in.equalsIgnoreCase("s"))
//                game.saveGame();
//            System.out.println(game.getTimer().toString());
////                System.out.println(game.toString() + "\n");   
//        }
      
        System.out.println("Test ends here!");
        
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Minesweeper");
        ImageLoader loader = new ImageLoader();
        loader.loadImages();
        int x = 9; int y = 9;
        ArrayList<Image> images = loader.getImages();
        
        VBox layout = new VBox();
               
        //game menu
        Menu game = new Menu("Game");
        MenuItem newGame = new MenuItem("New Game");
        MenuItem quitGame = new MenuItem("Quit Game");
        game.getItems().addAll(newGame,quitGame);
        
        //difficulty menu
        Menu difficulty = new Menu("Difficulty");
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem medium = new RadioMenuItem("Medium");
        RadioMenuItem hard = new RadioMenuItem("Hard");
        ToggleGroup dif = new ToggleGroup();
        easy.setToggleGroup(dif);
        medium.setToggleGroup(dif);
        hard.setToggleGroup(dif);
        dif.selectToggle(easy);
        difficulty.getItems().addAll(easy,medium,hard);
        
        //menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(game,difficulty);
        
        //HBox For Mines Left and Timer
        HBox info = new HBox();
        Label minesLeft = new Label("Mines Left: x");
        Label time = new Label("  Time: 0:00:00");
        info.getChildren().addAll(minesLeft,time);
        info.setAlignment(Pos.CENTER);
        
        //GridPane
        GridPane grid = new GridPane();
        ArrayList<ImageView> squares = new ArrayList<>();
        for(int i = 0; i < x*y ; i++){
            squares.add(new ImageView(images.get(0)));
        }
       
        int add = 0;
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                GridPane.setConstraints(squares.get(add), j, i);
                grid.getChildren().add(squares.get(add));
                add++;
            }
        }
        
        grid.setPadding(new Insets(5,0,10,15));
        
        int numbers[] = new int[81];
        for(int i = 0; i < 81; i++){
            numbers[i] = i;
        }
        
        
        
       //main layout for scene
        layout.getChildren().addAll(menuBar,info,grid);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout,(x+1)*32,(y+2)*32);
        primaryStage.setScene(scene);
        primaryStage.show();
        
      
        
    }
    
    public void saveGame(String data){
        Charset utf8 = StandardCharsets.UTF_8;
        ArrayList<String> save = new ArrayList<>();
        Scanner scan = new Scanner(data);
        while(scan.hasNextLine()){
            save.add(scan.nextLine());
        }
        try {

        Files.write(Paths.get("save1.txt"), save, utf8);

        } catch (IOException e) {
        e.printStackTrace();
        }  
    }  
}
