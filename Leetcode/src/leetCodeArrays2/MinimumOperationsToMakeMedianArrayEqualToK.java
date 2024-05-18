package leetCodeArrays2;

import java.util.Arrays;

//You are given an integer array nums and a non-negative integer k. In one operation, you can increase or decrease any element by 1.
//
//Return the minimum number of operations needed to make the median of nums equal to k.
//
//The median of an array is defined as the middle element of the array when it is sorted in non-decreasing order. If there are two choices for a median, the larger of the two values is taken.

public class MinimumOperationsToMakeMedianArrayEqualToK {

	public long minOperationsToMakeMedianK(int[] nums, int k) {
		Arrays.sort(nums);
		int med = 0;

		if (nums.length % 2 == 0) {
			if (nums[nums.length / 2] >= nums[(nums.length / 2) - 1])
				med = nums.length / 2;
			else
				med = nums.length / 2 - 1;
		} else
			med = nums.length / 2;

		if (k == nums[med]) {
			return 0;
		} else if (k > nums[med]) {
			int m = med;
			long val = 0;
			while (m < nums.length && nums[m] < k) {
				val += k - nums[m];
				m++;
			}
			return val;
		} else {
			int m = med;
			long val = 0;
			while (m >= 0 && nums[m] > k) {
				val += nums[m] - k;
				m--;
			}
			return val;
		}
	}

}
