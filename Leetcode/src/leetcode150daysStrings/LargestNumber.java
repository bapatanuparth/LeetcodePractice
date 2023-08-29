package leetcode150daysStrings;

import java.util.Arrays;

//Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
//
//Since the result may be very large, so you need to return a string instead of an integer.

public class LargestNumber {

	public String largestNumber(int[] nums) {
		String[] stringval = new String[nums.length];
		int countZero = 0;
		for (int i = 0; i < nums.length; i++) {
			stringval[i] = String.valueOf(nums[i]);
			if (nums[i] == 0)
				countZero++;
		}
		if (countZero == nums.length)
			return "0";
		Arrays.sort(stringval, (String a, String b) -> (b + a).compareTo(a + b));
		StringBuilder sb = new StringBuilder();
		for (String s : stringval)
			sb.append(s);

		return sb.toString();
	}

}
