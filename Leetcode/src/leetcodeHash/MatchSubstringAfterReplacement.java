package leetcodeHash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//You are given two strings s and sub. You are also given a 2D character array mappings where mappings[i] = [oldi, newi] indicates that you may perform the following operation any number of times:
//
//Replace a character oldi of sub with newi.
//Each character in sub cannot be replaced more than once.
//
//Return true if it is possible to make sub a substring of s by replacing zero or more characters according to mappings. Otherwise, return false.
//
//A substring is a contiguous non-empty sequence of characters within a string.

public class MatchSubstringAfterReplacement {

	class Solution {
		public boolean matchReplacement(String s, String sub, char[][] mappings) {

			Map<Character, Set<Character>> map = new HashMap<>();

			// create a map of all the mappings, use hashset to store all the different
			// values that one character can be mapped to
			for (char arr[] : mappings) {
				char c1 = arr[0];
				char c2 = arr[1];
				if (map.containsKey(c1)) {
					map.get(c1).add(c2);
				} else {
					Set<Character> set = new HashSet<>();
					set.add(c2);
					map.put(c1, set);
				}
			}

			int n = sub.length();
			int left = 0;

			// add the first character of the sub to map if its not present

			if (map.containsKey(sub.charAt(0))) {
				map.get(sub.charAt(0)).add(sub.charAt(0));
			} else {
				Set<Character> set = new HashSet<>();
				set.add(sub.charAt(0));
				map.put(sub.charAt(0), set);
			}
			// we will loop over all the first characters that can be possible for sub and
			// check if there exists a way to change sub to that substring in s
			for (char ch : map.get(sub.charAt(0))) {

				// start from beginning of s
				for (left = 0; left <= s.length() - n; left++) {
					if (s.charAt(left) != ch) // if left char != first char of sub, contnue
						continue;
					// this means we have found the first character match
					// now next step is to check for whether the whole sub can be transformed to
					// next left+n characters of s
					// i.e. we check whether sub(j) has any mapping that is == s(i), if yes we go
					// ahead, if no, we break.
					int right = left + n;
					int i = left;
					int j = 0;
					// check if we can reach the end of sub by checking all the possible mappings
					while (i < right) {
						if (s.charAt(i) != sub.charAt(j)) {
							if (!map.containsKey(sub.charAt(j)))
								break;
							if (!map.get(sub.charAt(j)).contains(s.charAt(i)))
								break;
						}
						i++;
						j++;
					}
					if (j == n) // this means we were able to map the whole sub with a character from s
						return true;
				}
			}

			return false;
		}

	}

}
