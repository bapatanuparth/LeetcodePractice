package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.

public class CombinationSumII {

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<Integer> temp = new ArrayList<>();
		List<List<Integer>> out = new ArrayList<>();
		combi(out, temp, 0, target, candidates);
		return out;
	}

	void combi(List<List<Integer>> out, List<Integer> temp, int i, int target, int[] candidates) {
		if (target == 0) {
			out.add(new ArrayList<>(temp));
			return;
		}
		if (target < 0)
			return;

		for (int next = i; next < candidates.length; next++) {
			if (next > i && candidates[next] == candidates[next - 1])
				continue;
			temp.add(candidates[next]);
			int rem = target - candidates[next];
			combi(out, temp, next + 1, rem, candidates);
			temp.remove(temp.size() - 1);
		}
	}

}
