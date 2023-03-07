package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//Given two strings s and t, your goal is to convert s into t in k moves or less.
//
//During the ith (1 <= i <= k) move you can:
//
//Choose any index j (1-indexed) from s, such that 1 <= j <= s.length and j has not been chosen in any previous move, and shift the character at that index i times.
//Do nothing.
//Shifting a character means replacing it by the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Shifting a character by i means applying the shift operations i times.
//
//Remember that any index j can be picked at most once.
//
//Return true if it's possible to convert s into t in no more than k moves, otherwise return false.
public class CanConvertStringInKMoves {

	public boolean canConvertString(String s, String t, int k) {

		if (s.length() != t.length())
			return false;
		// use hashmap to store the count of how many times a single move is required to
		// be done
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t.charAt(i))
				continue;
			int move = 0;
			// based on which character is greater, the min number of moves required to
			// shift will be different
			if (s.charAt(i) < t.charAt(i)) {
				move = t.charAt(i) - s.charAt(i);
			} else if (s.charAt(i) > t.charAt(i)) {
				move = 26 - (s.charAt(i) - t.charAt(i));
			}
			map.put(move, map.getOrDefault(move, 0) + 1);
		}

		// based on the number of moves, check whether we have k big enough to
		// incorporate that many wrap arounds
		for (int key : map.keySet()) {
			int val = map.get(key);
			int temp = 26 * (val - 1) + key;
			if (k < temp)
				return false;
		}

		return true;
	}
}
