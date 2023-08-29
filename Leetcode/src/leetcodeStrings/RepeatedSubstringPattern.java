package leetcodeStrings;

//Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

public class RepeatedSubstringPattern {

	public boolean repeatedSubstringPattern(String str) {
		String s = str + str;
		return s.substring(1, s.length() - 1).contains(str);
	}
}
