package leetcodeStrings;

//Given a palindromic string of lowercase English letters palindrome, replace exactly one character with any lowercase English letter so that the resulting string is not a palindrome and that it is the lexicographically smallest one possible.
//
//Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
//
//A string a is lexicographically smaller than a string b (of the same length) if in the first position where a and b differ, a has a character strictly smaller than the corresponding character in b. For example, "abcc" is lexicographically smaller than "abcd" because the first position they differ is at the fourth character, and 'c' is smaller than 'd'.
public class BreakPalindrome {

	public String breakPalindrome(String palindrome) {
		if (palindrome.length() == 1)
			return "";

		StringBuilder sb = new StringBuilder(palindrome);
		int arr[] = new int[26];
		for (int i = 0; i < sb.length(); i++) {
			int ch = sb.charAt(i) - 'a';
			arr[ch]++;
		}

		if (arr[0] == (sb.length() - 1)) {
			sb.setCharAt(sb.length() - 1, 'b');
			return sb.toString();
		}

		for (int i = 0; i < palindrome.length(); i++) {
			char ch = palindrome.charAt(i);
			if (ch != 'a') {
				sb.setCharAt(i, 'a');
				return sb.toString();
			}
		}

		sb.setCharAt(palindrome.length() - 1, 'b');
		return sb.toString();
	}
}
