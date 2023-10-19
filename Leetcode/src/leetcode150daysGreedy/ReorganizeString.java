package leetcode150daysGreedy;

//Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//
//Return any possible rearrangement of s or return "" if not possible.

public class ReorganizeString {

	public String reorganizeString(String s) {

		int[] freq = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			freq[ch - 'a']++;
		}

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

		while (freq[maxi] > 0) {
			res[idx] = (char) ('a' + maxi);
			idx += 2;
			freq[maxi]--;
		}

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

}
