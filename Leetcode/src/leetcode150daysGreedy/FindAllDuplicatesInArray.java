package leetcode150daysGreedy;

import java.util.ArrayList;
import java.util.List;

//Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.
//
//You must write an algorithm that runs in O(n) time and uses only constant extra space.

public class FindAllDuplicatesInArray {

	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> ls = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int pos = Math.abs(nums[i]) - 1;
			if (nums[pos] < 0)
				ls.add(pos + 1);
			nums[pos] = -nums[pos];

		}

		return ls;
	}

}
