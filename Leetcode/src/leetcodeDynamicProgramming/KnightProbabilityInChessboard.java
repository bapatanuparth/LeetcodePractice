package leetcodeDynamicProgramming;

//On an n x n chessboard, a knight starts at the cell (row, column) and attempts to make exactly k moves. The rows and columns are 0-indexed, so the top-left cell is (0, 0), and the bottom-right cell is (n - 1, n - 1).
//
//A chess knight has eight possible moves it can make, as illustrated below. Each move is two cells in a cardinal direction, then one cell in an orthogonal direction.
//Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.
//
//The knight continues moving until it has made exactly k moves or has moved off the chessboard.
//
//Return the probability that the knight remains on the board after it has stopped moving.

public class KnightProbabilityInChessboard {

	double[][][] dp;
	int[][] dirs = new int[][] { { -2, -1 }, { -2, 1 }, { -1, -2 }, { -1, 2 }, { 1, -2 }, { 1, 2 }, { 2, -1 },
			{ 2, 1 } };

	public double knightProbability(int n, int k, int row, int col) {
		dp = new double[n][n][k + 1];
		if (k == 0)
			return 1;
		// traverse all paths that a knight can take
		return dfs(row, col, k, n);
	}

	double dfs(int i, int j, int k, int n) {
		// if we go out of bounds
		if (i < 0 || j < 0 || i >= n || j >= n)
			return 0;
		// if we still on board after all the moves
		if (k == 0)
			return 1;
		// if we have already been here
		if (dp[i][j][k] != 0)
			return dp[i][j][k];

		double ans = 0;
		for (int[] dir : dirs) {
			int nx = i + dir[0];
			int ny = j + dir[1];
			// there are 8 possible moves
			// the probability after all paths == 1/8 * (probability of each individual
			// path)
			ans = ans + (dfs(nx, ny, k - 1, n) / 8);
		}

		dp[i][j][k] = ans;
		return ans;
	}

}
