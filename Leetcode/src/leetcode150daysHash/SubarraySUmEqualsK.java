package leetcode150daysHash;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
public class SubarraySUmEqualsK {

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		int sum = 0;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k))
				res += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return res;
	}

}
