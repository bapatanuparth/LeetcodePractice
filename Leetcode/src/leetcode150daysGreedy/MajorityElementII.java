package leetcode150daysGreedy;

import java.util.ArrayList;
import java.util.List;

//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

public class MajorityElementII {

	public List<Integer> majorityElement(int[] nums) {
		// Moore's algorithm
		int n = nums.length;
		List<Integer> res = new ArrayList<>();

		int count1 = 0;
		int count2 = 0;

		Integer candidate1 = null;
		Integer candidate2 = null;

		for (int num : nums) {
			if (candidate1 != null && candidate1 == num)
				count1++;
			else if (candidate2 != null && candidate2 == num)
				count2++;
			else if (count1 == 0) {
				candidate1 = num;
				count1++;
			} else if (count2 == 0) {
				candidate2 = num;
				count2++;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for (int num : nums) {
			if (candidate1 != null && candidate1 == num)
				count1++;
			if (candidate2 != null && candidate2 == num)
				count2++;
		}

		if (count1 > n / 3)
			res.add(candidate1);
		if (count2 > n / 3)
			res.add(candidate2);

		return res;
	}

}
