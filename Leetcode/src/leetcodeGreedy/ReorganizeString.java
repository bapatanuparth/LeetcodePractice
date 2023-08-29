package leetcodeGreedy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//
//Return any possible rearrangement of s or return "" if not possible.

//Input: s = "aab"
//Output: "aba"
public class ReorganizeString {

	// O(n) better solution
	public String reorganizeStringOn(String s) {

		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			freq[ch - 'a']++;
		}
		// calculate maximum freq character
		int max = 0, maxi = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] > max) {
				max = freq[i];
				maxi = i;
			}
		}
		if (max > (s.length() + 1) / 2)
			return "";
		int idx = 0;
		char res[] = new char[s.length()];
		// put it on indices 0 2 4 6 ...
		while (freq[maxi] > 0) {
			res[idx] = (char) ('a' + maxi);
			idx += 2;
			freq[maxi]--;
		}
		// other characters can be in any order in between
		// so start from 1 3 5 and go on filling the remaining characters
		for (int i = 0; i < 26; i++) {
			while (freq[i] > 0) {
				if (idx >= res.length)
					idx = 1;
				res[idx] = (char) ('a' + i);
				idx += 2;
				freq[i]--;
			}
		}

		return String.valueOf(res);

	}

	public String reorganizeString(String s) {

		// store the frequency of occurrence of each element
		Map<Character, Integer> map = new HashMap<>();

		for (char ch : s.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		// reverse order the elements by their frequency value
		Queue<Character> q = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

		q.addAll(map.keySet());

		StringBuilder sb = new StringBuilder();

		while (q.size() > 1) {
			// get 2 most largest frequency elements
			char ch1 = q.poll();
			char ch2 = q.poll();

			// put them adjacent
			sb.append(ch1);
			sb.append(ch2);

			// reduce their freq by 1 and add them in queue again until they have freq >=1
			int temp1 = map.get(ch1) - 1;
			int temp2 = map.get(ch2) - 1;

			if (temp1 >= 1) {
				map.replace(ch1, temp1);
				q.add(ch1);
			}
			if (temp2 >= 1) {
				map.replace(ch2, temp2);
				q.add(ch2);
			}
		}

		// q not empty if an odd single element is left
		if (!q.isEmpty()) {
			char ch = q.poll();
			if (map.get(ch) > 1) // if the frequency of the element >1 it means it has appeared more than half
									// the length of the array
				return "";// return empty string
			else
				sb.append(ch);
		}

		return sb.toString();

	}
}
