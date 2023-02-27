package leetcodeGraphs;

import java.util.ArrayDeque;
import java.util.Queue;

//Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.
//
//A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
//
//All the visited cells of the path are 0.
//All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
//The length of a clear path is the number of visited cells of this path.

public class ShortestPathInBinaryMatrix {

	// dfs gives TLE. Need to do BFS and mark visited == true while appending to the
	// queue and not while taking out of queue
	public int shortestPathBinaryMatrix(int[][] grid) {

		if (grid[0][0] == 1)
			return -1;

		boolean visited[][] = new boolean[grid.length][grid[0].length];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = true;
		int step = 1;

		while (!q.isEmpty()) {

			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] arr = q.poll();

				if (arr[0] == grid.length - 1 && arr[1] == grid[0].length - 1)
					return step;

				int[][] dir = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 },
						{ -1, -1 } };

				for (int[] next : dir) {
					int m = arr[0] + next[0];
					int n = arr[1] + next[1];

					if (m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] == 1
							|| visited[m][n] == true)
						continue;
					visited[m][n] = true;
					q.add(new int[] { m, n });
				}
			}

			step++;
		}

		return -1;

	}
}
