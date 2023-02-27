package leetcodeDynamicProgramming;

import java.util.HashSet;
import java.util.Set;

//Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

//Input: nums = [1,5,11,5]
//Output: true

public class PartitionEqualSubset {

	// easiest solution using normal approach to find if any of the numbers of the
	// array can sum to given target
	public boolean canPartitionEff(int[] nums) {

		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % 2 == 1)
			return false;

		int halfsum = sum / 2;

		boolean dp[] = new boolean[halfsum + 1];
		dp[0] = true;

		for (int i = 0; i < nums.length; i++) {

			boolean[] temp = new boolean[halfsum + 1]; // need to use this to avoid concurrent modification
			for (int j = 0; j < dp.length; j++) {

				if (dp[j] == true) {
					temp[j] = true;
					if (nums[i] + j < dp.length)
						temp[j + nums[i]] = true;
				}
			}

			dp = temp;

		}

		return dp[halfsum];

	}

	// different solution using set
	public boolean canPartitionII(int[] nums) {

		Set<Integer> set = new HashSet<>(); // set will store all the sums that we can create
		set.add(0);

		int sum = 0;
		for (int i : nums)
			sum += i;
		if (sum % 2 == 1)
			return false;

		int halfsum = sum / 2;
		for (int i = 0; i < nums.length; i++) {

			Set<Integer> temp = new HashSet<>();

			for (int num : set) {
				int val = num + nums[i];
				if (val == halfsum)
					return true;
				temp.add(val);
				temp.add(num);
			}

			set = temp;
		}

		return false;

	}

	// memo solution easy
	public boolean canPartitionTab(int[] nums) {
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (sum % 2 != 0)
			return false; // if total sum is false, we cannot have 2 subsets with equal sum
		int subsetSum = sum / 2;
		Boolean[][] dp = new Boolean[subsetSum + 1][nums.length];
		return isEqualSum(nums, dp, nums.length - 1, subsetSum);
	}

	public Boolean isEqualSum(int[] nums, Boolean[][] dp, int i, int sum) {
		if (sum == 0) {
			return true;
		}

		if (i < 0 || sum < 0) {
			return false;
		}
		if (dp[sum][i] != null)
			return dp[sum][i];
		Boolean result = isEqualSum(nums, dp, i - 1, sum - nums[i]) || isEqualSum(nums, dp, i - 1, sum);
		dp[sum][i] = result;
		return result;
	}

	// solution with memoization using set
	// we calculate the total sum of all the elements
	// then we one by one using backtracking approach, recursively check for each
	// and every combination
	// if the sum of combination == total sum- sum of combination, we have 2
	// different subsets with equal sum
	public boolean canPartitionMemo(int[] nums) {

		int sum = 0;
		for (int i : nums)
			sum += i;

		Set<Integer> memo = new HashSet<>();
		return canSum(nums, sum, 0, 0, memo);

	}

	boolean canSum(int[] nums, int sum, int curr, int i, Set<Integer> memo) {

		if (sum == curr)
			return true;
		if (memo.contains(sum))
			return false;

		if (sum == 0)
			return false;
		for (; i < nums.length; i++) {
			sum = sum - nums[i];
			curr += nums[i];
			if (!canSum(nums, sum, curr, i + 1, memo))
				memo.add(sum);
			else
				return true;
			curr -= nums[i];
			sum = sum + nums[i];
		}

		return memo.contains(sum);
	}

	// solution without memoization
	public boolean canPartition(int[] nums) {

		int sum = 0;
		for (int i : nums)
			sum += i;

		return canSum(nums, sum, 0, 0);

	}

	boolean canSum(int[] nums, int sum, int curr, int i) {

		if (sum == curr)
			return true;

		if (sum == 0)
			return false;
		for (; i < nums.length; i++) {
			sum = sum - nums[i];
			curr += nums[i];
			if (canSum(nums, sum, curr, i + 1))
				return true;
			curr -= nums[i];
			sum = sum + nums[i];
		}

		return false;
	}
}
