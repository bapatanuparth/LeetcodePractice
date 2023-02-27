package leetcodeInterviewPrep;

import java.util.HashMap;
import java.util.Map;

//You are given a 0-indexed string s that you must perform k replacement operations on. The replacement operations are given as three 0-indexed parallel arrays, indices, sources, and targets, all of length k.

//
//To complete the ith replacement operation:
//
//Check if the substring sources[i] occurs at index indices[i] in the original string s.
//If it does not occur, do nothing.
//Otherwise if it does occur, replace that substring with targets[i].
//For example, if s = "abcd", indices[i] = 0, sources[i] = "ab", and targets[i] = "eee", then the result of this replacement will be "eeecd".
//
//All replacement operations must occur simultaneously, meaning the replacement operations should not affect the indexing of each other. The testcases will be generated such that the replacements will not overlap.
//
//For example, a testcase with s = "abc", indices = [0, 1], and sources = ["ab","bc"] will not be generated because the "ab" and "bc" replacements overlap.
//Return the resulting string after performing all replacement operations on s.
//
//A substring is a contiguous sequence of characters in a string.

public class FindAndReplaceString {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		Map<Integer, Integer> table = new HashMap<>();
		for (int i = 0; i < indexes.length; i++) {
			// if a match is found in the original string, record it
			if (S.startsWith(sources[i], indexes[i])) {
				table.put(indexes[i], i);
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length();) {
			if (table.containsKey(i)) {
				// if a replacement was recorded before
				sb.append(targets[table.get(i)]);
				i += sources[table.get(i)].length();
			} else {
				// if no replacement happened at this index
				sb.append(S.charAt(i));
				i++;
			}
		}
		return sb.toString();
	}

}
