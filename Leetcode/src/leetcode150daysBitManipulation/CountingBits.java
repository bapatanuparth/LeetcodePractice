package leetcode150daysBitManipulation;

public class CountingBits {
	public class Solution {
		public int[] countBits(int num) {
			int[] ans = new int[num + 1];
			for (int x = 1; x <= num; ++x) {
				ans[x] = ans[x & (x - 1)] + 1; // we add 1 to the number of set bets that were there in x-1
				// this holds because in every consecutive number we are changing only 1 bit
				// position
			}
			return ans;
		}
	}

	// naive approach
	public int[] countBits(int n) {
		if (n == 0)
			return new int[] { 0 };
		int[] ans = new int[n + 1];
		ans[1] = 1;
		// check for each bit position whether it is 1 or 0
		for (int i = 2; i <= n; i++) {
			int count = 0;
			for (int j = 0; j < 32; j++) {
				if (((i >> j) & 1) == 1)
					count++;
			}
			ans[i] = count;
		}

		return ans;
	}

}
