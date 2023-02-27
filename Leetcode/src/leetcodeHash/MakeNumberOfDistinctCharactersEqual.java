package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//You are given two 0-indexed strings word1 and word2.
//
//A move consists of choosing two indices i and j such that 0 <= i < word1.length and 0 <= j < word2.length and swapping word1[i] with word2[j].
//
//Return true if it is possible to get the number of distinct characters in word1 and word2 to be equal with exactly one move. Return false otherwise.
//
public class MakeNumberOfDistinctCharactersEqual {

	public boolean isItPossible(String word1, String word2) {
		Map<Character, Integer> map1 = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();

		// count freq of each character
		for (char ch : word1.toCharArray()) {
			map1.put(ch, map1.getOrDefault(ch, 0) + 1);
		}

		for (char ch : word2.toCharArray()) {
			map2.put(ch, map2.getOrDefault(ch, 0) + 1);
		}

		// try replacing each character of map1 with each character of map2
		// check if maps are equal at any point
		// if yes, return true
		for (char c1 = 'a'; c1 <= 'z'; c1++) {

			for (char c2 = 'a'; c2 <= 'z'; c2++) {

				if (!map1.containsKey(c1) || !map2.containsKey(c2))
					continue;

				insertRemove(map1, c2, c1);
				insertRemove(map2, c1, c2);

				if (map1.size() == map2.size())
					return true;

				insertRemove(map1, c1, c2);
				insertRemove(map2, c2, c1);

			}
		}

		return false;

	}

	void insertRemove(Map<Character, Integer> map, char toInsert, char toRemove) {
		map.put(toInsert, map.getOrDefault(toInsert, 0) + 1);
		map.put(toRemove, map.getOrDefault(toRemove, 0) - 1);
		if (map.get(toRemove) == 0)
			map.remove(toRemove);
		return;
	}

}
