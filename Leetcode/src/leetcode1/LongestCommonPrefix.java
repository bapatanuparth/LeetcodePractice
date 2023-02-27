package leetcode1;

import java.util.Arrays;

//Write a function to find the longest common prefix string amongst an array of strings.
//Input: strs = ["flower","flow","flight"]
//Output: "fl"

public class LongestCommonPrefix {

	public String longestCommonPrefix4(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty())
					return "";
			}

		}
		return prefix;
	}

	// Innovative solution using sort
	public static String longestCommonPrefix3(String[] strs) {
		String res = "";
		Arrays.sort(strs);
		for (int i = 0; i < strs.length; i++)
			System.out.println(strs[i]);
		String a = strs[0];
		String b = strs[strs.length - 1];
		for (int i = 0; i < a.length(); i++) {
			if (i >= b.length())
				return res;
			if (a.charAt(i) != b.charAt(i))
				return res;
			else
				res += a.charAt(i);
		}
		return res;
	}

	public static String longestCommonPrefix(String[] strs) {
		String s = strs[0];
		String res = "";
		boolean flag = true;
		int index = 0;
		for (int j = 0; j < s.length(); j++) {

			for (int i = 1; i < strs.length; i++) {
				if (j >= strs[i].length() || s.charAt(j) != strs[i].charAt(j)) {
					return res;
				}
			}
			index++;
			res = res + s.charAt(j);
		}
		return res;
	}

	public String longestCommonPrefix2(String[] strs) {
		String s = strs[0];
		String res = "";
		for (int j = 0; j < s.length(); j++) {

			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() > 0 && s.charAt(j) != strs[i].charAt(0)) {
					return res;
				} else if (strs[i].length() == 0) {
					return res;
				} else {
					strs[i] = strs[i].substring(1, strs[i].length());
				}
			}
			res = res + s.charAt(j);
		}
		return res;

	}

	public static void main(String[] args) {
		String[] strs = new String[] { "dog", "racecar", "car" };
		System.out.println(longestCommonPrefix3(strs));

	}

}
