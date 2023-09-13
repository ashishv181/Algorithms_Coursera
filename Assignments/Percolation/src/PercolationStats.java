import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
	private static final double CONFIDENCE_95 = 1.96;
	private Percolation percolation;
	private double[] openSitesArr;

	// perform independent trials on an n-by-n grid
	public PercolationStats(int n, int trials) {
		if (n <= 0)
			throw new IllegalArgumentException("n <= 0");
		openSitesArr = new double[trials];
		int count = 1;
		while (count <= trials) {
			percolation = new Percolation(n);
			while (!percolation.percolates()) {
				int randomRow = (int) StdRandom.uniformDouble(1, n + 1);
				int randomCol = (int) StdRandom.uniformDouble(1, n + 1);
				percolation.open(randomRow, randomCol);
			}
			openSitesArr[count - 1] = 1.0 * percolation.numberOfOpenSites() / (n * n);
			count++;
		}
	}

	// sample mean of percolation threshold
	public double mean() {
		return StdStats.mean(openSitesArr);
	}

	// sample standard deviation of percolation threshold
	public double stddev() {
		return StdStats.stddev(openSitesArr);
	}

	// low endpoint of 95% confidence interval
	public double confidenceLo() {
		double sqrtTrials = Math.sqrt(openSitesArr.length);
		return (mean() - (CONFIDENCE_95 * stddev()) / sqrtTrials);
	}

	// high endpoint of 95% confidence interval
	public double confidenceHi() {
		double sqrtTrials = Math.sqrt(openSitesArr.length);
		return (mean() + (CONFIDENCE_95 * stddev()) / sqrtTrials);
	}

	private void printOutput() {
		StdOut.println("mean                    = " + this.mean());
		StdOut.println("stddev                  = " + this.stddev());
		StdOut.println("95% confidence interval = [" + this.confidenceLo() + ", " + this.confidenceHi() + "]");
	}

	// test client (see below)
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);

		PercolationStats pStats = new PercolationStats(n, trials);
		pStats.printOutput();
	}
}