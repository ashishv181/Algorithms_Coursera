package week1.binarySearch;

public class BinarySearch {
	private static int[] arr = new int[2];
	private int loopCount = 0;
	
	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		b.fillArray();
		for(int i = 0; i < 10; i ++) {
			int eleToSearch = (int)(Math.random() * 10);
			int pos = b.search(eleToSearch);
//			printArr();
			if(pos == -1) {
				System.out.println("Not Found " + eleToSearch);
			}else {
				System.out.println(eleToSearch + " Found at pos : \t" + pos + " after loops : " + b.loopCount);
			}
		}
	}
	
	private void fillArray() {
		for(int i=0; i < arr.length; i++) {
			arr[i] = i+1;
		}
	}
	
	private void printArr() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n--------------------------------------------------------------------------------------------------");
	}
	
	private int search(int ele) {
		int lo = 0;
		int hi = arr.length-1;
		int mid = 0;
		loopCount = 0;
		while (lo <= hi) {
			++loopCount;
//			mid = lo + (hi - lo) / 2;
			mid = hi + lo / 2;
			if(arr[mid] == ele) return mid;
			if(arr[mid] < ele) {
				lo = mid + 1;
			}else {
				hi = mid - 1;
			}
		}
		return -1;
	}
}
