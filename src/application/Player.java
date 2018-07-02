package application;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Player extends BorderPane {

	Media media;
	MediaPlayer player;
	MediaView view;
	Pane mpane;
	MediaBar bar;
	
	public Player(String file) {
		media=new Media(file);
		player = new MediaPlayer(media);
		view= new MediaView(player);
		mpane= new Pane();
		mpane.getChildren().add(view);
		
		setCenter(mpane);
		player.play();
		
		bar= new MediaBar(player);
		setBottom(bar);
		setStyle("-fx-background-color: #bfc2c7");
		
	
		
	}
	
}
