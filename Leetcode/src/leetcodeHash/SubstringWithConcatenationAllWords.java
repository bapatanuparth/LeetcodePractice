package leetcodeHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given a string s and an array of strings words. All the strings of words are of the same length.
//
//A concatenated substring in s is a substring that contains all the strings of any permutation of words concatenated.
//
//For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated substring because it is not the concatenation of any permutation of words.
//Return the starting indices of all the concatenated substrings in s. You can return the answer in any order.

public class SubstringWithConcatenationAllWords {

	public List<Integer> findSubstring(String s, String[] words) {
		int n = words.length;
		int m = words[0].length();

		Map<String, Integer> map = new HashMap<>();
		Map<String, Integer> seen = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		List<Integer> res = new ArrayList<>();

		for (int i = 0; i <= s.length() - m * n; i++) {
			int count = n;
			seen.clear();
			for (int j = i; count != 0; j += m) {
				String target = s.substring(j, j + m);
				seen.put(target, seen.getOrDefault(target, 0) + 1);
				if (!map.containsKey(target) || seen.get(target) > map.get(target))
					break;
				count--;
			}
			if (count == 0)
				res.add(i);
		}
		return res;
	}

}
