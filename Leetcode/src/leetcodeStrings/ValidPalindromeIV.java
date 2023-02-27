package leetcodeStrings;

//You are given a 0-indexed string s consisting of only lowercase English letters. In one operation, you can change any character of s to any other character.
//
//Return true if you can make s a palindrome after performing exactly one or two operations, or return false otherwise.

public class ValidPalindromeIV {

	public boolean makePalindrome(String s) {

		int count = 0;

		int left = 0, right = s.length() - 1;

		while (left <= right) {
			// count # of times when the char at left is not equal to the character at
			// right.
			// if the count is greater than 2, we need to return false
			// we can ignore up to 2 characters that are out of palindrome
			if (s.charAt(left) != s.charAt(right)) {
				count++;
				if (count > 2)
					return false;
			}
			left++;
			right--;
		}

		return true;
	}
}
