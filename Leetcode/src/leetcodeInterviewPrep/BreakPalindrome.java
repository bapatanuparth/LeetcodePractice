package leetcodeInterviewPrep;

public class BreakPalindrome {

	public String breakPalindrome(String palindrome) {
		if (palindrome.length() == 1)
			return "";

		// count character frequency
		StringBuilder sb = new StringBuilder(palindrome);
		int arr[] = new int[26];
		for (int i = 0; i < sb.length(); i++) {
			int ch = sb.charAt(i) - 'a';
			arr[ch]++;
		}

		// if the whole string has only 'a' then we need to make the last character as
		// 'b'
		if (arr[0] == (sb.length() - 1)) {
			sb.setCharAt(sb.length() - 1, 'b');
			return sb.toString();
		}

		// if the whole string doesnt have a, change the first character != a to a
		// this will make the string lexicographically smallest
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
