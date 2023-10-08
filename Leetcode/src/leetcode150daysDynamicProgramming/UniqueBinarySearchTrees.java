package leetcode150daysDynamicProgramming;

public class UniqueBinarySearchTrees {

	int dp[][];

	public int numTrees(int n) {
		dp = new int[20][20];
		return countBST(1, n);
	}

	int countBST(int start, int end) {

		if (start >= end)
			return 1;

		if (dp[start][end] != 0)
			return dp[start][end];

		int ways = 0;
		for (int root = start; root <= end; root++) {
			int left = countBST(start, root - 1);
			int right = countBST(root + 1, end);
			ways += (left * right);
		}

		return dp[start][end] = ways;
	}

}
