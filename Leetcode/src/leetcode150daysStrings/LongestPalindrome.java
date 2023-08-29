package leetcode150daysStrings;

//Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
//
//Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

public class LongestPalindrome {

	public int longestPalindrome(String s) {
		int[] count = new int[128];
		for (char c : s.toCharArray())
			count[c]++;

		int ans = 0;
		for (int v : count) {
			ans += (v / 2) * 2;
			if (ans % 2 == 0 && v % 2 == 1)
				ans++;
		}
		return ans;
	}

}
