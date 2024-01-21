package leetcodeSlidingWindow;

//You are given a string word and an integer k.
//
//A substring s of word is complete if:
//
//Each character in s occurs exactly k times.
//The difference between two adjacent characters is at most 2. That is, for any two adjacent characters c1 and c2 in s, the absolute difference in their positions in the alphabet is at most 2.
//Return the number of complete substrings of word.
//
//A substring is a non-empty contiguous sequence of characters in a string.

public class CountCompleteSubstrings {

	// for a substring to follow the rules, the window can be of size k, 2k, 3k and
	// so on, where either 1 character repeats k times, or 2 chars repeat k
	// times..and so on
	// so we consider all these possible windows and count the strings that follow
	// our requirements

	public int countCompleteSubstrings(String word, int k) {
		int totalUniqueChars = (int) word.chars().distinct().count();
		int count = 0;

		for (int uniqueChars = 1; uniqueChars <= totalUniqueChars; uniqueChars++) {
			int windowSize = uniqueChars * k;
			if (windowSize > word.length()) {
				break;
			}

			int[] charToCount = new int[26];
			for (int i = 0; i < windowSize; i++) {
				charToCount[word.charAt(i) - 'a']++;
			}

			if (isEqualKTimes(charToCount, k) && areAdjacentCharsValid(word, 0, windowSize - 1)) {
				count++;
			}

			for (int start = 1; start <= word.length() - windowSize; start++) {
				charToCount[word.charAt(start - 1) - 'a']--;
				charToCount[word.charAt(start + windowSize - 1) - 'a']++;

				if (isEqualKTimes(charToCount, k) && areAdjacentCharsValid(word, start, start + windowSize - 1)) {
					count++;
				}
			}
		}

		return count;
	}

	private boolean isEqualKTimes(int[] charToCount, int k) {
		for (int count : charToCount) {
			if (count != 0 && count != k) {
				return false;
			}
		}
		return true;
	}

	private boolean areAdjacentCharsValid(String word, int start, int end) {
		for (int i = start; i < end; i++) {
			if (Math.abs(word.charAt(i) - word.charAt(i + 1)) > 2) {
				return false;
			}
		}
		return true;
	}

}
