package leetcodeGraphs;

//You have a 2-D grid of size m x n representing a box, and you have n balls. The box is open on the top and bottom sides.
//
//Each cell in the box has a diagonal board spanning two corners of the cell that can redirect a ball to the right or to the left.
//
//A board that redirects the ball to the right spans the top-left corner to the bottom-right corner and is represented in the grid as 1.
//A board that redirects the ball to the left spans the top-right corner to the bottom-left corner and is represented in the grid as -1.
//We drop one ball at the top of each column of the box. Each ball can get stuck in the box or fall out of the bottom. A ball gets stuck if it hits a "V" shaped pattern between two boards or if a board redirects the ball into either wall of the box.
//
//Return an array answer of size n where answer[i] is the column that the ball falls out of at the bottom after dropping the ball from the ith column at the top, or -1 if the ball gets stuck in the box.
public class WhereWillTheBallFall {

	class Solution {
		int m;
		int n;

		public int[] findBall(int[][] grid) {

			m = grid.length;
			n = grid[0].length;

			int[] res = new int[n];

			for (int j = 0; j < n; j++) { // start from 1st row and each column
				dfs(grid, 0, j, res, j);
			} // dfs and check whether ball reaches last row or not
			return res;
		}

		private void dfs(int[][] grid, int i, int j, int[] res, int index) {

			// if ball not at the last row and we went out of column sides, res==-1
			if ((j >= n || j < 0) && i < m) {
				res[index] = -1;
				return;
			}

			// if ball goes outside last row and we are still inside box, mark the column
			// whereit goes outside
			if (i == m && (j > 0 || j < n)) {
				res[index] = j;
				return;
			}

			// ball goes down
			if (grid[i][j] == 1 && (j + 1 < n && grid[i][j + 1] == 1)) {
				dfs(grid, i + 1, j + 1, res, index);
			}
			// ball goes down
			else if (grid[i][j] == -1 && (j - 1 >= 0 && grid[i][j - 1] == -1)) {
				dfs(grid, i + 1, j - 1, res, index);
			}
			// if current 1 and next column -1, ball trapped into V shape. similarly for
			// current -1 and past 1
			else {
				res[index] = -1;
				return;
			}

		}
	}

}
