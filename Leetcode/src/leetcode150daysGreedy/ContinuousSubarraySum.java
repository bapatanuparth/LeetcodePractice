package leetcode150daysGreedy;

import java.util.HashMap;
import java.util.Map;

//Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
//
//A good subarray is a subarray where:
//
//its length is at least two, and
//the sum of the elements of the subarray is a multiple of k.
//Note that:
//
//A subarray is a contiguous part of the array.
//An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.

public class ContinuousSubarraySum {

	public boolean checkSubarraySum(int[] nums, int k) {
		if (k == 0)
			return false;
		if (nums.length < 2)
			return false;
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum % k == 0 && i > 0)
				return true;

			if (map.containsKey(sum % k)) {
				if (i - map.get(sum % k) >= 2)
					return true;
			} else
				map.put(sum % k, i);
		}

		return false;
	}

}
