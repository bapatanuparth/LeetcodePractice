package leetcode150daysHash;

import java.util.HashSet;
import java.util.Set;

//Given a string s, find the length of the longest 
//substring
// without repeating characters.

public class LongestSubstringWORepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		Set<Character> set = new HashSet<>();
		int res = 0;
		int k = 0, i = 0;

		for (i = 0; i < s.length();) {

			if (!set.contains(s.charAt(i))) {
				set.add(s.charAt(i));
				res = Math.max(res, i - k + 1);
				i++;
			} else if (set.contains(s.charAt(i))) {
				set.remove(s.charAt(k));
				k++;
			}
		}
		return res;
	}
}
