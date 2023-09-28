package leetcode150daysGreedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
//
//A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
//
//Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

public class FindAndReplacePattern {

	public List<String> findAndReplacePattern(String[] words, String pattern) {
		String pmap = createMap(pattern);
		String pmap2 = newMap(pattern);

		List<String> res = new ArrayList<>();
		for (String word : words) {
			String smap = createMap(word);
			String smap2 = newMap(word);

			if (smap.length() != pmap.length() || !smap2.equals(pmap2))
				continue;
			if (checkEqual(pmap, smap)) {
				res.add(word);
			}
		}
		return res;
	}

	String newMap(String s) {
		int[] freq = new int[26];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			sb.append(freq[s.charAt(i) - 'a']);
		}

		return sb.toString();
	}

	boolean checkEqual(String pmap, String smap) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < pmap.length(); i++) {
			char ch = pmap.charAt(i);
			if (Character.isDigit(ch)) {
				if (smap.charAt(i) != ch)
					return false;
			} else {
				if (map.containsKey(ch)) {
					if (map.get(ch) != smap.charAt(i))
						return false;
				} else
					map.put(ch, smap.charAt(i));
			}
		}

		return true;
	}

	String createMap(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int j = i;
			int count = 0;
			while (j < s.length() && s.charAt(j) == s.charAt(i)) {
				j++;
				count++;
			}
			sb.append(s.charAt(i));
			sb.append(count);
		}

		return sb.toString();
	}

}
