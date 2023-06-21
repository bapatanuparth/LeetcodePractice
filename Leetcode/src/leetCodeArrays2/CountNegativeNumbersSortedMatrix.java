package leetCodeArrays2;
//Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, return the number of negative numbers in grid.

public class CountNegativeNumbersSortedMatrix {

	// O(n+m)
	public int countNegatives(int[][] grid) {
		int ans = 0;
		int n = grid.length;
		int m = grid[0].length;
		// once we come across a negative number in a row, we can discard all the
		// numbers below that as column also decreasing in order

		int i = 0;
		int j = m - 1;
		for (; i < n; i++) {
			for (; j >= 0; j--) {
				if (grid[i][j] < 0) {
					ans += (n - i);
				} else
					break;
			}
		}

		return ans;
	}

}
