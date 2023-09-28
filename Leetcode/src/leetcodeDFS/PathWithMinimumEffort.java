package leetcodeDFS;

//You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns, where heights[row][col] represents the height of cell (row, col). You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and you wish to find a route that requires the minimum effort.
//
//A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
//
//Return the minimum effort required to travel from the top-left cell to the bottom-right cell.

public class PathWithMinimumEffort {

	private int m, n;
	private int[][] heights;
	private boolean[][] visited;
	private int[] DIR = { 0, 1, 0, -1, 0 };

	public int minimumEffortPath(int[][] heights) {
		m = heights.length;
		n = heights[0].length;
		this.heights = heights;
		visited = new boolean[m][n];

		int left = 0;
		int ans = 0;
		int right = (int) 1e6;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (canReachDestination(mid)) {
				right = mid - 1; // Try to find better result on the left side
				ans = mid;
			} else {
				left = mid + 1;
			}
		}

		return ans;
	}

	private boolean canReachDestination(int threshold) {
		visited = new boolean[m][n];
		return dfs(0, 0, threshold);
	}

	private boolean dfs(int r, int c, int threshold) {
		if (r == m - 1 && c == n - 1) {
			return true; // Reach destination
		}
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + DIR[i];
			int nc = c + DIR[i + 1];
			if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]
					&& Math.abs(heights[nr][nc] - heights[r][c]) <= threshold) {
				if (dfs(nr, nc, threshold)) {
					return true;
				}
			}
		}
		return false;
	}

}
