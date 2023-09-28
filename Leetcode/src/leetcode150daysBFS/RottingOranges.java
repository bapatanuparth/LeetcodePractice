package leetcode150daysBFS;

import java.util.LinkedList;
import java.util.Queue;

//You are given an m x n grid where each cell can have one of three values:
//
//0 representing an empty cell,
//1 representing a fresh orange, or
//2 representing a rotten orange.
//Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
//
//Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

public class RottingOranges {

	public int orangesRotting(int[][] grid) {

		if (grid == null || grid.length == 0)
			return 0;
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		int count_fresh = 0;
		// Put the position of all rotten oranges in queue
		// count the number of fresh oranges
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 2) {
					queue.add(new int[] { i, j });
				} else if (grid[i][j] == 1)
					count_fresh++;
			}
		}
		if (count_fresh == 0)
			return 0;

		int count = 0;
		int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] point = queue.poll();

				for (int[] dir : dirs) {
					int x = point[0] + dir[0];
					int y = point[1] + dir[1];

					if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2 || grid[x][y] == 0)
						continue;

					grid[x][y] = 2;
					queue.add(new int[] { x, y });
					count_fresh--;
				}
			}
			count++;
		}

		return count_fresh == 0 ? count - 1 : -1;
	}

}
