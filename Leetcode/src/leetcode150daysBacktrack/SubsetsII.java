package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given an integer array nums that may contain duplicates, return all possible 
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		dfs(nums, 0, temp, res);
		return res;
	}

	void dfs(int[] nums, int start, List<Integer> temp, List<List<Integer>> res) {

		res.add(new ArrayList<>(temp));

		for (int i = start; i < nums.length; i++) {
			if (i != start && nums[i] == nums[i - 1])
				continue;
			temp.add(nums[i]);
			dfs(nums, i + 1, temp, res);
			temp.remove(temp.size() - 1);
		}
	}

}
