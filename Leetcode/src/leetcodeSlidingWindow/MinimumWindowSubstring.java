package leetcodeSlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public class Solution {
		public String minWindow(String s, String t) {
			if (s == null || s.length() < t.length() || s.length() == 0) {
				return "";
			}

			// create a map of all characters in t string
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (char c : t.toCharArray()) {
				if (map.containsKey(c)) {
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
				}
			}
			// in minleft and minLen, we will store the final values of starting index and
			// length of substring to be found
			int left = 0;
			int minLeft = 0;
			int minLen = s.length() + 1;
			int count = 0; // count is used to maintain count of the characters that match with characters
							// in t
			for (int right = 0; right < s.length(); right++) {
				// if map.contains current character, reduce its frequency by 1
				// this means we have seen a character present in string t
				if (map.containsKey(s.charAt(right))) {
					map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
					if (map.get(s.charAt(right)) >= 0) {
						count++;
					}
					// when count==t.length, it means we have now seen all characters present in t
					while (count == t.length()) {
						// we find the minimum length of the substring
						if (right - left + 1 < minLen) {
							minLeft = left;
							minLen = right - left + 1;
						}
						// if the character at left is present in t, now move the window ahead
						// remove the character at left from the window and again reduce the count if
						// there is a mismatch in the characters in t and substring after removing the
						// character at left
						if (map.containsKey(s.charAt(left))) {
							map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
							if (map.get(s.charAt(left)) > 0) {
								count--;
							}
						}
						// move left pointer ahead
						left++;
					}
				}
			}
			// if min length > string length it means no substring is found
			if (minLen > s.length()) {
				return "";
			}

			return s.substring(minLeft, minLeft + minLen);
		}
	}
}
