package week2.Stacks;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * This is an automatic resizing array stack which will double when the maximum
 * length of the array has been reached and reduce to half when only a quarter
 * of the length of the array is filled
 */

public class MyStringArrayStack {
	private String[] s;
	private int size = 0;

	private Predicate<Integer> checkIfFull = t -> {
		int len = s.length;
		return len == t;
	};
	private Predicate<Integer> checkIfQuarter = t -> t == (s.length / 4);

	public MyStringArrayStack() {
		s = new String[5];
	}

	public void push(String input) {
		if (checkIfFull.test(size)) {
			resizeArray(2 * size);
		}
		s[size++] = input;
	}

	public void pop() {
		s[--size] = null;
		if (checkIfQuarter.test(size)) {
			reduceArray(s.length / 2);
		}
	}

	public String get() {
		return s[size - 1];
	}

	private void resizeArray(int newSize) {
		String[] copy = new String[newSize];
		for (int i = 0; i < s.length; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}

	private void reduceArray(int newSize) {
		String[] copy = new String[newSize];
		int i = 0;
		while (s[i] != null) {
			copy[i] = s[i];
			i++;
		}
		s = copy;
	}

	public void printArr() {
		System.out.println(Arrays.toString(s));
	}

}
