package prog;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ModelTest {

	@Test
	void test() {
		TicTacToeModel tictac = new TicTacToeModel();
		tictac.set(0, 0, 'X');
		tictac.set(1, 0, 'X');
		tictac.set(2, 0, 'X');
		assertEquals('X', tictac.get(0, 0));
		assertEquals('X', tictac.get(1, 0));
		assertEquals('X', tictac.get(2, 0));
		assertEquals('X', tictac.winner());
		assertNotEquals("2,0", tictac.random());
		assertNotEquals("1,0", tictac.random());
	}

	@Test
	void test1() {
		TicTacToeModel tictac = new TicTacToeModel();
		tictac.set(0, 0, 'O');
		tictac.set(1, 0, 'O');
		tictac.set(2, 0, 'O');
		assertEquals('O', tictac.get(0, 0));
		assertEquals('O', tictac.get(1, 0));
		assertEquals('O', tictac.get(2, 0));
		assertEquals('O', tictac.winner());
		assertNotEquals('X', tictac.winner());
		assertNotEquals(' ', tictac.winner());
		assertNotEquals("0,0", tictac.random());
		assertNotEquals("1,0", tictac.random());
	}

	@Test
	void test2() {
		TicTacToeModel tictac = new TicTacToeModel();
		tictac.set(0, 0, 'X');
		tictac.set(1, 1, 'X');
		tictac.set(2, 2, 'X');
		assertEquals('X', tictac.winner());
		assertNotEquals('O', tictac.winner());
		assertNotEquals("2,2", tictac.random());
		assertNotEquals("1,1", tictac.random());
	}

	@Test
	void test3() {
		TicTacToeModel tictac = new TicTacToeModel();
		tictac.set(0, 2, 'O');
		tictac.set(1, 1, 'O');
		tictac.set(2, 0, 'O');
		assertEquals('O', tictac.winner());
		assertNotEquals('X', tictac.winner());
		assertNotEquals(' ', tictac.winner());
		assertNotEquals("0,2", tictac.random());
		assertNotEquals("2,0", tictac.random());
	}

	@Test
	void test4() {
		TicTacToeModel tictac = new TicTacToeModel();
		tictac.set(0, 0, 'O');
		tictac.set(0, 1, 'O');
		tictac.set(0, 2, 'O');
		assertEquals('O', tictac.winner());
		assertNotEquals('X', tictac.winner());
		assertNotEquals(' ', tictac.winner());
		assertNotEquals("0,0", tictac.random());
		assertNotEquals("0,1", tictac.random());
	}
}
