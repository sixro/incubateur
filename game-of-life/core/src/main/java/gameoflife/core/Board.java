package gameoflife.core;

public class Board {

	private final int width;
	private final int height;
	private final int[][] cells;
	
	public Board(int width, int height) {
		this.width = width;
		this.height = height;
		this.cells = new int[height][width];
	}

	public void setCellAlive(int x, int y) {
		cells[y][x] = 1;
	}

	public void setAllCellAlive() {
		for (int y =0; y < height; y++) {
			for (int x =0; x < width; x++)
				setCellAlive(x, y);
		}
	}

	public void next() {
		int[][] newcells = new int[height][width];
		System.arraycopy(cells, 0, newcells, 0, cells.length);
		
		for (int y = 0; y < height; y++) {
			for (int x =0; x < width; x++) {
				if (isCellAlive(x, y)) {
					int a = aliveNeighbours(x, y);
					if (a < 2 || a > 3)
						newcells[y][x] = 0;
				}
				else {
					if (aliveNeighbours(x, y) == 2)
						newcells[y][x] = 1;
				}
				
			}
			
		}
		
		System.arraycopy(newcells, 0, cells, 0, cells.length);		
	}

	private int aliveNeighbours(int x, int y) {
		int count = 0;
		if (isCellAlive(x-1, y-1)) count++;
		if (isCellAlive(x, y-1)) count++;
		if (isCellAlive(x+1, y-1)) count++;

		if (isCellAlive(x-1, y+1)) count++;
		if (isCellAlive(x, y+1)) count++;
		if (isCellAlive(x+1, y+1)) count++;
		
		if (isCellAlive(x-1, y)) count++;
		if (isCellAlive(x+1, y)) count++;
		return count;
	}

	public boolean isCellAlive(int x, int y) {
		if (x < 0 || x > width-1 || y < 0 || y > height-1) 
			return false;
		return cells[y][x] == 1;
	}

}
