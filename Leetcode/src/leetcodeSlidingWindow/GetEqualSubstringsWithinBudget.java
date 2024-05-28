package leetcodeSlidingWindow;

//You are given two strings s and t of the same length and an integer maxCost.
//
//You want to change s to t. Changing the ith character of s to ith character of t costs |s[i] - t[i]| (i.e., the absolute difference between the ASCII values of the characters).
//
//Return the maximum length of a substring of s that can be changed to be the same as the corresponding substring of t with a cost less than or equal to maxCost. If there is no substring from s that can be changed to its corresponding substring from t, return 0.

public class GetEqualSubstringsWithinBudget {

	public int equalSubstring(String s, String t, int maxCost) {
		int left = 0, max = 0;
		for (int i = 0; i < s.length(); i++) {
			char schar = s.charAt(i);
			char tchar = t.charAt(i);
			int diff = Math.abs((int) schar - (int) tchar);
			maxCost -= diff;
			while (left <= i && maxCost < 0) {
				schar = s.charAt(left);
				tchar = t.charAt(left);
				diff = Math.abs((int) schar - (int) tchar);
				maxCost += diff;
				left++;
			}
			max = Math.max(max, i - left + 1);
		}

		return max;
	}

}
