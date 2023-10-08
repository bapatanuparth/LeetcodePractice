package leetcode150daysDynamicProgramming;

import java.util.Arrays;

//Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

public class PartitionToKEqualSumSubsets {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length)
			return false;
		int total = 0;
		for (int i : nums) {
			total += i;
		}
		if (total % k != 0)
			return false;
		Arrays.sort(nums);
		return check(nums, new boolean[nums.length], 0, nums.length - 1, k, total / k);
	}

	boolean check(int[] nums, boolean visited[], int sum, int index, int round, int target) {
		if (round == 0)
			return true;
		if (sum == target && check(nums, visited, 0, nums.length - 1, round - 1, target)) {
			return true;
		}
		for (int i = index; i >= 0; i--) {
			if (sum + nums[i] <= target && !visited[i]) {
				visited[i] = true;
				if (check(nums, visited, sum + nums[i], i - 1, round, target))
					return true;
				visited[i] = false;
			}
		}

		return false;
	}

}
