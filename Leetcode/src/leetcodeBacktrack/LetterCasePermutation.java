package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.
//
//Return a list of all possible strings we could create. Return the output in any order.
public class LetterCasePermutation {

	public List<String> letterCasePermutation(String s) {

		List<String> out = new ArrayList<>();
		StringBuilder sb = new StringBuilder(s);

		transform(out, sb, s, 0);
		return out;
	}

	void transform(List<String> out, StringBuilder sb, String s, int i) {

		if (i == sb.length()) {
			out.add(new String(sb.toString()));
			return;
		}

		// if letter, consider all possible combinations
		if (Character.isLetter(sb.charAt(i))) {
			sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
			transform(out, sb, s, i + 1);
			sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
		}
		// call irrespective of letter or not
		transform(out, sb, s, i + 1);
	}
}
