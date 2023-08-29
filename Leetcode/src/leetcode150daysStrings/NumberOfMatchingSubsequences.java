package leetcode150daysStrings;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.
//
//A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
//
//For example, "ace" is a subsequence of "abcde".

public class NumberOfMatchingSubsequences {

	public int numMatchingSubseq(String S, String[] words) {
		Map<Character, Deque<String>> map = new HashMap<>();
		// create a map for each starting letter of words, followed by queue of all the
		// words starting at that character
		for (char c = 'a'; c <= 'z'; c++) {
			map.putIfAbsent(c, new LinkedList<String>());
		}
		// create a map, now it will be like-
		// a ->["a", "acd", "ace"]

		for (String word : words) {
			map.get(word.charAt(0)).addLast(word);
		}

		int count = 0;
		for (char c : S.toCharArray()) {
			Deque<String> queue = map.get(c);
			int size = queue.size();
			// for each letter of S, get the queue of wiords startting their, remove 1st
			// letter and put back in map
			// if word length==1, means we have reduced that word to empty string, i.e. it
			// is a subsequence of the S
			for (int i = 0; i < size; i++) {
				String word = queue.removeFirst();
				if (word.length() == 1) {
					count++;
				} else {
					map.get(word.charAt(1)).addLast(word.substring(1));
				}
			}
		}
		return count;
	}

}
