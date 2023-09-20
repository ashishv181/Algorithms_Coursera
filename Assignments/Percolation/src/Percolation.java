import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private boolean[][] perArray;
	private int numberOfOpenSites;
	private WeightedQuickUnionUF uf;

	// creates n-by-n grid, with all sites initially blocked
	public Percolation(int n) {
		if (n <= 0)
			throw new IllegalArgumentException("n <= 0");
		uf = new WeightedQuickUnionUF((n * n) + 2); // initializing array of wighted union class with extra two cell
													// blocks
		perArray = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				perArray[i][j] = false; // false represents blocked sites
			}
		}
	}

	// opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		if (row < 1 || row > perArray.length)
			throw new IllegalArgumentException("row < or > 0");
		if (col < 1 || col > perArray.length)
			throw new IllegalArgumentException("col < or > 0");
		if (!isOpen(row, col)) {
			perArray[row-1][col-1] = true;
			this.numberOfOpenSites++;

			// top
			if (row != 1) {
				if (isOpen(row - 1, col)) {
					int topCell = getSingleCellNumber(row - 1, col);
					int currCell = getSingleCellNumber(row, col);
					uf.union(topCell, currCell);
				}
			} else {
				int currCell = getSingleCellNumber(row, col);
				uf.union(0, currCell);
			}

			// bottom
			if (row != perArray.length) {
				if (isOpen(row + 1, col)) {
					int bottomCell = getSingleCellNumber(row + 1, col);
					int currCell = getSingleCellNumber(row, col);
					uf.union(currCell, bottomCell);
				}
			} else {
				int currCell = getSingleCellNumber(row, col);
				int n = perArray.length;
				int lastCell = (n * n) + 1;
				uf.union(currCell, lastCell);
			}

			// left
			if (col != 1) {
				if (isOpen(row, col - 1)) {
					int leftCell = getSingleCellNumber(row, col - 1);
					int currCell = getSingleCellNumber(row, col);
					uf.union(leftCell, currCell);
				}
			}
			// right
			if (col != perArray.length) {
				if (isOpen(row, col + 1)) {
					int rightCell = getSingleCellNumber(row, col + 1);
					int currCell = getSingleCellNumber(row, col);
					uf.union(currCell, rightCell);
				}
			}
		}
	}

	private int getSingleCellNumber(int row, int col) {
		int arrRow = row - 1;
		int arrCol = col - 1;
		return arrRow * perArray.length + arrCol + 1;
	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		if (row < 1 || row > perArray.length)
			throw new IllegalArgumentException("row < or > 0");
		if (col < 1 || col > perArray.length)
			throw new IllegalArgumentException("col < or > 0");
		return perArray[row -1][col -1];
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
		if (row < 1 || row > perArray.length)
			throw new IllegalArgumentException("row < or > 0");
		if (col < 1 || col > perArray.length)
			throw new IllegalArgumentException("col < or > 0");
		int currCell = getSingleCellNumber(row, col);
		return uf.find(0) == uf.find(currCell);
//		return uf.connected(0, currCell);
	}

	// returns the number of open sites
	public int numberOfOpenSites() {
		return this.numberOfOpenSites;
	}

	// does the system percolate?
	public boolean percolates() {
		int n = perArray.length;
		int lastCell = (n * n) + 1;
		return uf.find(0) == uf.find(lastCell);
//		return uf.connected(0, lastCell);
	}

	// test client (optional)
	public static void main(String[] args) {

	}
}
