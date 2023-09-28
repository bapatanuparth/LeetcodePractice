package leetcode150daysGreedy;

//Given an integer array nums, find a 
//subarray
// that has the largest product, and return the product.
//
//The test cases are generated so that the answer will fit in a 32-bit integer.

public class MaxProductSubarray {

	public int maxProduct(int[] nums) {
		int maxpos = nums[0], maxneg = nums[0];

		int prod = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int neg = maxneg * nums[i];
			int pos = maxpos * nums[i];
			maxpos = Math.max(Math.max(neg, pos), nums[i]);
			maxneg = Math.min(Math.min(neg, pos), nums[i]);
			prod = Math.max(prod, Math.max(maxpos, maxneg));
		}

		return prod;
	}

}
