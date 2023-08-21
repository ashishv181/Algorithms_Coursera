package week1.unionFind;

public class QuickFind extends UF {

	/**
	 * Initializes the {@code array} with the size provided by the client.
	 * 
	 */
	public QuickFind(int N) {
		super(N);
	}

	/**
	 * Checks if the two points are connected or not.
	 * 
	 * @return {@code true} if the two points are connected, {@code false} if not
	 *         connected
	 */
	@Override
	boolean connected(int p, int q) {
		if (arr[p] == arr[q]) {
			System.out.println("true");
			return true;
		}
		System.out.println("false");
		return false;
	}

	/**
	 * it iterates through the whole array and checks if any element is connected. i.e. has the same values as the index of {@code p}.
	 * If the values are the same, the value of index {@code q}, is put over all these values.
	 * It thus makes all previously connected elements have the same values as the new connected element.
	 * 
	 */
	@Override
	void union(int p, int q) {
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == arr[p]) {
				arr[i] = arr[q];
			}
		}

	}

}
