package leetcodeStrings;

import java.util.Arrays;

//You are given a string word and an integer k.
//
//We consider word to be k-special if |freq(word[i]) - freq(word[j])| <= k for all indices i and j in the string.
//
//Here, freq(x) denotes the 
//frequency
// of the character x in word, and |y| denotes the absolute value of y.
//
//Return the minimum number of characters you need to delete to make word k-special.

public class MinDeletionsToMakeStringKSpecial {

	public int minimumDeletions(String word, int k) {
		// to count freq of each character
		int freq[] = new int[26];
		Arrays.fill(freq, -1);

		int count = 0;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			if (freq[ch - 'a'] == -1) {
				count++;
				freq[ch - 'a'] = 1;
			} else
				freq[ch - 'a']++;
		}
		// now we want to select only a certain set of characters from all the present
		// characters to fulfil the condition
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < count; i++) {
			ans = Math.min(ans, numberOfWays(freq, i, k));
		}

		return ans;

	}

	int numberOfWays(int[] freq, int ignore, int k) {
		Arrays.sort(freq);
		int ways = 0;
		int st = 0;
		// ignore all -1 i.e. characters that are not present
		while (freq[st] == -1)
			st++;
		// ignore is number of characters with lowest freq that we are not going to
		// consider
		// so add to ways required to delete all the occurrences of these characters
		for (int i = 0; i < ignore; i++) {
			ways += freq[i + st];
		}
		// this is our new lowest freq to be considered
		int lowest = freq[ignore + st];
		// for each and every character, get number of ways required to get the
		// difference <= k
		for (int i = ignore + 1 + st; i < freq.length; i++) {
			ways += Math.max(0, (freq[i] - lowest) - k);
		}
		return ways;
	}

}
