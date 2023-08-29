package leetcode150daysNumbers;

//Given an integer x, return true if x is a 
//palindrome
//, and false otherwise.

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		int t = x;
		int ans = 0;
		while (t != 0) {
			ans = ans * 10 + (t % 10);
			t = t / 10;
		}
		return ans == x;
	}

}
