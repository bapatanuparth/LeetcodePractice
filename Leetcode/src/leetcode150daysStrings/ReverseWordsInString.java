package leetcode150daysStrings;

//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
//
//Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

public class ReverseWordsInString {

	public String reverseWords(String s) {

		s = s.strip();
		String[] str = s.split("\\s+");

		int left = 0, right = str.length - 1;

		while (left < right) {
			String temp = str[left];
			str[left] = str[right];
			str[right] = temp;
			left++;
			right--;
		}

		StringBuilder sb = new StringBuilder();

		for (String val : str) {
			sb.append(val + " ");
		}

		sb.deleteCharAt(sb.length() - 1);

		return sb.toString();
	}

}
