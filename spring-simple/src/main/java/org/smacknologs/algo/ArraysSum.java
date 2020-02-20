package org.smacknologs.algo;

import java.util.List;

public class ArraysSum {

	public static int minimumMoves(List<Integer> a,
			List<Integer> m) {

		if (a.size() != m.size())
			return -1;
		int moves = 0;
		int diff;
		for (int i = 0; i < a.size(); i++) {
			diff = diffOfDigits(a.get(i), m.get(i));
			if (diff == -1)
				return -1;
			moves += diff;
		}
		return moves;

	}

	private static int diffOfDigits(int num1, int num2) {

		String num1Str = String.valueOf(num1);
		String num2Str = String.valueOf(num2);

		if (num1Str.length() != num2Str.length())
			return -1;

		int count = 0;
		for (int i = 0; i < num2Str.length(); i++) {
			count += Math
					.abs(num2Str.charAt(i) - num2Str.charAt(i));
		}
		return count;
	}
}
