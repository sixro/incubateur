package gameoflife.core;

import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void underpopulation() {
		Board board = new Board(1,1);
		board.setCellAlive(0,0);
		
		board.next();
		
		assertFalse(board.isCellAlive(0,0));
	}

	@Test
	public void overpopulation() {
		Board board = new Board(3,3);
		board.setAllCellAlive();
		
		board.next();
		
		assertFalse(board.isCellAlive(1,1));
	}

	@Test
	public void unchanged_for_2_neighbours() {
		Board board = new Board(2,2);
		board.setCellAlive(0,0);
		board.setCellAlive(0,1);
		board.setCellAlive(1,0);

		board.next();
		
		assertTrue(board.isCellAlive(0,0));
	}

	@Test
	public void unchanged_for_3_neighbours() {
		Board board = new Board(2,2);
		board.setCellAlive(0,0);
		board.setCellAlive(0,1);
		board.setCellAlive(1,0);
		board.setCellAlive(1,1);

		board.next();
		
		assertTrue(board.isCellAlive(0,0));
	}

	@Test
	public void back_to_life() {
		Board board = new Board(2,2);
		board.setCellAlive(0,1);
		board.setCellAlive(1,0);

		board.next();
		
		assertTrue(board.isCellAlive(0,0));
	}

}
