package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combi(ans, temp, candidates, target, 0, 0);
		return ans;
	}

	void combi(List<List<Integer>> ans, List<Integer> temp, int[] candi, int target, int i, int curr) {
		if (curr == target) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		if (curr > target)
			return;

		for (; i < candi.length; i++) {
			temp.add(candi[i]);
			curr = curr + candi[i];
			combi(ans, temp, candi, target, i, curr);
			curr = curr - candi[i];
			temp.remove(temp.size() - 1);
		}
		return;
	}
}
