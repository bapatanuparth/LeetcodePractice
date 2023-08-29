package leetcode150daysArrays;

//Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

public class CountOddNumbersInIntervalRange {

	class Solution {
		public int countOdds(int low, int high) {
			// If low is even, make it odd.
			if ((low & 1) == 0) {
				low++;
			}

			// low could become greater than high due to incrementation
			// if it is, the answer is 0; otherwise, use the formula.
			return low > high ? 0 : (high - low) / 2 + 1;
		}
	}

}
