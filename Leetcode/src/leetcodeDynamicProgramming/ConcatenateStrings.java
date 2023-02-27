package leetcodeDynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ConcatenateStrings {

	class Solution {

		public List<String> findAllConcatenatedWordsInADict(String[] words) {
			// create a set of all given words
			final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
			final List<String> answer = new ArrayList<>();
			Map<String, Boolean> map = new HashMap<>(); // map to memoize the data

			// for all the words, call DFS to check if breaking the word in any 2 or more
			// segments gives all the words already present or not
			for (final String word : words) {

				if (dfs(word, dictionary, map)) { // if this returns true, it means we have found the words in the
													// original list
					answer.add(word);
				}
			}
			return answer;
		}

		boolean dfs(String word, Set<String> set, Map<String, Boolean> map) {
			if (map.containsKey(word)) // memoize the solution
				return map.get(word);

			// for each word, try to get all possible prefixes one by one starting from
			// first letter.
			// check if both prefix and suffix are present in the set, if yes, then we have
			// found a word formed from 2 or more words.
			// if prefix present but not suffix, then call recursively passing only the
			// suffix ahead.
			// then this action will be performed on the suffix unless we reach till the end
			// of the program
			for (int i = 1; i < word.length(); i++) {
				String prefix = word.substring(0, i);
				String suffix = word.substring(i);
				if (set.contains(prefix) && set.contains(suffix) || set.contains(prefix) && dfs(suffix, set, map)) {
					map.put(word, true);
					return map.get(word);
				}
			}

			map.put(word, false);
			return map.get(word);

		}
	}

}
