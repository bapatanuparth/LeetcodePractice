package leetcodeStrings;

import java.util.Arrays;

public class CheckDistanceBetweenSameLetters {

	public boolean checkDistances(String s, int[] distance) {

		int arr[] = new int[26];
		Arrays.fill(arr, -1);

		for (int i = 0; i < s.length(); i++) {
			int ch = s.charAt(i) - 'a';
			if (arr[ch] != -1) {
				int dist = i - arr[ch] - 1;
				if (distance[ch] != dist)
					return false;
			} else {
				arr[ch] = i;
			}
		}

		return true;
	}
}
