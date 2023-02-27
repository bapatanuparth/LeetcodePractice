package leetCodeArrays2;

//You are given a 0-indexed integer array nums of length n.
//
//The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
//
//Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
//
//Note:
//
//The absolute difference of two numbers is the absolute value of their difference.
//The average of n elements is the sum of the n elements divided (integer division) by n.
//The average of 0 elements is considered to be 0.

public class MinAverageDifference {

	// solution without using extra space
	// O(1) space
	public int minimumAverageDifferenceEff(int[] nums) {
		int len = nums.length, res = 0;
		long min = Integer.MAX_VALUE, sum = 0, leftSum = 0, rightSum = 0;
		for (int num : nums)
			sum += num;
		for (int i = 0; i < len; i++) {
			leftSum += nums[i];
			rightSum = sum - leftSum;
			long diff = Math.abs(leftSum / (i + 1) - (len - i == 1 ? 0 : rightSum / (len - i - 1)));
			if (diff < min) {
				min = diff;
				res = i;
			}
		}
		return res;
	}

	public int minimumAverageDifference(int[] nums) {

		// use average sum arrays, store averages till that index from left and right
		// side
		// use that array to find min running average
		int n = nums.length;
		long[] avgleft = new long[nums.length];
		long[] avgright = new long[nums.length];

		long sum = 0, rightsum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			avgleft[i] = sum / (i + 1);

			rightsum += nums[n - i - 1];
			avgright[n - i - 1] = rightsum / (i + 1);
		}

		long min = Integer.MAX_VALUE;
		int minIndex = 0;

		for (int i = 0; i < nums.length - 1; i++) {
			long diff = Math.abs(avgleft[i] - avgright[i + 1]);

			if (diff < min) {
				min = diff;
				minIndex = i;
			}
		}

		// to handle last element
		if (avgleft[n - 1] < min) {
			minIndex = n - 1;
		}
		return minIndex;
	}
}
