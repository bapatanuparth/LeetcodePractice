package leetcode150daysArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.

public class ThreeSum {
	class Solution {
		public List<List<Integer>> threeSum(int[] nums) {

			List<List<Integer>> res = new ArrayList<>();
			Arrays.sort(nums);

			for (int i = 0; i < nums.length; i++) {

				if (i == 0 || nums[i] != nums[i - 1]) {
					twoSum(res, nums, i);
				}
			}
			return res;
		}

		void twoSum(List<List<Integer>> res, int[] nums, int i) {
			int lo = i + 1;
			int hi = nums.length - 1;

			while (lo < hi) {
				int sum = nums[i] + nums[lo] + nums[hi];
				if (sum < 0)
					lo++;
				else if (sum > 0)
					hi--;
				else {
					res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
					while (lo < hi && nums[lo] == nums[lo - 1])
						lo++;
				}
			}
		}
	}
}
