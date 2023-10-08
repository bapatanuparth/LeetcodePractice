package leetcode150daysDynamicProgramming;

//You are given an encoded string s. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
//
//If the character read is a letter, that letter is written onto the tape.
//If the character read is a digit d, the entire current tape is repeatedly written d - 1 more times in total.
//Given an integer k, return the kth letter (1-indexed) in the decoded string.

public class DecodedStringIndex {

	public String decodeAtIndex(String S, int K) {
		long size = 0;
		int N = S.length();

		// Find size = length of decoded string
		for (int i = 0; i < N; ++i) {
			char c = S.charAt(i);
			if (Character.isDigit(c))
				size *= c - '0';
			else
				size++;
		}

		for (int i = N - 1; i >= 0; --i) {
			char c = S.charAt(i);
			K %= size;
			if (K == 0 && Character.isLetter(c))
				return Character.toString(c);

			if (Character.isDigit(c))
				size /= c - '0';
			else
				size--;
		}

		throw null;
	}
}
