package prog;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class TicTacToeMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			// Quelle: https://youtu.be/3wF3Hb9Ugq0
			AudioClip audio = new AudioClip(getClass().getResource("audio.wav").toString());
			audio.setCycleCount(AudioClip.INDEFINITE);
			audio.setVolume(0.1);
			audio.play();

			Parent root = FXMLLoader.load(getClass().getResource("TicTacToe.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("TicTacToe");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
