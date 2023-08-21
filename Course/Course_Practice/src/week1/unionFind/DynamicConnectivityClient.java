package week1.unionFind;

import edu.princeton.cs.algs4.StdIn;

public class DynamicConnectivityClient {

	public static void main(String[] args) {
		int N = StdIn.readInt();
//		QuickFind uf = new QuickFind(N);
//		QuickUnion uf = new QuickUnion(N);
		WeightedQuickUnion uf = new WeightedQuickUnion(N);
		
		while(!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
						
			if(!uf.connected(p,q)) {
				uf.union(p,q);
				uf.printArray();
			}
		}
	}
}

