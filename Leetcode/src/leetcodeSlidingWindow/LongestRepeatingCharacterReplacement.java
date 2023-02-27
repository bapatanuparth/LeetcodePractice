package leetcodeSlidingWindow;

//You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
//
//Return the length of the longest substring containing the same letter you can get after performing the above operations.

//Input: s = "ABAB", k = 2
//Output: 4
public class LongestRepeatingCharacterReplacement {

	public int characterReplacement(String s, int k) {
		int left = 0, right = 0;
		char[] arr = s.toCharArray();

		int temp = k;
		char ch = arr[left];
		int count = 0;

		for (left = 0; left < s.length();) {
			if (right >= s.length()) {
				if (right - left + temp > count) { // for the case in which the last consecutive numbers length is the
													// greatest
					count = right - left;
					if (temp > 0)
						count += temp; // we need to add temp in count to add in previous characters that are not equal
										// to last characters
				}
				break;
			}

			// if left == right, keep going ahead till k > 0
			if (arr[left] == arr[right]) {
				right++;
			}

			// if left != right, reduce the k value, if its < 0 it means we have exhausted
			// all characters that can be changed
			// so we reset the left , right and k value and start again
			else if (arr[left] != arr[right]) {
				temp--;
				if (temp < 0) {
					count = Math.max(count, right - left);
					while (arr[left] == ch)
						left++;
					// reset right, left and ch to the new character to be checked for
					ch = arr[left];
					right = left;
					temp = k;
				} else
					right++;
			}
		}

		// check for the case if we have added more offset than required
		if (count > s.length())
			count = s.length();
		return count;

	}

}
