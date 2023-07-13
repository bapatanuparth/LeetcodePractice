package leetcodeSlidingWindow;

//Given a binary array nums, you should delete one element from it.
//
//Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.

public class LongestSubarrayOf1sAfterDeletingOneElement {

	public int longestSubarray(int[] nums) {
		int left = 0, right = 0;
		int index = -1, max = 0;
		for (; right < nums.length; right++) {

			if (nums[right] == 0) {
				if (index == -1)
					index = right;
				else {
					left = index + 1;
					index = right;
				}
			}
			max = Math.max(max, right - left);
		}

		return max;
	}

}
