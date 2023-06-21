package leetcodeMatrix;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EqualRowAndColumnPairs {

	// this can be done in n3 using brute force

	class Solution {

		// this is n2 approach by hashing
		// we create a string for each row and count the frequency of occurrence of each
		// string
		// now for each column, we see if the string already exists, if it does, then
		// out column matches those many rows
		public int equalPairs(int[][] grid) {
			int count = 0;
			int n = grid.length;

			// Keep track of the frequency of each row.
			Map<String, Integer> rowCounter = new HashMap<>();
			for (int[] row : grid) {
				String rowString = Arrays.toString(row);
				rowCounter.put(rowString, 1 + rowCounter.getOrDefault(rowString, 0));
			}

			// Add up the frequency of each column in map.
			for (int c = 0; c < n; c++) {
				int[] colArray = new int[n];
				for (int r = 0; r < n; ++r) {
					colArray[r] = grid[r][c];
				}
				count += rowCounter.getOrDefault(Arrays.toString(colArray), 0);
			}

			return count;
		}
	}

}
