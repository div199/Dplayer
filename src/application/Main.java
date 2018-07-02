package application;
	
import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;


public class Main extends Application {

	
	
	Player player;
	FileChooser fc;
	
	public void start(final Stage primaryStage) {
		
	
		
		MenuItem open = new MenuItem("Open");
		Menu file = new Menu("File");
		MenuBar menu = new MenuBar();
		
		file.getItems().add(open);
		menu.getMenus().add(file);
		fc=new FileChooser();
		
		open.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent e) {
				player.player.pause();
				File file = fc.showOpenDialog(primaryStage);
				if(file!=null) {
					try {
					player=new Player(file.toURI().toURL().toExternalForm());
					Scene scene = new Scene(player,1100,700,Color.BLACK);
					player.setTop(menu);
					primaryStage.setScene(scene);
				
					}
					catch(MalformedURLException e1){
						e1.printStackTrace();
						
						
					}
			}
				}
			
		});
		
		
	    player = new Player("file:///C:/ha.mp3");
		player.setTop(menu);
	
		primaryStage.setTitle("DPlayer");
		
		Scene scene = new Scene(player,900,700);
		
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
