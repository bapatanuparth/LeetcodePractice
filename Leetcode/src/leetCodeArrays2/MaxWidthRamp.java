package leetCodeArrays2;

import java.util.Arrays;

//A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
//
//Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.

public class MaxWidthRamp {

	public int maxWidthRamp(int[] nums) {
		int[] first = new int[50001];
		Arrays.fill(first, Integer.MAX_VALUE);

		// first occurrence of every element
		for (int i = 0; i < nums.length; i++) {
			if (first[nums[i]] == Integer.MAX_VALUE)
				first[nums[i]] = i;
		}
		// for each position, save the min possible index of any number <= that number
		for (int i = 1; i < first.length; i++) {
			first[i] = Math.min(first[i - 1], first[i]);
		}

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(i - first[nums[i]], max);
		}

		return max;
	}
}
