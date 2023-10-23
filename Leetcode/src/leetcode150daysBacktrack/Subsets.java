package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums of unique elements, return all possible 
//subsets
// (the power set).
//
//The solution set must not contain duplicate subsets. Return the solution in any order.

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> op = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		subsetRec(nums, 0, op, temp);
		// System.out.println(op);
		return op;
	}

	void subsetRec(int nums[], int i, List<List<Integer>> op, List<Integer> temp) {

		op.add(new ArrayList<>(temp));

		if (i == nums.length)
			return;

		for (; i < nums.length; i++) {
			temp.add(nums[i]);
			subsetRec(nums, i + 1, op, temp);
			temp.remove(temp.size() - 1);
		}

	}
}
