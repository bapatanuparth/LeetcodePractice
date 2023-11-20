package leetcodeStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a 0-indexed string s, permute s to get a new string t such that:
//
//All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
//The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
//Return the resulting string.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.

public class SortVowelsInAString {

	public String sortVowels(String s) {
		List<Character> ls = new ArrayList<>();
		for (char ch : s.toCharArray()) {
			if (isVowel(ch))
				ls.add(ch);
		}

		Collections.sort(ls);
		int j = 0;

		char[] arr = s.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (isVowel(arr[i])) {
				arr[i] = ls.get(j++);
			}
		}

		return String.valueOf(arr);
	}

	boolean isVowel(char ch) {
		return ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O'
				|| ch == 'u' || ch == 'U';
	}

}
