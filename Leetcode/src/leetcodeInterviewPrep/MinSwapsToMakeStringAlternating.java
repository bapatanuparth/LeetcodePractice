package leetcodeInterviewPrep;

public class MinSwapsToMakeStringAlternating {

	public int minSwaps(String s) {
		int n = s.length();
		int ones = 0, zero = 0;
		// count # of ones and zeros
		for (char c : s.toCharArray()) {
			if (c == '1')
				++ones;
			else
				++zero;
		}

		// if ones and zeros have greater difference than 1, we cannot create valid
		// string
		if (Math.abs(ones - zero) > 1)
			return -1;

		// if ones is greater, valid string has to be 1010101, i.e. starting with 1
		if (ones > zero)
			return helper(s, '1');
		else if (zero > ones)
			return helper(s, '0');

		return Math.min(helper(s, '1'), helper(s, '0')); // if both equal, it means even string, so pick the one that
															// would require minimum swaps
	}

	private int helper(String s, char c) {
		// for string required to start with char c,
		// check how many elements are out of place
		int swaps = 0;
		for (char ch : s.toCharArray()) {
			if (ch != c) {
				++swaps;
			}
			c = (c == '1') ? '0' : '1';
		}

		return swaps / 2; // we count charcacters out of place.
		// # swap == characters out of place/2
	}
}
