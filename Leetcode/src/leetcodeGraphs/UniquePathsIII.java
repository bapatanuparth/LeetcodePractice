package leetcodeGraphs;

//You are given an m x n integer array grid where grid[i][j] could be:
//
//1 representing the starting square. There is exactly one starting square.
//2 representing the ending square. There is exactly one ending square.
//0 representing empty squares we can walk over.
//-1 representing obstacles that we cannot walk over.
//Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
public class UniquePathsIII {

	int count = 0;

	public int uniquePathsIII(int[][] grid) {

		// when we reach destination, everytime check whether all the visited array is
		// filled or not
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int src[] = new int[2];
		int dest[] = new int[2];

		for (int i = 0; i < grid.length; i++) {

			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == -1) {
					visited[i][j] = true;
				}
				if (grid[i][j] == 1) {
					src[0] = i;
					src[1] = j;
				}
				if (grid[i][j] == 2) {
					dest[0] = i;
					dest[1] = j;
				}
			}
		}

		dfs(grid, visited, src, dest, src[0], src[1]);
		return count;
	}

	void dfs(int[][] grid, boolean[][] visited, int[] src, int[] dest, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] == true)
			return;

		visited[i][j] = true;
		if (i == dest[0] && j == dest[1]) {

			boolean flag = true;
			for (int x = 0; x < visited.length; x++) {
				for (int y = 0; y < visited[0].length; y++) {
					if (visited[x][y] == false) {
						flag = false;
						break;
					}
				}
			}
			if (flag)
				count++;
		}

		dfs(grid, visited, src, dest, i + 1, j);
		dfs(grid, visited, src, dest, i, j + 1);
		dfs(grid, visited, src, dest, i - 1, j);
		dfs(grid, visited, src, dest, i, j - 1);

		visited[i][j] = false;
	};
}
