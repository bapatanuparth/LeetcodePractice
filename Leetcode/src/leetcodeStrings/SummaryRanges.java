package leetcodeStrings;

import java.util.ArrayList;
import java.util.List;

//You are given a sorted unique integer array nums.
//
//A range [a,b] is the set of all integers from a to b (inclusive).
//
//Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
//
//Each range [a,b] in the list should be output as:
//
//"a->b" if a != b
//"a" if a == b

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {

		List<String> res = new ArrayList<>();

		for (int i = 0; i < nums.length;) {
			int start = i;
			int end = i + 1;
			while (end < nums.length && nums[end] == nums[start] + 1) {
				end++;
				start++;
			}
			if (start == i) {
				res.add("" + nums[start]);
			} else {
				res.add("" + nums[i] + "->" + nums[start]);
			}
			i = end;
		}

		return res;
	}

}
