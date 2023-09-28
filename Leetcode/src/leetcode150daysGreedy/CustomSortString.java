package leetcode150daysGreedy;

import java.util.HashSet;
import java.util.Set;

//You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
//
//Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
//
//Return any permutation of s that satisfies this property.

public class CustomSortString {

	public String customSortString(String order, String s) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}

		Set<Character> set = new HashSet<>();
		for (char ch : order.toCharArray()) {
			set.add(ch);
			while (freq[ch - 'a'] > 0) {
				sb1.append(ch);
				freq[ch - 'a']--;
			}
		}

		for (int i = 0; i < s.length(); i++) {
			if (!set.contains(s.charAt(i)))
				sb2.append(s.charAt(i));
		}
		sb1.append(sb2);

		return sb1.toString();
	}

}
