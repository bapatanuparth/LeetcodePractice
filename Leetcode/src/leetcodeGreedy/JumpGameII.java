package leetcodeGreedy;

import java.util.Arrays;

//Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
//Each element in the array represents your maximum jump length at that position.
//
//Your goal is to reach the last index in the minimum number of jumps.
//
//You can assume that you can always reach the last index.

//Input: nums = [2,3,1,1,4]
//Output: 2
public class JumpGameII {

	// my solution using Tabulation
	public int jumpTab(int[] nums) {
		// in array arr [] save the lowest number of jumps at each position
		// return the lowest jumps at arr[0]
		int arr[] = new int[nums.length];
		Arrays.fill(arr, Integer.MAX_VALUE - 1);

		arr[nums.length - 1] = 0;

		for (int i = nums.length - 1; i >= 0; i--) {

			for (int val = nums[i]; val >= 1; val--) { // for each element of the array value, check at each jump
														// location if a lower number of jumps can be made from val

				if ((i + val) < nums.length) {
					arr[i] = Math.min(arr[i], 1 + arr[i + val]); // change the value of arr[i] to the lowest jump number
																	// required
				}

			}
		}

		return arr[0];

	}

	// my solution using dynamic programming
	int jumps = 0;

	public int jump(int[] nums) {
		int memo[] = new int[nums.length];
		Arrays.fill(memo, -1);
		return countJumps(nums, nums[0], 0, memo);
	}

	int countJumps(int[] nums, int val, int ind, int memo[]) {
		if (ind == nums.length - 1) // if we reach the end return 0
			return 0;
		if (memo[ind] != -1)
			return memo[ind];

		int x = Integer.MAX_VALUE - 1; // to keep track of minimum value of jumps

		for (int i = val; i >= 1; i--) {
			if ((i + ind) < nums.length)
				x = Math.min(x, 1 + countJumps(nums, nums[i + ind], i + ind, memo)); // iterate over all possible jumps
																						// that we can make and keep
																						// track of minimum
		}

		memo[ind] = x;
		return memo[ind];

	}
}
