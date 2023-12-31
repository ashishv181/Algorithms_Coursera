import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
	public static void main(String[] args) {
		String champion = null;
		int index = 1;
		while (!StdIn.isEmpty()) {
			String s = StdIn.readString();
			double p = (double) 1 / index;
			if (StdRandom.bernoulli(p)) {
				champion = s;
			}
			index++;
		}
		System.out.println(champion);
	}
}
