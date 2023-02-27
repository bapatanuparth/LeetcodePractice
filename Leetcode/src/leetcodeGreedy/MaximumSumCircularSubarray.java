package leetcodeGreedy;

//Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
//
//A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
//
//A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

public class MaximumSumCircularSubarray {

	public int maxSubarraySumCircular(int[] nums) {
		int currmax = 0, maxsum = nums[0], currmin = 0, minsum = nums[0], total = 0;

		// two cases, either max sum subarray can lie in the middle
		// or it can lie as some part of head and sum part of tail.
		// second case is equivalent to, total sum - min subarray sum in the middle part
		for (int i : nums) {
			currmax = Math.max(currmax + i, i);
			maxsum = Math.max(currmax, maxsum);// calculate max sum subarray
			currmin = Math.min(currmin + i, i);
			minsum = Math.min(minsum, currmin); // calculate min sum subarray
			total += i; // calculate total sum
		}
		// If all numbers are negative, maxSum = max(A) and minSum = sum(A).
		// In this case, max(maxSum, total - minSum) = 0, which means the sum of an
		// empty subarray.
		// According to the deacription, We need to return the max(A), instead of sum of
		// am empty subarray.
		// So we return the maxSum to handle this corner case.
		return maxsum > 0 ? Math.max(maxsum, total - minsum) : maxsum; // if all elements are negative

	}
}
