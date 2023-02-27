package leetcodeGreedy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

	// count frequency of all the character occurrence
	// consider an odd value only once.
	// other than that, all values should be even that can be added on both the
	// sides of an odd value
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		boolean odd = false;
		int count = 0;

		for (Character ch : map.keySet()) {
			if (map.get(ch) % 2 == 0) {
				count += map.get(ch);
			} else {
				if (!odd) {
					count++;
					odd = true;
				}
				count += map.get(ch) - 1;
			}
		}

		return count;
	}

}
