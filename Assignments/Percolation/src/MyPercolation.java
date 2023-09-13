import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Percolation {

	int[][] perArray;
	int numberOfOpenSites;
	MyWeightedQuickUnion uf;

	// creates n-by-n grid, with all sites initially blocked
	public Percolation(int n) {
		uf = new MyWeightedQuickUnion((n * n) + 2); // initializing array of wighted union class with extra two cell
													// blocks
		perArray = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				perArray[i][j] = 0; // 0 represents blocked sites
			}
		}
	}

	// opens the site (row, col) if it is not open already
	public void open(int row, int col) {
		int arrRow = row - 1;
		int arrCol = col - 1;
		if (!isOpen(arrRow, arrCol)) {
			perArray[arrRow][arrCol] = 1;
			this.numberOfOpenSites++;

			// top
			if (arrRow != 0) {
				if (isOpen(arrRow - 1, arrCol)) {
					int topCell = getSingleCellNumber(row - 1, col);
					int currCell = getSingleCellNumber(row, col);
					uf.union(topCell, currCell);
				}
			} else {
				int currCell = getSingleCellNumber(row, col);
				uf.union(0, currCell);
			}

			// bottom
			if (arrRow != perArray.length - 1) {
				if (isOpen(arrRow + 1, arrCol)) {
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
			if (arrCol != 0) {
				if (isOpen(arrRow, arrCol - 1)) {
					int leftCell = getSingleCellNumber(row, col - 1);
					int currCell = getSingleCellNumber(row, col);
					uf.union(leftCell, currCell);
				}
			}
			// right
			if (arrCol != perArray.length - 1) {
				if (isOpen(arrRow, arrCol + 1)) {
					int rightCell = getSingleCellNumber(row, col + 1);
					int currCell = getSingleCellNumber(row, col);
					uf.union(currCell, rightCell);
				}
			}
		}
	}

	private int getSingleCellNumber(int row, int col) {
		int arrRow = row -1;
		int arrCol = col-1;
		return arrRow * perArray.length + arrCol + 1;
	}

	// is the site (row, col) open?
	public boolean isOpen(int row, int col) {
		return perArray[row][col] == 1;
	}

	// is the site (row, col) full?
	public boolean isFull(int row, int col) {
		int currCell = getSingleCellNumber(row, col);
		return uf.connnected(0, currCell);
	}

	// returns the number of open sites
	public int numberOfOpenSites() {
		return this.numberOfOpenSites;
	}

	// does the system percolate?
	public boolean percolates() {
		int n = perArray.length;
		int lastCell = (n * n) + 1;
		return uf.connnected(0, lastCell);
	}
	
	public void printPerCoArr() {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
		for (int i = 0; i < perArray.length; i++) {
			for (int j = 0; j < perArray.length; j++) {
				System.out.print(perArray[i][j] + " ");
			}
			System.out.println();
		}
	}

	// test client (optional)
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of rows in array : ");
		int n = Integer.parseInt(reader.readLine());
		Percolation perco = new Percolation(n);
		perco.uf.printArray();
		perco.printPerCoArr();
		
		perco.open(1, 1);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
		perco.open(1, 2);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
//		perco.open(2, 2);
//		perco.uf.printArray();
//		perco.printPerCoArr();
//		System.out.println(perco.percolates());
		perco.open(3, 1);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
		perco.open(3, 3);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
		perco.open(2, 3);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
		perco.open(3, 2);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
		perco.open(1, 3);
		perco.uf.printArray();
		perco.printPerCoArr();
		System.out.println(perco.percolates());
	}
}
