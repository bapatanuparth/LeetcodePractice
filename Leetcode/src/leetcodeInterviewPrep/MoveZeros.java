package leetcodeInterviewPrep;
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//
//Note that you must do this in-place without making a copy of the array.

public class MoveZeros {
	public void moveZeroes(int[] nums) {
		int start = 0;
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[start] = nums[i];
				start++;
			} else {
				count++;
			}
		}

		while (count > 0) {
			nums[start] = 0;
			start++;
			count--;
		}
	}

}
