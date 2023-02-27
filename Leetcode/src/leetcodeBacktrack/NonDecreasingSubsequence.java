package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequence {

	public List<List<Integer>> findSubsequences(int[] nums) {

		Set<List<Integer>> out = new HashSet<>();
		List<Integer> temp = new ArrayList<>();

		backtrack(out, temp, nums, 0);
		List<List<Integer>> res = new ArrayList<>(out);
		return res;
	}

	// use set of list to avoid duplicates
	void backtrack(Set<List<Integer>> out, List<Integer> temp, int[] nums, int i) {

		if (temp.size() >= 2)
			out.add(new ArrayList<>(temp));

		for (int index = i; index < nums.length; index++) {
			if (temp.size() == 0 || nums[index] >= temp.get(temp.size() - 1)) {
				temp.add(nums[index]);
				backtrack(out, temp, nums, index + 1);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
