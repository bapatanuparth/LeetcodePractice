package leetcode150daysSlidingWindow;

//Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

public class MaxConsecutiveOnes {

	public int longestOnes(int[] nums, int k) {
		int left = 0, right = 0;
		int n = 0, max = 0;
		while (right < nums.length) {
			if (n == k && nums[right] == 0) {
				if (nums[left] == 0)
					n--;
				left++;

			} else {
				if (nums[right] == 0) {
					n++;
				}
				max = Math.max(max, right - left + 1);
				right++;
			}
		}

		return max;
	}

}
