package leetcode150daysDFS;

//The chess knight has a unique movement, it may move two squares vertically and one square horizontally, or two squares horizontally and one square vertically (with both forming the shape of an L). The possible movements of chess knight are shown in this diagaram:
//
//A chess knight can move as indicated in the chess diagram below:

public class KnightDialer {

	int dir[][];
	Integer dp[][];

	public int knightDialer(int n) {
		dir = new int[][] { { 4, 6 }, { 6, 8 }, { 9, 7 }, { 4, 8 }, { 0, 3, 9 }, {}, { 7, 1, 0 }, { 2, 6 }, { 1, 3 },
				{ 2, 4 } };
		dp = new Integer[5001][10];
		int ans = 0;

		for (int i = 0; i <= 9; i++) {
			ans += dfs(i, n);
			ans %= 1000000007;
		}

		return ans;
	}

	int dfs(int node, int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		if (dp[n][node] != null)
			return dp[n][node];
		int ways = 0;

		for (int child : dir[node]) {
			ways += dfs(child, n - 1);
			ways = ways % 1000000007;
		}

		return dp[n][node] = ways;
	}

}
