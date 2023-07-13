package leetcodeBacktrack;

//You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. You are also given an integer k that denotes the number of children to distribute all the bags of cookies to. All the cookies in the same bag must go to the same child and cannot be split up.
//
//The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in the distribution.
//
//Return the minimum unfairness of all distributions.

public class FairDistributionOfCookies {

	// simple backtrack solution

	class Solution {
		int max = Integer.MAX_VALUE;

		public int distributeCookies(int[] cookies, int k) {
			int[] sums = new int[k];
			backtrack(cookies, k, sums, 0);
			return max;
		}

		void backtrack(int[] cookies, int k, int sums[], int ind) {
			if (ind >= cookies.length) {
				max = Math.min(max, getMax(sums));
				return;
			}

			for (int i = 0; i < k; i++) {
				sums[i] += cookies[ind];
				backtrack(cookies, k, sums, ind + 1);
				sums[i] -= cookies[ind];
			}

		}

		int getMax(int[] sums) {
			int max = 0;
			for (int i = 0; i < sums.length; i++) {
				max = Math.max(max, sums[i]);
			}

			return max;
		}
	}

}
