package leetcode150daysArrays;

//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//
//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//
//Return k after placing the final result in the first k slots of nums.
//
//Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
//
//Custom Judge:
//
//The judge will test your solution with the following code:

public class RemoveDuplicatesFromSortedArrayII {

	public int removeDuplicates(int[] nums) {
		int count = 1;
		int k = nums.length;
		// J loop to Enter values According to condition
		int j = 1;
		// we start to look from 1 where duplicates might start occuring from
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
				// If Duplicates less than 3 than add values to j position
				if (count <= 2) {
					nums[j] = nums[i];
					j++;
				}
			} else {
				// Non duplicate Element so reset counter and add value at j position
				count = 1;
				nums[j] = nums[i];
				j++;
			}
		}
		return j;
	}

}