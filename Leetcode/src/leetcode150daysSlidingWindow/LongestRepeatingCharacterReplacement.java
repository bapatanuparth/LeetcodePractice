package leetcode150daysSlidingWindow;

//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		char arr[] = s.toCharArray();
		int mostFrequent = 0;
		int freq[] = new int[26];
		int max = 0;
		int left = 0;
		for (int right = 0; right < arr.length; right++) {
			freq[arr[right] - 'A']++;
			mostFrequent = Math.max(mostFrequent, freq[arr[right] - 'A']);

			int lettersToChange = right - left + 1 - mostFrequent;
			if (lettersToChange > k) {
				freq[arr[left] - 'A']--;
				left++;
			}
			max = Math.max(max, right - left + 1);
		}

		return max;
	}

}
