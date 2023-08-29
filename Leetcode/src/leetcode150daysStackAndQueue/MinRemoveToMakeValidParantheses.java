package leetcode150daysStackAndQueue;

//Given a string s of '(' , ')' and lowercase English characters.
//
//Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.
//
//Formally, a parentheses string is valid if and only if:
//
//It is the empty string, contains only lowercase characters, or
//It can be written as AB (A concatenated with B), where A and B are valid strings, or
//It can be written as (A), where A is a valid string.

public class MinRemoveToMakeValidParantheses {

	public String minRemoveToMakeValid(String s) {
		int open = 0, close = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				open++;
			else if (open == 0 && s.charAt(i) == ')')
				close++;
			else if (s.charAt(i) == ')')
				open--;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (close > 0 && s.charAt(i) == ')') {
				close--;
				continue;
			}
			sb.append(s.charAt(i));
		}

		if (open > 0) {
			for (int i = sb.length() - 1; i >= 0; i--) {
				if (sb.charAt(i) == '(') {
					open--;
					sb.deleteCharAt(i);
					if (open == 0)
						break;
				}
			}
		}
		return sb.toString();
	}

}
