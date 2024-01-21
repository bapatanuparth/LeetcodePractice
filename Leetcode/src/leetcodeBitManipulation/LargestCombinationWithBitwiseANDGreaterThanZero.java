package leetcodeBitManipulation;

//The bitwise AND of an array nums is the bitwise AND of all integers in nums.
//
//For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
//Also, for nums = [7], the bitwise AND is 7.
//You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates. Each number in candidates may only be used once in each combination.
//
//Return the size of the largest combination of candidates with a bitwise AND greater than 0.

public class LargestCombinationWithBitwiseANDGreaterThanZero {

	public int largestCombination(int[] candidates) {
		int res = 0, cur = 0;
		for (int i = 0; i < 30; i++) {
			cur = 0;
			for (int a : candidates) {
				cur += a >> i & 1;
			}
			res = Math.max(res, cur);
		}

		return res;
	}

}
