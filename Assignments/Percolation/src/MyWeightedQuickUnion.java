
public class MyWeightedQuickUnion {
	
	private int [] arr;
	private int [] sz;
	
	public MyWeightedQuickUnion(int N) {
		arr = new int[N];
		sz = new int[N];
		while(N > 0) {
			arr[--N] = N;
			sz[N] = 1;
		}
	}
	
	public int find(int index) {
		validate(index);
		while(arr[index] != index) {
			index = arr[index];
		}
		return index;
	}
	
    private void validate(int p) {
        int n = arr.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
        }
    }
    
//    @Deprecated
    public boolean connnected(int p, int q) {
    	return find(p) == find(q);
    }
	
	public void union(int p, int q) {
		int rootP = find(p); 
		int rootQ = find(q);
		
		if (rootP == rootQ)	return;
		
		if(sz[rootP] < sz[rootQ]) {
			arr[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		}else {
			arr[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
		}
	}
	
	public void printArray() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

}
