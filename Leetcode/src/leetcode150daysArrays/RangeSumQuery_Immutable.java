package leetcode150daysArrays;

//Given an integer array nums, handle multiple queries of the following type:
//
//Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
//Implement the NumArray class:
//
//NumArray(int[] nums) Initializes the object with the integer array nums.
//int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).

public class RangeSumQuery_Immutable {

	class NumArray {
		int[] presum;

		public NumArray(int[] nums) {
			presum = new int[nums.length];
			presum[0] = nums[0];
			for (int i = 1; i < nums.length; i++) {
				presum[i] = presum[i - 1] + nums[i];
			}
		}

		public int sumRange(int left, int right) {
			return left == 0 ? presum[right] : presum[right] - presum[left - 1];
		}
	}

	/**
	 * Your NumArray object will be instantiated and called as such: NumArray obj =
	 * new NumArray(nums); int param_1 = obj.sumRange(left,right);
	 */

}
