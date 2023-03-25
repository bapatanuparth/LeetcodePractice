package leetcodeStrings;

//You are given a string s. You can convert s to a 
//palindrome
// by adding characters in front of it.
//
//Return the shortest palindrome you can find by performing this transformation.

public class ShortestPalindrome {

	// good algorithm, gives TLE though
	public String shortestPalindrome(String s) {
		int n = s.length();
		for (int i = n - 1; i >= 0; i--) {
			if (isPalindrome(s.substring(0, i + 1))) {
				return new StringBuilder(s.substring(i + 1)).reverse().toString() + s;
			}
		}
		return new StringBuilder(s).reverse().toString() + s;
	}

	boolean isPalindrome(String s) {
		int n = s.length();
		for (int i = 0; i < n / 2; i++) {
			if (s.charAt(i) != s.charAt(n - i - 1)) {
				return false;
			}
		}
		return true;
	}

}
