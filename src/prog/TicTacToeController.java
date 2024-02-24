package prog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TicTacToeController implements Initializable {

	@FXML
	GridPane gridPaneGitter;

	@FXML
	Pane pane00;

	@FXML
	Pane pane01;

	@FXML
	Pane pane02;

	@FXML
	Pane pane10;

	@FXML
	Pane pane11;

	@FXML
	Pane pane12;

	@FXML
	Pane pane20;

	@FXML
	Pane pane21;

	@FXML
	Pane pane22;

	@FXML
	Text text;

	private TicTacToeModel spiel;

	private void gitterAktualisieren() {
		int counter = 0;
		for (int i = 0; i < 3; i++) {
			for (int n = 0; n < 3; n++) {
				Pane panezelle = (Pane) gridPaneGitter.lookup("#pane" + i + n);
				char c = spiel.get(i, n);
				if (c != ' ') {
					counter++;
				}
				if (panezelle.getChildren().isEmpty() && c != ' ') {
					Text textt = new Text();
					textt.setText(Character.toString(c));
					Font font = new Font(50);
					textt.setFont(font);
					textt.setFill(Color.BLACK);
					textt.setX(33);
					textt.setY(55);
					panezelle.getChildren().add(textt);
				}

				if (spiel.winner() == 'X' || spiel.winner() == 'O') {
					text.setText(spiel.winner() + " hat Gewonnen!");
				}
				if (counter == 9 && spiel.winner() != 'X' && spiel.winner() != 'O') {
					text.setText("Unentschieden!");
				}
			}
		}
		counter = 0;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		pane00.setOnMouseClicked(this::handlePane);
		pane01.setOnMouseClicked(this::handlePane);
		pane02.setOnMouseClicked(this::handlePane);
		pane10.setOnMouseClicked(this::handlePane);
		pane11.setOnMouseClicked(this::handlePane);
		pane12.setOnMouseClicked(this::handlePane);
		pane20.setOnMouseClicked(this::handlePane);
		pane21.setOnMouseClicked(this::handlePane);
		pane22.setOnMouseClicked(this::handlePane);
		this.spiel = new TicTacToeModel();
		text.setText("");
	}

	public void handlePane(MouseEvent event) {
		if (spiel.winner() != 'X' && spiel.winner() != 'O') {
			Node node = (Node) event.getSource();
			String fxId = node.getId();
			int n = Integer.valueOf(fxId.substring(fxId.length() - 1, fxId.length()));
			int i = Integer.valueOf(fxId.substring(fxId.length() - 2, fxId.length() - 1));
			if (spiel.get(i, n) == ' ' && spiel.get(i, n) != 'O') {
				spiel.set(i, n, 'X');
				if (spiel.random() != null) {
					String[] rowCol = spiel.random().split(",");
					spiel.set(Integer.valueOf(rowCol[0]), Integer.valueOf(rowCol[1]), 'O');
				}
			}
		}
		gitterAktualisieren();
	}
}