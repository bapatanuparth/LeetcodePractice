package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		generatePermutations(nums, 0, nums.length - 1, result);
		return result;
	}

	private void generatePermutations(int nums[], int start, int end, List<List<Integer>> result) {

		if (start == end) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			result.add(list);
			return;
		}

		for (int i = start; i <= end; i++) {
			int temp = nums[start];
			nums[start] = nums[i];
			nums[i] = temp;

			generatePermutations(nums, start + 1, end, result);

			temp = nums[start];
			nums[start] = nums[i];
			nums[i] = temp;

		}
	}

}
