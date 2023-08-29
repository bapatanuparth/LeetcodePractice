package leetcode150daysHash;

import java.util.HashMap;

//Given a pattern and a string s, find if s follows the same pattern.
//
//Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

public class WordPattern {

	public boolean wordPattern(String pattern, String s) {
		HashMap map_index = new HashMap();
		String[] words = s.split(" ");

		if (words.length != pattern.length())
			return false;

		for (Integer i = 0; i < words.length; i++) {
			char c = pattern.charAt(i);
			String w = words[i];

			if (!map_index.containsKey(c))
				map_index.put(c, i);

			if (!map_index.containsKey(w))
				map_index.put(w, i);

			if (map_index.get(c) != map_index.get(w))
				return false;
		}

		return true;
	}

}
