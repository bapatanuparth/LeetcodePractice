package leetcodeDFS;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

public class NumberOfIslands {

	class Solution {
		public int numIslands(char[][] grid) {

			boolean visited[][] = new boolean[grid.length][grid[0].length];
			int islands = 0;

			for (int i = 0; i < grid.length; i++) {

				for (int j = 0; j < grid[0].length; j++) {

					if (visited[i][j] == false && grid[i][j] == '1') {
						islands++;
						gridbfs(grid, visited, i, j);
					}
				}
			}
			return islands;

		}

		void gridbfs(char[][] grid, boolean[][] visited, int i, int j) {
			if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j] == true)
				return;

			visited[i][j] = true;
			gridbfs(grid, visited, i + 1, j);
			gridbfs(grid, visited, i, j + 1);
			gridbfs(grid, visited, i - 1, j);
			gridbfs(grid, visited, i, j - 1);
		}

	}

}
