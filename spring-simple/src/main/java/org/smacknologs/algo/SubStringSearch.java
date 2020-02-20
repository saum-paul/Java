package org.smacknologs.algo;

public class SubStringSearch {

	public static void main(String[] args) {

		String key = "abcxab";
		String target = "abcabcxab";

		System.out.println(basicSearchSubString(key, target));
	}

	private static int basicSearchSubString(String key,
			String target) {
		
		if (key.length() == 0 || target.length() == 0
				|| key.length() > target.length())
			return -1;

		int i = 0;
		int j = 0;
		int startingIndex = -1;

		while (i < target.length() && j < key.length()) {
			if (key.charAt(j) == target.charAt(i)) {
				if (j == 0)
					startingIndex = i;
				j++;
				i++;
				if (j == key.length())
					System.out.println("Found");
			} else {
				i++;
				startingIndex = -1;
				j = 0;
			}
		}

		return startingIndex;
	}

}
