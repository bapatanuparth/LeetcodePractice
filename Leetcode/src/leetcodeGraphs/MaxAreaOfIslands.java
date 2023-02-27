package leetcodeGraphs;

//You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
//The area of an island is the number of cells with a value 1 in the island.
//
//Return the maximum area of an island in grid. If there is no island, return 0.
public class MaxAreaOfIslands {

	// we need count value to be available across functions so send it as an object
	class Count {
		int val;

		Count() {
			val = 0;
		}
	}

	public int maxAreaOfIsland(int[][] grid) {

		int m = grid.length;
		int n = grid[0].length;
		int res = 0;
		boolean visited[][] = new boolean[m][n];

		// scan through whole graph
		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				Count c = new Count();
				if (!visited[i][j] && grid[i][j] == 1) {
					// if found 1, use DFS to check how many ones are there
					dfs(m, n, i, j, grid, visited, c);
				}

				// store maximum area count in res
				res = Math.max(res, c.val);
			}
		}

		return res;
	}

	// basic dfs function, check for all adjacent sides
	void dfs(int m, int n, int i, int j, int[][] grid, boolean[][] visited, Count c) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j] == true)
			return;

		c.val++;
		visited[i][j] = true;

		dfs(m, n, i - 1, j, grid, visited, c);
		dfs(m, n, i, j - 1, grid, visited, c);
		dfs(m, n, i + 1, j, grid, visited, c);
		dfs(m, n, i, j + 1, grid, visited, c);
	}
}
