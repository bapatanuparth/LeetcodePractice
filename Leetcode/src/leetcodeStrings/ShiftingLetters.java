package leetcodeStrings;

//You are given a string s of lowercase English letters and an integer array shifts of the same length.
//
//Call the shift() of a letter, the next letter in the alphabet, (wrapping around so that 'z' becomes 'a').
//
//For example, shift('a') = 'b', shift('t') = 'u', and shift('z') = 'a'.
//Now for each shifts[i] = x, we want to shift the first i + 1 letters of s, x times.
//
//Return the final string after all such shifts to s are applied.

public class ShiftingLetters {

	public String shiftingLetters(String s, int[] shifts) {
		long presum[] = new long[shifts.length];

		for (int i = shifts.length - 1; i >= 0; i--) {
			presum[i] = i == shifts.length - 1 ? shifts[i] : presum[i + 1] + shifts[i];
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			long a = s.charAt(i) - 'a';
			a = (a + presum[i]) % 26;
			sb.append(String.valueOf((char) (a + 97)));
		}

		return sb.toString();
	}
}
