package leetcode150daysHash;

import java.util.ArrayList;
import java.util.List;

//Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

public class FindAllAnagramsInString {

	public List<Integer> findAnagrams(String s, String p) {
		if (p.length() > s.length())
			return new ArrayList<>();

		int[] pmap = new int[26];
		int[] smap = new int[26];

		for (int i = 0; i < p.length(); i++) {
			pmap[p.charAt(i) - 'a']++;
			smap[s.charAt(i) - 'a']++;
		}

		List<Integer> res = new ArrayList<>();
		int i = 0;
		for (i = 0; i < s.length() - p.length(); i++) {
			if (matches(pmap, smap)) {
				res.add(i);
			}

			smap[s.charAt(i + p.length()) - 'a']++;
			smap[s.charAt(i) - 'a']--;
		}
		if (matches(pmap, smap))
			res.add(i);

		return res;
	}

	boolean matches(int[] pmap, int[] smap) {
		for (int i = 0; i < 26; i++) {
			if (smap[i] != pmap[i])
				return false;
		}

		return true;
	}

}
