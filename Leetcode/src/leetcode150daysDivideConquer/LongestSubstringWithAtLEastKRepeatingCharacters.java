package leetcode150daysDivideConquer;

//Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
//
//if no such substring exists, return 0.

public class LongestSubstringWithAtLEastKRepeatingCharacters {

	public int longestSubstring(String s, int k) {
		if (s == null || k == 1)
			return s.length();

		int freq[] = new int[26];
		char[] ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			freq[ch[i] - 'a']++;
		}
		boolean flag = true;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > 0 && freq[i] < k)
				flag = false;
		}
		if (flag)
			return ch.length;

		int start = 0, cur = 0, res = 0;
		while (cur < ch.length) {
			if (freq[ch[cur] - 'a'] < k) {
				res = Math.max(res, longestSubstring(s.substring(start, cur), k));
				start = cur + 1;
			}
			cur++;
		}
		res = Math.max(res, longestSubstring(s.substring(start), k));
		return res;
	}

}
