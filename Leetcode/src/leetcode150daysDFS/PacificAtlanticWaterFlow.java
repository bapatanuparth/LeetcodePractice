package leetcode150daysDFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.
//
//The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
//
//The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.
//
//Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.

public class PacificAtlanticWaterFlow {

	int[][] dirs = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int m = heights.length, n = heights[0].length;
		boolean[][] pv = new boolean[m][n];
		boolean[][] av = new boolean[m][n];
		for (int i = 0; i < n; i++) {
			dfs(heights, pv, 0, i);
			dfs(heights, av, m - 1, i);
		}
		for (int i = 0; i < m; i++) {
			dfs(heights, pv, i, 0);
			dfs(heights, av, i, n - 1);
		}
		List<List<Integer>> l = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (pv[i][j] && av[i][j])
					l.add(Arrays.asList(i, j));
			}
		}
		return l;
	}

	private void dfs(int[][] hs, boolean[][] v, int row, int col) {
		v[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int r = row + dirs[i][0];
			int c = col + dirs[i][1];
			if (r >= 0 && r < hs.length && c >= 0 && c < hs[0].length && hs[r][c] >= hs[row][col] && !v[r][c]) {
				dfs(hs, v, r, c);
			}
		}
	}

}
