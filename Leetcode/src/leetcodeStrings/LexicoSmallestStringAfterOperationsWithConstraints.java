package leetcodeStrings;

//You are given a string s and an integer k.
//
//Define a function distance(s1, s2) between two strings s1 and s2 of the same length n as:
//
//The sum of the minimum distance between s1[i] and s2[i] when the characters from 'a' to 'z' are placed in a cyclic order, for all i in the range [0, n - 1].
//For example, distance("ab", "cd") == 4, and distance("a", "z") == 1.
//
//You can change any letter of s to any other lowercase English letter, any number of times.
//
//Return a string denoting the 
//lexicographically smallest
// string t you can get after some changes, such that distance(s, t) <= k.

public class LexicoSmallestStringAfterOperationsWithConstraints {

	public String getSmallestString(String s, int k) {
		// System.out.println(distance('a', 'z'));
		int i = 0, sum = 0;
		StringBuilder sb = new StringBuilder(s);
		while (i < s.length() && sum + distance('a', s.charAt(i)) <= k) {
			sb.setCharAt(i, 'a');
			k -= distance('a', s.charAt(i));
			i++;
		}
		if (i < s.length()) {
			char ch = s.charAt(i);
			int n = Math.min((ch - 'a' + k) % 26, (ch - 'a' - k + 26) % 26);
			sb.setCharAt(i, (char) (n + 'a'));
		}

		return sb.toString();
	}

	int distance(char a, char b) {
		return Math.min(Math.abs((a - 'a') - (b - 'a')), Math.abs((26 + (a - 'a')) - (b - 'a')));
	}

}
