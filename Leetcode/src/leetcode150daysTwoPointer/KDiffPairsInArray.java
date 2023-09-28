package leetcode150daysTwoPointer;

import java.util.Arrays;

//Given an array of integers nums and an integer k, return the number of unique k-diff pairs in the array.
//
//A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
//
//0 <= i, j < nums.length
//i != j
//|nums[i] - nums[j]| == k
//Notice that |val| denotes the absolute value of val.

public class KDiffPairsInArray {

	public int findPairs(int[] nums, int k) {
		Arrays.sort(nums);
		int left = 0, right = 0, count = 0;
		while (left < nums.length && right < nums.length) {
			if (left > 0 && nums[left] == nums[left - 1]) {
				left++;
				continue;
			}

			right = left + 1;
			for (; right < nums.length; right++) {
				int diff = Math.abs(nums[right] - nums[left]);
				if (diff == k) {
					count++;
					break;
				} else if (diff > k)
					break;
			}

			left++;
		}
		return count;
	}

}
