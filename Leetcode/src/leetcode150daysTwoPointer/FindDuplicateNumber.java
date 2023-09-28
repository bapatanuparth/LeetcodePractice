package leetcode150daysTwoPointer;

//Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.

public class FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int index = 0;
		while (index < nums.length) {
			if (nums[index] < 0)
				return index;
			int newIndex = nums[index];
			nums[index] *= -1;
			index = newIndex;
		}

		return -1;
	}

}
