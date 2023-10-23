package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

public class GenerateParantheses {

	public List<String> generateParenthesis(int n) {

		List<String> out = new ArrayList<>();

		generate(out, "", 0, 0, n);
		return out;
	}

	void generate(List<String> out, String temp, int open, int close, int n) {
		if (temp.length() == n * 2) {
			out.add(temp);
			return;
		}

		if (open < n) {
			generate(out, temp + "(", open + 1, close, n);
		}

		if (close < open) {
			generate(out, temp + ")", open, close + 1, n);
		}
	}

}
