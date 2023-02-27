package leetcodeGreedy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//You are given an integer array nums. In one move, you can pick an index i where 0 <= i < nums.length and increment nums[i] by 1.
//
//Return the minimum number of moves to make every value in nums unique.
//
//The test cases are generated so that the answer fits in a 32-bit integer.

public class MinIncrementToMakeArrayUnique {

	// without using set
	class Solution {
		public int minIncrementForUnique(int[] A) {
			if (A.length == 0)
				return 0;
			int result = 0;
			Arrays.sort(A);
			int highestTillNow = A[0];

			for (int i = 1; i < A.length; i++) {
				if (A[i] <= highestTillNow) {
					result += (highestTillNow - A[i] + 1);
					highestTillNow++;
				} else
					highestTillNow = A[i];
			}
			return result;
		}
	}

	public int minIncrementForUnique(int[] nums) {
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums);

		int max = nums[0];
		set.add(nums[0]);
		int count = 0;

		for (int i = 1; i < nums.length; i++) {
			// this helps when there are common numbers like 1 1 1 1 2 2
			if (set.contains(nums[i])) {
				// keep a max to know where we have reached till now on incremeneting
				count += max + 1 - nums[i]; // directly update the count value by subtracting that number from nums[i].
											// This is as good as incrementing that number one by one till it becomes a
											// unique number not present in array
				nums[i] = max + 1; // make nums[i] == max+1 and set new max
				max = max + 1;
			} else {
				max = Math.max(max, nums[i]); // if numbers not common, update the max number seen till now value.
				// as the array is sorted, at each point, we need to view the max number viewed
				// till that element
			}
			set.add(nums[i]);
		}

		return count;
	}

}
