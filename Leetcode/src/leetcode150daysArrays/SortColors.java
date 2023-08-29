package leetcode150daysArrays;

//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//You must solve this problem without using the library's sort function.

public class SortColors {
	public void sortColors(int[] nums) {
		int zeros = 0, ones = 0, twos = 0;
		for (int i : nums) {
			if (i == 0)
				zeros++;
			else if (i == 1)
				ones++;
			else if (i == 2)
				twos++;
		}
		for (int i = 0; i < nums.length; i++) {
			if (zeros > 0) {
				nums[i] = 0;
				zeros--;
			} else if (ones > 0) {
				nums[i] = 1;
				ones--;
			} else {
				nums[i] = 2;
				twos--;
			}
		}

	}

}
