package leetcode150daysBFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

	public int shortestPathBinaryMatrix(int[][] grid) {

		if (grid[0][0] == 1)
			return -1;
		int m = grid.length;
		int n = grid[0].length;
		boolean visited[][] = new boolean[m][n];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 },
				{ 1, 1 } };

		int path = 0;
		while (!q.isEmpty()) {

			int size = q.size();

			for (int i = 0; i < size; i++) {
				int[] point = q.poll();

				if (point[0] == m - 1 && point[1] == n - 1)
					return path + 1;

				for (int[] dir : dirs) {
					int nx = point[0] + dir[0];
					int ny = point[1] + dir[1];

					if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny] == 1
							|| visited[nx][ny])
						continue;
					q.add(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}

			path++;
		}

		return -1;
	}
}
