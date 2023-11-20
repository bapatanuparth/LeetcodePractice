package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.
//
//For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
//Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.

public class RestoreIPAddresses {

	List<String> res;

	public List<String> restoreIpAddresses(String s) {
		res = new ArrayList<>();

		permute(0, s, new StringBuilder(), 4);
		return res;
	}

	void permute(int start, String s, StringBuilder sb, int k) {

		if (k == 0 && start >= s.length()) {
			res.add(sb.substring(0, sb.length() - 1).toString());
			return;
		}

		for (int i = start; i < Math.min(s.length(), start + 3); i++) {
			String sub = s.substring(start, i + 1);
			if (!checkSub(sub))
				return;
			sb.append(sub);
			sb.append(".");
			permute(i + 1, s, sb, k - 1);
			sb.delete(sb.length() - sub.length() - 1, sb.length());
		}
	}

	boolean checkSub(String sub) {
		if (sub.charAt(0) == '0' && sub.length() > 1)
			return false;
		if (Integer.parseInt(sub) > 255)
			return false;
		return true;
	}

}
