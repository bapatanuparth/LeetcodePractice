package leetcode150daysStrings;

//Given a string s consisting of words and spaces, return the length of the last word in the string.
//
//A word is a maximal 
//substring
// consisting of non-space characters only.

public class LengthOfLastWord {

	class Solution {
		public int lengthOfLastWord(String s) {
			int p = s.length(), length = 0;
			while (p > 0) {
				p--;
				// we're in the middle of the last word
				if (s.charAt(p) != ' ') {
					length++;
				}
				// here is the end of last word
				else if (length > 0) {
					return length;
				}
			}
			return length;
		}
	}

}
