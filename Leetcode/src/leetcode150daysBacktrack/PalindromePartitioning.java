package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given a string s, partition s such that every 
//substring
// of the partition is a 
//palindrome
//. Return all possible palindrome partitioning of s.

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {
		List<List<String>> res = new ArrayList<>();
		List<String> temp = new ArrayList<>();

		dfs(0, s, temp, res);
		return res;
	}

	void dfs(int start, String s, List<String> temp, List<List<String>> res) {
		if (start >= s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPal(str)) {
				temp.add(str);
				dfs(i, s, temp, res);
				temp.remove(temp.size() - 1);
			}
		}
	}

	boolean isPal(String str) {
		int left = 0, right = str.length() - 1;
		while (left <= right) {
			if (str.charAt(left++) != str.charAt(right--))
				return false;
		}
		return true;
	}

}
