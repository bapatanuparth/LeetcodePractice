package leetcode150daysArrays;

//Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
//
//Return any array that satisfies this condition.

public class SortArrayByParity {
	public int[] sortArrayByParity(int[] nums) {
		int left = -1, right = 0;
		for (; right < nums.length; right++) {
			if (nums[right] % 2 == 0) {
				int temp = nums[++left];
				nums[left] = nums[right];
				nums[right] = temp;
			}
		}
		return nums;
	}
}
