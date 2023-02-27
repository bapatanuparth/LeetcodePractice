package leetcodeStack;

import java.util.Stack;

//You are given a string s, which contains stars *.
//
//In one operation, you can:
//
//Choose a star in s.
//Remove the closest non-star character to its left, as well as remove the star itself.
//Return the string after all stars have been removed.
//
//Note:
//
//The input will be generated such that the operation is always possible.
//It can be shown that the resulting string will always be unique.

public class RemovingStarsFromString {

	class Solution {
		public String removeStars(String s) {
			int slow = 0;
			char[] myCharArray = s.toCharArray();
			for (int fast = 0; fast < myCharArray.length; fast++) {
				if (myCharArray[fast] == '*') {
					slow--;
				} else {
					myCharArray[slow] = myCharArray[fast];
					slow++;
				}
			}
			return new String(myCharArray, 0, slow);
		}
	}

	public String removeStars(String s) {
		Stack<Character> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch != '*')
				st.push(ch);
			else
				st.pop();
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}

		return sb.reverse().toString();
	}
}
