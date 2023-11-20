package leetcode150daysGreedy;

//Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

//
//The following rules define a valid string:
//
//Any left parenthesis '(' must have a corresponding right parenthesis ')'.
//Any right parenthesis ')' must have a corresponding left parenthesis '('.
//Left parenthesis '(' must go before the corresponding right parenthesis ')'.
//'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

public class ValidParanthesisString {

	public boolean checkValidString(String s) {

		int leftmin = 0, leftmax = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftmin++;
				leftmax++;
			} else if (s.charAt(i) == ')') {
				leftmin--;
				leftmax--;
			} else {
				leftmin--; // consider that * to be a )
				leftmax++; // consider that * to be a (
			}
			if (leftmax < 0)
				return false; // means we have got a ) without a any previous (
			if (leftmin < 0)
				leftmin = 0; // leftmin indicates what we assume * to be )
			// if it <0 it might be possible that our assumption is wrong and the string can
			// still be valid

		}

		return leftmin == 0;
	}

}
