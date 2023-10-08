package leetcode150daysDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
//
//answer[i] % answer[j] == 0, or
//answer[j] % answer[i] == 0
//If there are multiple solutions, return any of them.

public class LargestDivisibleSubset {

	public List<Integer> largestDivisibleSubset(int[] nums) {
		List<Integer> res = new ArrayList<>();
		List<Integer>[] map = new List[nums.length];

		for (int i = 0; i < nums.length; i++) {
			map[i] = new ArrayList<>();
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length; i++) {

			List<Integer> largest = new ArrayList<>();
			for (int j = i - 1; j >= 0; j--) {
				if (nums[i] % nums[j] == 0) {
					if (largest.size() < map[j].size())
						largest = map[j];
				}
			}
			map[i].add(nums[i]);
			map[i].addAll(largest);
			if (res.size() < map[i].size())
				res = map[i];
		}

		return res;
	}
}
