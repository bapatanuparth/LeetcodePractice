package leetCodeArrays2;

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

		int start = 0, end = 0;
		for (int i = 0; i < nums.length;) {
			start = nums[i];
			int j = i + 1;
			boolean flag = false;
			while (j < nums.length && nums[j] == nums[i] + 1) {
				j++;
				i++;
				flag = true;
			}
			end = nums[j - 1];

			StringBuilder sb = new StringBuilder();
			if (flag == true) {
				sb.append(start);
				sb.append("->");
				sb.append(end);
			} else
				sb.append(start);
			res.add(sb.toString());
			i = j;
		}

		return res;
	}
}
