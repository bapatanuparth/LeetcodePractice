package leetcode150daysHash;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums, return the number of good pairs.
//
//A pair (i, j) is called good if nums[i] == nums[j] and i < j.

public class NumberOfGoodPairs {

	public int numIdenticalPairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.compute(i, (k, v) -> (v == null) ? 1 : v + 1);
		}

		for (int i : map.keySet()) {
			int temp = map.get(i);
			count += temp * (temp - 1) / 2;
		}
		return count;
	}

}
