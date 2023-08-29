package leetcode150daysArrays;

//You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
//
//We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
//
//Return the largest number of chunks we can make to sort the array.

public class MaxChunksToBeSorted {
	public int maxChunksToSorted(int[] arr) {
		int chunks = 0;
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if (max == i) {
				chunks++;
				max = -1;
			}
		}

		return chunks;
	}
}
