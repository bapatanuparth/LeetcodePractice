package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.List;

//VVVIMP
public class GenerateParanthesis {

	public List<String> generateParenthesis(int n) {

		List<String> out = new ArrayList<>();

		generate(out, "", 0, 0, n);
		return out;
	}

	// very intuitive backtracking solution
	void generate(List<String> out, String temp, int open, int close, int n) {
		if (temp.length() == n * 2) {
			out.add(temp);
			return;
		}

		// add open paranthesis if #open paranthesis < n
		if (open < n) {
			generate(out, temp + "(", open + 1, close, n);
		}

		// add close only if #close < #open
		if (close < open) {
			generate(out, temp + ")", open, close + 1, n);
		}
	}
}
