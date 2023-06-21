package leetcodeStrings;

public class LexicographicallySmallestStringAfterSubstringOperation {

	// we need to be careful about a's in the string
	// Do not turn any leading As to Zs as we need lexicographically smallest string
	// having z in the beginning will make it lexicographically greater
	// 3 possibilities--
	// 1. string has all A's == only switch last single charactter to z
	// 2. string has A somewhere -- we pick all non-A elements before A and then
	// turn them
	// 3. String has no A == turn the whole string
	public String smallestString(String s) {

		// map which character every character maps to, one character behind that
		// character
		char[] map = new char[] { 'z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
				'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y' };

		// check if there is any non-A element
		boolean change = false;

		// find first non-a spot
		int i = 0;
		while (i < s.length() && s.charAt(i) == 'a')
			i++;
		// go ahead till we get a substring of non A elements
		int j = i;
		while (j < s.length() && s.charAt(j) != 'a') {
			j++;
			change = true;
		}

		String res = "";
		// if all A, then treat separately
		if (change == false)
			return allA(s);
		else {
			// else, get first elements that are A
			// + switch the middle elements till the next A or string end
			// get the remaining elements after an A without switching them
			res = "" + s.substring(0, i) + createString(s, map, i, j) + s.substring(j, s.length());
		}
		return res;

	}

	// handle all A case
	String allA(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length() - 1; i++) {
			sb.append('a');
		}

		sb.append('z');

		return sb.toString();
	}

	// create a substring with switching the character to appropriate previous
	// character

	String createString(String s, char[] map, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for (int i = start; i < end; i++) {
			sb.append(map[s.charAt(i) - 'a']);
		}

		return sb.toString();
	}

}
