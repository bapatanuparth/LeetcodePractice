package leetcodeStack;

import java.util.Stack;
//Given a string s, determine if it is valid.
//
//A string s is valid if, starting with an empty string t = "", you can transform t into s after performing the following operation any number of times:
//
//Insert string "abc" into any position in t. More formally, t becomes tleft + "abc" + tright, where t == tleft + tright. Note that tleft and tright may be empty.
//Return true if s is a valid string, otherwise, return false.

public class CheckIfWordIsValidAfterSubstitutions {

	public boolean isValid(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);

			if (ch == 'a') {
				st.push(ch);
			} else if (ch == 'b') {
				if (st.isEmpty() || st.peek() != 'a')
					return false;
				st.push('b');
			} else {
				if (st.isEmpty() || st.peek() != 'b')
					return false;
				st.pop();
				st.pop();
			}
		}
		if (!st.isEmpty())
			return false;
		return true;
	}
}
