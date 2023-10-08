package leetcode150daysGreedy;

//You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
//
//Return true if you can reach the last index, or false otherwise.

public class JumpGame {

	public boolean canJump(int[] nums) {
		if (nums.length == 1)
			return true;
		int i = 0, end = nums[i];
		int max = 0;
		while (i < nums.length) {
			while (i < nums.length && i <= end) {
				max = Math.max(max, i + nums[i]);
				i++;
			}
			if (end >= nums.length - 1)
				return true;
			if (end == max)
				return false;
			end = Math.max(end, max);
		}
		return false;
	}

}
