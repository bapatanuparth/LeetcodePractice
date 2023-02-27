package leetcodeGreedy;

//A string s is called happy if it satisfies the following conditions:
//
//s only contains the letters 'a', 'b', and 'c'.
//s does not contain any of "aaa", "bbb", or "ccc" as a substring.
//s contains at most a occurrences of the letter 'a'.
//s contains at most b occurrences of the letter 'b'.
//s contains at most c occurrences of the letter 'c'.
//Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".
//
//A substring is a contiguous sequence of characters within a string.
public class LongestHappyString {
	public String longestDiverseString(int a, int b, int c) {
		int totalsize = a + b + c;
		StringBuilder sb = new StringBuilder();
		int A = 0, B = 0, C = 0; // represents the # of time a,b, or c have previously occurred continuously

		for (int i = 0; i < totalsize; i++) {

			if ((a >= b && a >= c && A < 2) || (B == 2 && a > 0 && A < 2) || (C == 2 && a > 0 && A < 2)) {
				sb.append('a');
				a--;
				A++;
				B = 0;
				C = 0;
			}

			else if ((b >= a && b >= c && B < 2) || (A == 2 && b > 0 && B < 2) || (C == 2 && b > 0 && B < 2)) {
				sb.append('b');
				B++;
				b--;
				A = 0;
				C = 0;
			} else if ((c >= a && c >= b && C < 2) || (A == 2 && c > 0 && C < 2) || (B == 2 && c > 0 && C < 2)) {
				sb.append('c');
				C++;
				c--;
				A = 0;
				B = 0;
			}
		}
		return sb.toString();
	}

}
