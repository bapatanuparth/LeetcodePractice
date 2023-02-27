package leetcodeDynamicProgramming;

//Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

//Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//Output: 3
public class MaxLengthRepeatedSubarray {

	// suppose the max length common subarray starts from nums1[i..] and nums2[j..]
	// for every common character we encounter in both arrays, increase the count of
	// the diagonally
	// next dp[i][j]
	public int findLength(int[] nums1, int[] nums2) {

		int ans = 0;
		int dp[][] = new int[nums1.length + 1][nums2.length + 1];

		for (int a = 1; a <= nums1.length; a++) {

			for (int b = 1; b <= nums2.length; b++) {

				if (nums1[a - 1] == nums2[b - 1]) {
					dp[a][b] = 1 + dp[a - 1][b - 1];
				}
				if (dp[a][b] > ans)
					ans = dp[a][b];
			}
		}
		return ans;
	}
}
