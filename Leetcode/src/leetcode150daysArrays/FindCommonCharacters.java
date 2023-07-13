package leetcode150daysArrays;

import java.util.ArrayList;
import java.util.List;

//Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

public class FindCommonCharacters {

	public List<String> commonChars(String[] words) {
		int[] last = count(words[0]); // frequency of 1st word
		for (int i = 1; i < words.length; i++) {
			last = intersection(last, count(words[i])); // go on building in the same array
		}
		List<String> res = new ArrayList<>();
		// in lasrt we have all the characters that are common in all the strings
		for (int i = 0; i < 26; i++) {
			char ch = (char) ('a' + i);
			String s = String.valueOf(ch);
			while (last[i] > 0) {
				res.add(s);
				last[i]--;
			}
		}

		return res;

	}

	// find the common characters between the 2 strings
	int[] intersection(int a[], int b[]) {
		int[] t = new int[26];
		for (int i = 0; i < 26; i++) {
			t[i] = Math.min(a[i], b[i]);
		}
		return t;
	}

	// count characters in string
	int[] count(String s) {
		int[] t = new int[26];
		for (int i = 0; i < s.length(); i++) {
			t[s.charAt(i) - 'a']++;
		}
		return t;
	}

}
