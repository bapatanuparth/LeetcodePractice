package leetcodeDynamicProgramming;

//Given a string s, partition s such that every 
//substring
// of the partition is a 
//palindrome
//.
//
//Return the minimum cuts needed for a palindrome partitioning of s.

public class PalindromePartitioningII {

	class Solution {

		Integer[][] memoCuts; // memoize the min cuts for all start, end indices
		Boolean[][] memoPalindrome; // memoize which start to end parts are palindrome

		public int minCut(String s) {
			// System.out.println(s.substring(0, 1));
			memoCuts = new Integer[s.length()][s.length()];
			memoPalindrome = new Boolean[s.length()][s.length()];
			return dfs(s, 0, s.length() - 1);

		}

		int dfs(String str, int start, int end) {
			if (start == end || isPalindrome(str, start, end)) // number of further cuts required == 0 for same start
																// and end, or something is already a palindrome
				return 0;
			if (memoCuts[start][end] != null)
				return memoCuts[start][end];

			int cost = Integer.MAX_VALUE;

			for (int index = start; index <= end; index++) {
				if (isPalindrome(str, start, index)) // only cut at this position if it is a palindrome till here from
														// start
					cost = Math.min(cost, 1 + dfs(str, index + 1, end));
			}
			memoCuts[start][end] = cost;
			return cost;
		}

		boolean isPalindrome(String str, int start, int end) {
			if (start >= end)
				return true;
			if (memoPalindrome[start][end] != null)
				return memoPalindrome[start][end];
			return memoPalindrome[start][end] = (str.charAt(start) == str.charAt(end))
					&& isPalindrome(str, start + 1, end - 1);
		}
	}

}
