package leetcode150daysGreedy;

//Given an unsorted integer array nums, return the smallest missing positive integer.
//
//You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

public class FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		int n = nums.length;
		for (int i = 0; i < nums.length;) {
			int correct = nums[i] - 1;
			if (nums[i] > 0 && nums[i] < nums.length && nums[correct] != nums[i]) {
				swap(nums, i, correct);
			} else
				i++;
		}

		for (int ind = 0; ind < nums.length; ind++) {
			if (nums[ind] != ind + 1)
				return ind + 1;
		}

		return nums.length + 1;
	}

	void swap(int nums[], int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
