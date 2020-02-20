package org.smacknologs.algo;

import java.util.Arrays;

public class LeftShift {

	static int[] rotLeft(int[] a, int d) {
		int newLoc;
		int len = a.length;
		int b[] = new int[len];
		for (int i = 0; i < len; i++) {
			newLoc = (i + len - d) % len;
			b[newLoc] = a[i];
		}
		return b;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };

		System.out.println(Arrays.toString(rotLeft(a, -2)));

	}
}
