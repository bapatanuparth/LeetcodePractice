package leetcodeStrings;

//Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
//
//If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.

public class ReverseStringII {

	class Solution {
		public String reverseStr(String s, int k) {
			char[] cs = s.toCharArray();
			for (int i = 0; i < cs.length; i += 2 * k) {
				swap(cs, i, Math.min(i + k - 1, cs.length - 1));
			}
			return String.valueOf(cs);
		}

		private void swap(char[] cs, int left, int right) {
			while (left < right) {
				char tmp = cs[left];
				cs[left] = cs[right];
				cs[right] = tmp;
				left++;
				right--;
			}
		}
	}

}
