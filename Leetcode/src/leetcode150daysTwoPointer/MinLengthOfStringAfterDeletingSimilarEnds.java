package leetcode150daysTwoPointer;

//Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
//
//Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
//Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
//The prefix and the suffix should not intersect at any index.
//The characters from the prefix and suffix must be the same.
//Delete both the prefix and the suffix.
//Return the minimum length of s after performing the above operation any number of times (possibly zero times).

public class MinLengthOfStringAfterDeletingSimilarEnds {

	public int minimumLength(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			if (s.charAt(left) != s.charAt(right))
				return right - left + 1;
			else {
				int j = left;
				while (j <= right && s.charAt(j) == s.charAt(left))
					j++;
				left = j;
				j = right;
				while (j >= left && s.charAt(j) == s.charAt(right))
					j--;
				right = j;
			}

		}
		if (left > right)
			return 0;
		return right - left + 1;
	}

}
