package leetcodeHash;
//You are given a 0-indexed integer array nums. In one operation, you may do the following:

//
//Choose two integers in nums that are equal.
//Remove both integers from nums, forming a pair.
//The operation is done on nums as many times as possible.
//
//Return a 0-indexed integer array answer of size 2 where answer[0] is the number of pairs that are formed and answer[1] is the number of leftover integers in nums after doing the operation as many times as possible.

public class MaximumNumberPairsArray {

	public int[] numberOfPairs(int[] nums) {
		int[] arr = new int[101];

		for (int i : nums) {
			arr[i]++;
		}

		int count = 0;
		int leftover = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0)
				continue;
			count += arr[i] / 2;
			leftover += arr[i] % 2;
		}

		return new int[] { count, leftover };
	}
}
