package leetcode150daysGraph;

//You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.
//
//Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
//
//The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

public class IslandPerimeter {

	public int islandPerimeter(int[][] grid) {
		if (grid == null)
			return 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return getPerimeter(grid, i, j);
				}
			}
		}
		return 0;
	}

	public int getPerimeter(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return 1;
		}
		if (grid[i][j] == 0) {
			return 1;
		}
		if (grid[i][j] == -1)
			return 0;

		int count = 0;
		grid[i][j] = -1;

		count += getPerimeter(grid, i - 1, j);
		count += getPerimeter(grid, i, j - 1);
		count += getPerimeter(grid, i, j + 1);
		count += getPerimeter(grid, i + 1, j);

		return count;

	}

	public int islandPerimeterM2(int[][] grid) {

		int row = grid.length;
		int col = grid[0].length;
		int peri = 0;

		for (int i = 0; i < row; i++) {

			for (int j = 0; j < col; j++) {
				if (grid[i][j] == 0)
					continue;

				// check top
				if (i == 0 || grid[i - 1][j] == 0)
					peri++;

				// check left
				if (j == 0 || grid[i][j - 1] == 0)
					peri++;

				// check bottom
				if (i == row - 1 || grid[i + 1][j] == 0)
					peri++;

				if (j == col - 1 || grid[i][j + 1] == 0)
					peri++;
			}
		}

		return peri;
	}

}
