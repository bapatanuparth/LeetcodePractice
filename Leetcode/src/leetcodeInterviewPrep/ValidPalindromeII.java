package leetcodeInterviewPrep;

public class ValidPalindromeII {

	public boolean validPalindrome(String s) {

//		Assuming i = 0, j = s.length() - 1;, s is a valid palindrome (as defined in the problem) if
//
//		there is only one pair of i, j such that s.charAt(i) != s.charAt(j)
//		after the different pair hit, we try removing i or j, the characters in middle should be a palindrome.
//		there is no pair of i, j such that s.charAt(i) != s.charAt(j)

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
