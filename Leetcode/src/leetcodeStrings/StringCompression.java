package leetcodeStrings;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

public class StringCompression {

	public int compress(char[] chars) {

		List<Character> list = new ArrayList<>();
		List<Pair<Character, String>> temp = new ArrayList<>();
		// get the consecutive elements
		for (int i = 0; i < chars.length;) {

			int j = i;
			int count = 0;
			while (j < chars.length && chars[i] == chars[j]) {
				count++;
				j++;
			}
			// add in the result pair
			if (count == 1)
				temp.add(new Pair<>(chars[i], "*"));
			if (count > 1) {
				temp.add(new Pair<>(chars[i], String.valueOf(count)));
			}

			i = j;
		}

		// for each pair, create a resultant list of values
		for (Pair<Character, String> p : temp) {
			char[] ch = p.getValue().toCharArray();

			list.add(p.getKey());
			for (char c : ch) {
				if (c == '*')
					continue;
				list.add(c);
			}

		}

		for (int i = 0; i < list.size(); i++) {
			chars[i] = list.get(i);
		}

		return list.size();
	}
}
