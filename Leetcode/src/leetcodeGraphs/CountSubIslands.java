package leetcodeGraphs;

import java.util.ArrayList;
import java.util.List;

import javafx.util.Pair;

//You are given two m x n binary matrices grid1 and grid2 containing only 0's (representing water) and 1's (representing land). An island is a group of 1's connected 4-directionally (horizontal or vertical). Any cells outside of the grid are considered water cells.
//
//An island in grid2 is considered a sub-island if there is an island in grid1 that contains all the cells that make up this island in grid2.
//
//Return the number of islands in grid2 that are considered sub-islands.

public class CountSubIslands {

	// take the co ordinates of ech island of grid2
	// check if the exact co-ordinates are marked as 1 in grid1
	// if yes then u can say that it grid2 has a sub-island of grid1
	public int countSubIslands(int[][] grid1, int[][] grid2) {

		List<List<Pair<Integer, Integer>>> islands = new ArrayList<>();

		int m = grid2.length;
		int n = grid2[0].length;
		boolean[][] vis = new boolean[m][n];

		// traverse grid2 to find all subislands
		for (int i = 0; i < m; i++) {

			for (int j = 0; j < n; j++) {

				if (grid2[i][j] == 1 && !vis[i][j]) {
					List<Pair<Integer, Integer>> list = new ArrayList<>();
					dfs(m, n, i, j, grid2, vis, list);
					islands.add(list);
				}

			}
		}

		int res = 0;
		// check which of the islands in grid2 are subislands of grid1
		for (List<Pair<Integer, Integer>> list : islands) {

			boolean flag = true;
			for (Pair<Integer, Integer> p : list) {
				int x = p.getKey();
				int y = p.getValue();

				if (grid1[x][y] == 0) {
					flag = false;
					break;
				}
			}
			if (flag)
				res++;
		}

		return res;
	}

	// regular dfs code used to mark islands
	void dfs(int m, int n, int i, int j, int[][] grid2, boolean[][] vis, List<Pair<Integer, Integer>> list) {
		if (i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0 || vis[i][j] == true)
			return;

		list.add(new Pair<>(i, j));
		vis[i][j] = true;

		dfs(m, n, i - 1, j, grid2, vis, list);
		dfs(m, n, i, j - 1, grid2, vis, list);
		dfs(m, n, i + 1, j, grid2, vis, list);
		dfs(m, n, i, j + 1, grid2, vis, list);

	}
}
