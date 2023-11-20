package leetcode150daysHash;

import java.util.HashMap;
import java.util.Map;

//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//A good array is an array where the number of different integers in that array is exactly k.
//
//For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
//A subarray is a contiguous part of an array.

public class SubarraysWithKDifferentIntegers {
	public int subarraysWithKDistinct(int[] nums, int k) {
		return subarray(nums, k) - subarray(nums, k - 1);
	}

	public int subarray(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int left = 0, count = 0;
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			while (map.size() > k) {
				map.put(nums[left], map.get(nums[left]) - 1);
				if (map.get(nums[left]) == 0)
					map.remove(nums[left]);
				left++;
			}
			count += i - left + 1;

		}
		return count;
	}

}
