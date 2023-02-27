package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//You are given an array of strings words. Each element of words consists of two lowercase English letters.
//
//Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.
//
//Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.
//
//A palindrome is a string that reads the same forward and backward

public class LongestPalindromeByConcatenatingTwoLetterWords {

	public int longestPalindrome(String[] words) {

		// map stores all the strings
		Map<String, Integer> map = new HashMap<>();
		int result = 0;

		int countOdds = 0;
		for (String word : words) {

			String rev = "" + word.charAt(1) + word.charAt(0);

			// if reverse is present
			if (map.containsKey(rev)) {
				result += 4; // increase result by 4 as it is a palindrome that can always work
				if (map.get(rev) == 1) {
					map.remove(rev);
				} else {
					map.put(rev, map.get(rev) - 1);
				}

				// if letters are same, we need to count if the word has occured odd number of
				// times or not
				// ex. when aa aa appears twice, it becomes even

				if (word.equals(rev)) {
					countOdds--;
				}
			} else {
				// if map doesnt contain reverse of current word, increase the current words
				// frequency in the map for further reference
				map.put(word, map.getOrDefault(word, 0) + 1);

				// if aa appears only once, the count of same letter word == 1 i.e. odd
				if (word.equals(rev)) {
					countOdds++;
				}
			}

		}

		return countOdds > 0 ? result + 2 : result;
	}
}
