package leetcodeDynamicProgramming;

//A binary string is monotone increasing if it consists of some number of 0's (possibly none), followed by some number of 1's (also possibly none).
//
//You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.
//
//Return the minimum number of flips to make s monotone increasing.

public class FlipStringToMonotoneIncreasing {

	public int minFlipsMonoIncr(String s) {
		int minFlips = 0;
		int minOne = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') // Don't care of prefix 0's
			{
				// Now I know whatever comes after needs at least one flip
				minOne++;
			} else if (minOne > 0)// This is ignored till first occurance of 1, ignored till 001
			{
				minFlips++;
				minOne--;
			}
		}
		return minFlips;
	}
}
