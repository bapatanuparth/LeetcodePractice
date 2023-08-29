package leetcode150daysStrings;

//Given a string s, return true if the s can be palindrome after deleting at most one character from it.

public class ValidPalindromeII {

	public boolean validPalindrome(String s) {

		int left = 0, right = s.length() - 1;
		boolean flag = false;

		while (left <= right) {
			if (s.charAt(left) != s.charAt(right)) {
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
			left++;
			right--;
		}

		return true;
	}

	boolean isPalindrome(String s, int left, int right) {

		while (left <= right) {
			if (s.charAt(left) != s.charAt(right))
				return false;
			left++;
			right--;
		}

		return true;
	}

}
