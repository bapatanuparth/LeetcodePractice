package leetcode150daysStrings;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		int a = 1;
		Map<Character, Integer> map1 = new HashMap<>();
		for (char c : s.toCharArray()) {
			if (!map1.containsKey(c)) {
				map1.put(c, a);
				a++;
			}
		}
		a = 1;
		Map<Character, Integer> map2 = new HashMap<>();
		for (char temp : t.toCharArray()) {
			if (!map2.containsKey(temp)) {
				map2.put(temp, a);
				a++;
			}
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb1.append(map1.get(c));
		}

		for (char temp : t.toCharArray()) {
			sb2.append(map2.get(temp));
		}

		return sb1.toString().equals(sb2.toString());

	}
}
