package leetcode150daysArrays;

//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
//
//Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
//
//Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
//Return k.
//Custom Judge:
//
//The judge will test your solution with the following code:

public class RemoveDuplicatesFromSortedArray {

	public int removeDuplicates(int[] nums) {
		int left = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				while (i < nums.length && nums[i] == nums[i - 1])
					i++;
				if (i < nums.length) {
					nums[left] = nums[i];
					left++;
				}

			} else {
				nums[left] = nums[i];
				left++;
			}
		}

		return left;
	}

}
