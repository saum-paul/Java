package org.smacknologs.algo;

import java.util.Scanner;

public class MergeSort {

	public void sort(int[] array) {
		array = new int[] { 3, 6, 1, 4 };
		int[] temp = new int[array.length];
		sort(array, temp, 0, array.length - 1);
		for (int i : array) {
			System.out.print(i);
		}
	}

	private void sort(int[] array, int[] temp,
			int startIndex, int endIndex) {

		int nItems = endIndex - startIndex + 1;
		if (nItems == 1)
			return;

		int middleIndex = (endIndex + startIndex) / 2;
		sort(array, temp, startIndex, middleIndex);
		sort(array, temp, middleIndex + 1, endIndex);
		merge(array, temp, startIndex, middleIndex + 1,
				endIndex);

		for (int i : array) {
			System.out.print(i);
		}
	}

	private void merge(int[] array, int[] temp,
			int startIndex, int middleIndex, int endIndex) {
		int nItems = endIndex - startIndex + 1;
		System.out.println(
				"startIndex: " + startIndex + ", middleIndex: "
						+ middleIndex + ", endIndex: " + endIndex
						+ ", nItems: " + nItems);

		int leftEnd = middleIndex - 1;
		int tempIndex = startIndex;
		while ((startIndex <= leftEnd)
				&& (middleIndex <= endIndex)) {
			if (array[startIndex] <= array[middleIndex]) {
				temp[tempIndex] = array[startIndex];
				tempIndex++;
				startIndex++;
			} else {
				temp[tempIndex] = array[middleIndex];
				tempIndex++;
				middleIndex++;
			}
		}
		if (startIndex <= leftEnd) {
			while (startIndex <= leftEnd) {
				temp[tempIndex] = array[startIndex];
				tempIndex++;
				startIndex++;
			}
		} else {
			while (middleIndex <= endIndex) {
				temp[tempIndex] = array[middleIndex];
				tempIndex++;
				middleIndex++;
			}
		}

		for (int i = 0; i < nItems - 1; i++) {
			array[endIndex] = temp[endIndex];
			endIndex = endIndex - 1;
		}

	}
}
