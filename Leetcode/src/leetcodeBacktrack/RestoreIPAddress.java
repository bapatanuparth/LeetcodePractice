package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
//For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.
public class RestoreIPAddress {

	class Solution {
		public List<String> restoreIpAddresses(String s) {
			if (s.length() > 12 || s.length() < 4)
				return new ArrayList<>();
			Set<String> ls = new HashSet<>();
			StringBuilder sb = new StringBuilder(s);

			// we know that 1st split cannot be greater than index 3
			for (int i = 0; i < 3; i++) {
				sb.insert(i + 1, '.');
				backtrack(ls, s, sb, i + 1, 2);
				sb.deleteCharAt(i + 1);
			}

			return new ArrayList<>(ls);
		}

		// try inserting . at all possible places in string and check if the produced
		// output is valid.
		void backtrack(Set<String> ls, String s, StringBuilder sb, int ind, int n) {

			if (n == 0) {
				if (checkString(sb))
					ls.add(sb.toString());
				return;
			}

			for (int i = ind; i < s.length(); i++) {
				sb.insert(i + 1 + 3 - n, '.'); // this is done to adjust for the inserted . in previous calls, to find
												// the next right place to insert .
				// 3-n is added as offset because we can at max insert 3 dots to check if string
				// is valid.
				// so this offsets the insertion position based on how many dots were inserted
				// by now as string length would increase by that amount
				backtrack(ls, s, sb, ind + 1, n - 1);
				sb.deleteCharAt(i + 1 + 3 - n);
			}

		}

		boolean checkString(StringBuilder sb) {
			if (sb.charAt(sb.length() - 1) == '.')
				return false;

			String[] str = sb.toString().split("\\."); // only . in split wont work as it is a metacharacter
			for (String val : str) {

				if (val.length() > 3 || val.length() < 1) // each part should be valid length
					return false;
				if (val.length() > 1 && val.charAt(0) == '0')
					return false; // leading zeros
				int num = Integer.parseInt(val);
				if (num > 255) // each part should be valid int value
					return false;
			}

			return true;
		}
	}
}
