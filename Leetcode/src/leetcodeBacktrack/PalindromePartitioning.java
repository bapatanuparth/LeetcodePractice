package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//
//A palindrome string is a string that reads the same backward as forward.

public class PalindromePartitioning {

	public List<List<String>> partition(String s) {

		List<List<String>> op = new ArrayList<>();
		List<String> one = new ArrayList<>();

		dynamic(op, one, 0, s);

		return op;
	}

	void dynamic(List<List<String>> op, List<String> temp, int i, String s) {
		if (i >= s.length()) {
			op.add(new ArrayList<>(temp));
			return;
		}

		for (int end = i; end < s.length(); end++) {
			if (isPalindrome(s, i, end)) {
				temp.add(s.substring(i, end + 1));
				dynamic(op, temp, end + 1, s);
				temp.remove(temp.size() - 1);
			}
		}

	}

	boolean isPalindrome(String s, int low, int high) {
		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		}
		return true;
	}
}
