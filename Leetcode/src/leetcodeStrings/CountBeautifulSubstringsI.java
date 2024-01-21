package leetcodeStrings;

public class CountBeautifulSubstringsI {

	public int beautifulSubstrings(String s, int k) {
		int[] vow = new int[s.length()];
		int[] cons = new int[s.length()];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (checkVow(ch)) {
				vow[i] = i == 0 ? 1 : vow[i - 1] + 1;
				cons[i] = i == 0 ? 0 : cons[i - 1];
			} else {
				vow[i] = i == 0 ? 0 : vow[i - 1];
				cons[i] = i == 0 ? 1 : cons[i - 1] + 1;
			}
		}
		int count = 0;

		for (int i = 1; i < s.length(); i++) {
			if (vow[i] == cons[i] && (vow[i] * cons[i]) % k == 0)
				count++;
			for (int j = 0; j < i; j++) {
				int subvow = vow[i] - vow[j];
				int subcons = cons[i] - cons[j];
				if (subvow == subcons && (subvow * subcons) % k == 0)
					count++;
			}
		}

		return count;
	}

	boolean checkVow(char ch) {
		if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
			return true;
		return false;
	}

}
