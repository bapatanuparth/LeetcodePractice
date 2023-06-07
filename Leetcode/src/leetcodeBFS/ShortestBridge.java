package leetcodeBFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//You are given an n x n binary matrix grid where 1 represents land and 0 represents water.
//
//An island is a 4-directionally connected group of 1's not connected to any other 1's. There are exactly two islands in grid.
//
//You may change 0's to 1's to connect the two islands to form one island.
//
//Return the smallest number of 0's you must flip to connect the two islands.

public class ShortestBridge {

	// Run BFS+ BFS
	// first BFS, mark all the cells of the first island and change them to 2
	// next BFS, for all the cells from island1, run BFS to see when you reach the
	// island2
	// keep distance, and increment distance after running the BFS over all the
	// cells of island1
	// repeat till you reach the end

	public int shortestBridge(int[][] grid) {
		int n = grid.length;
		int firstX = -1, firstY = -1;

		// Find any land cell, and we treat it as a cell of island A.
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					firstX = i;
					firstY = j;
					break;
				}
			}
		}

		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();

		q1.add(new int[] { firstX, firstY });
		q2.add(new int[] { firstX, firstY });
		grid[firstX][firstY] = 2;

		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!q1.isEmpty()) {
			int arr[] = q1.poll();
			for (int[] dir : dirs) {
				int nx = arr[0] + dir[0];
				int ny = arr[1] + dir[1];
				if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
					if (grid[nx][ny] == 1) {
						q1.add(new int[] { nx, ny });
						q2.add(new int[] { nx, ny });
						grid[nx][ny] = 2;
					}
				}
			}
		}

		int distance = 0;
		while (!q2.isEmpty()) {
			List<int[]> newbfs = new ArrayList<>();
			while (!q2.isEmpty()) {
				int arr[] = q2.poll();
				for (int[] dir : dirs) {
					int nx = arr[0] + dir[0];
					int ny = arr[1] + dir[1];
					if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
						if (grid[nx][ny] == 1)
							return distance;
						if (grid[nx][ny] == 0) {
							newbfs.add(new int[] { nx, ny });
							grid[nx][ny] = -1;
						}
					}
				}
			}
			distance++;
			q2.addAll(newbfs);
		}

		return distance;

	}
}
