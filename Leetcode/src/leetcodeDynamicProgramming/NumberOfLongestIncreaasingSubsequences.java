package leetcodeDynamicProgramming;

public class NumberOfLongestIncreaasingSubsequences {

	public int findNumberOfLIS(int[] nums) {

		int[] length = new int[nums.length];
		int[] count = new int[nums.length];

		int lengthLis = 0, countLis = 0;

		// traverse array in reverse order
		for (int i = nums.length - 1; i >= 0; i--) {
			int maxLen = 1;
			int maxCnt = 1;

			// for each element after ith index, find if we are abe to make an increasing
			// subsequence.
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] > nums[i]) {
					// in this case, see if we get a subsequence of greater size than all
					// subsequences found till now for index i
					if (length[j] + 1 > maxLen) {
						maxLen = length[j] + 1; // if yes, then this is the longest subseq starting from i
						maxCnt = count[j];
					}
					// if we find subsequence exactly of size maxLength, then increment the count of
					// subsequences of that length
					else if (length[j] + 1 == maxLen) {
						maxCnt += count[j];
					}
				}
			}

			// maintain a running max for longest length and count over the whole array
			if (maxLen > lengthLis) {
				lengthLis = maxLen;
				countLis = maxCnt;
			} else if (maxLen == lengthLis) {
				countLis += maxCnt;
			}

			length[i] = maxLen;
			count[i] = maxCnt;
		}

		return countLis;
	}
}
