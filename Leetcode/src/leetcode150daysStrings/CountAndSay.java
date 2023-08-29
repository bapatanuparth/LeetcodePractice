package leetcode150daysStrings;

import java.util.ArrayDeque;
import java.util.Queue;

//The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
//
//countAndSay(1) = "1"
//countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
//To determine how you "say" a digit string, split it into the minimal number of substrings such that each substring contains exactly one unique digit. Then for each substring, say the number of digits, then say the digit. Finally, concatenate every said digit.
//
//For example, the saying and conversion for digit string "3322251":
//

public class CountAndSay {

	public String countAndSay(int n) {

		int m = 1;
		String start = "1";
		Queue<String> q = new ArrayDeque<>();
		if (n == 1)
			return start;

		q.add(start);
		while (m < n) {
			StringBuilder sb = new StringBuilder();
			String str = start;

			for (int i = 0; i < str.length();) {
				int j = i;
				int count = 0;
				while (j < str.length() && str.charAt(i) == str.charAt(j)) {
					count++;
					j++;
				}
				sb.append(count);
				sb.append(str.charAt(i));
				i = j;
			}

			start = sb.toString();
			m++;
		}

		return start;
	}
}
