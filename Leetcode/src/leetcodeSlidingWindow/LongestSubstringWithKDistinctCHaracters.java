package leetcodeSlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKDistinctCHaracters {

	public int lengthOfLongestSubstringKDistinct(String s, int k) {

		Map<Character, Integer> map = new HashMap<>();

		int left = 0, res = 0;

		// sliding window
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

			// if map size > k move left till map size becomes <= k
			while (map.size() > k) {
				char charleft = s.charAt(left);
				map.put(charleft, map.get(charleft) - 1);
				if (map.get(charleft) == 0) {
					map.remove(charleft);
				}
				left++;
			}

			res = Math.max(res, i - left + 1);
		}

		return res;
	}
}
