package leetcodeBFS;

import java.util.LinkedList;
import java.util.Queue;

//Given an m x n integer matrix grid, return the maximum score of a path starting at (0, 0) and ending at (m - 1, n - 1) moving in the 4 cardinal directions.
//
//The score of a path is the minimum value in that path.
//
//For example, the score of the path 8 → 4 → 5 → 9 is 4.

public class PathWithMaximumMinimumValue {

	class Solution {
		// 4 directions to a cell's possible neighbors.
		public int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		public int maximumMinimumPath(int[][] grid) {
			int R = grid.length, C = grid[0].length;
			int curScore = Math.min(grid[0][0], grid[R - 1][C - 1]);

			// Start with curScore, check if we can find a path having value equals
			// curScore.
			// If so, return curScore as the maximum score, otherwise, decrease curScore
			// by 1 and repeat these steps.
			int left = 0, right = curScore;
			while (left < right) {
				int mid = (right + left + 1) / 2;

				if (pathExists(grid, mid)) {
					left = mid;
				} else {
					right = mid - 1;
				}
			}

			return left;
		}

		// Check if we can find a path of score equals curScore.
		private boolean pathExists(int[][] grid, int curScore) {
			int R = grid.length, C = grid[0].length;

			// Maintain the visited status of each cell. Initalize the status of
			// all the cells as false (unvisited).
			boolean[][] visited = new boolean[R][C];
			visited[0][0] = true;

			// Put the starting cell grid[0][0] in the deque and mark it as visited.
			Queue<int[]> deque = new LinkedList<>();
			deque.offer(new int[] { 0, 0 });

			// While we still have cells of value larger than or equal to curScore.
			while (!deque.isEmpty()) {
				int[] curGrid = deque.poll();
				int curRow = curGrid[0];
				int curCol = curGrid[1];

				// If the current cell is the bottom-right cell, return true.
				if (curRow == R - 1 && curCol == C - 1) {
					return true;
				}

				for (int[] dir : dirs) {
					int newRow = curRow + dir[0];
					int newCol = curCol + dir[1];

					// Check if the current cell has any unvisited neighbors with value larger
					// than or equal to curScore.
					if (0 <= newRow && newRow < R && 0 <= newCol && newCol < C && visited[newRow][newCol] == false
							&& grid[newRow][newCol] >= curScore) {
						// If so, we put this neighbor to the deque and mark it as visited.
						visited[newRow][newCol] = true;
						deque.offer(new int[] { newRow, newCol });
					}
				}
			}

			// If we empty the deque and still haven't reach the bottom-right cell, return
			// false.
			return false;
		}
	}

}
