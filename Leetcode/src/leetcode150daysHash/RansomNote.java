package leetcode150daysHash;

//Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
//
//Each letter in magazine can only be used once in ransomNote.

public class RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
		int[] freq = new int[26];

		for (char ch : ransomNote.toCharArray()) {
			freq[ch - 'a']++;
		}

		for (char ch : magazine.toCharArray()) {
			freq[ch - 'a']--;
		}

		for (int i : freq) {
			if (i > 0)
				return false;
		}
		return true;
	}
}
