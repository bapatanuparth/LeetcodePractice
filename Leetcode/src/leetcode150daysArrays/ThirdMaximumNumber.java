package leetcode150daysArrays;

//Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

public class ThirdMaximumNumber {

	public int thirdMax(int[] nums) {
		long max = Long.MIN_VALUE, secmax = Long.MIN_VALUE, thirdmax = Long.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > max) {
				thirdmax = secmax;
				secmax = max;
				max = nums[i];
			} else if (nums[i] > secmax && nums[i] != max) {
				thirdmax = secmax;
				secmax = nums[i];
			} else if (nums[i] > thirdmax && nums[i] != max && nums[i] != secmax) {
				thirdmax = nums[i];
			}
		}
		return thirdmax == Long.MIN_VALUE ? (int) max : (int) thirdmax;
	}
}
