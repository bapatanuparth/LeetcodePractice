package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	// use the same algo of sorting for 2sum
	// this time keep each element from starting aside and find 2sum of the
	// remaining elements in the array == 0
	public List<List<Integer>> threeSum(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {

			if (i == 0 || nums[i] != nums[i - 1]) {
				twoSum2(res, nums, i);
			}
		}

		return res;

	}

	void twoSum2(List<List<Integer>> res, int[] nums, int i) {
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
				while (lo < hi && nums[lo] == nums[lo - 1]) {
					lo++;
				}
			}
		}
	}
}
