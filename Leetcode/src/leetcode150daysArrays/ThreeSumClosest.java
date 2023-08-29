package leetcode150daysArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {

		List<Integer> sums = new ArrayList<>();

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1, right = nums.length - 1;
			int val = twosum(nums, target - nums[i], left, right);

			sums.add(val + nums[i]);
		}

		int res = 0;
		int diff = Integer.MAX_VALUE;

		for (int sum : sums) {
			if (Math.abs(target - sum) < diff) {
				res = sum;
				diff = Math.abs(target - sum);
			}
		}

		return res;
	}

	int twosum(int[] nums, int target, int left, int right) {
		int res = 0;
		int diff = Integer.MAX_VALUE;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target)
				return target;
			else if (sum < target) {
				if (Math.abs(sum - target) < diff) {
					res = sum;
					diff = Math.abs(sum - target);
				}
				left++;
			} else {
				if (Math.abs(sum - target) < diff) {
					res = sum;
					diff = Math.abs(sum - target);
				}
				right--;
			}
		}

		return res;
	}
}
