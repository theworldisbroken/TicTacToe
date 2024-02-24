package prog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicTacToeModel {
	private char[][] board = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

	public TicTacToeModel() {

	}

	public void set(int row, int column, char piece) {
		if (board[row][column] == ' ') {
			board[row][column] = piece;
		}
	}

	public char get(int row, int column) {
		return board[row][column];
	}

	public String random() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			for (int n = 0; n < 3; n++) {
				if (get(i, n) == ' ') {
					list.add(String.valueOf(i) + "," + String.valueOf(n));
				}
			}
		}
		Collections.shuffle(list);
		if (!list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	public char winner() {
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
				return board[i][0];
			}
		}
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
				return board[0][i];
			}
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
			return board[0][2];
		}

		return ' ';
	}
}
