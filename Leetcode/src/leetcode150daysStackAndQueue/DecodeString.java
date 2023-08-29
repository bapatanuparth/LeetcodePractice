package leetcode150daysStackAndQueue;

import java.util.Stack;

//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output will never exceed 105.

public class DecodeString {

	public String decodeString(String s) {
		Stack<String> st1 = new Stack<>(); // string before [
		Stack<Integer> st2 = new Stack<>(); // count before [

		int count = 0;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				count = count * 10 + (ch - '0');
			} else if (ch == '[') {
				st1.push(res);
				st2.push(count);
				count = 0;
				res = "";
			} else if (ch == ']') {
				String temp = st1.pop();
				int time = st2.pop();
				while (time > 0) {
					time--;
					temp += res;
				}
				res = temp;
			} else {
				res += Character.toString(ch);
			}
		}

		return res;
	}

}
