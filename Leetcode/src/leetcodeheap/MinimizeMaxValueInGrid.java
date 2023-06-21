package leetcodeheap;

import java.util.PriorityQueue;

//You are given an m x n integer matrix grid containing distinct positive integers.
//
//You have to replace each integer in the matrix with a positive integer satisfying the following conditions:
//
//The relative order of every two elements that are in the same row or column should stay the same after the replacements.
//The maximum number in the matrix after the replacements should be as small as possible.
//The relative order stays the same if for all pairs of elements in the original matrix such that grid[r1][c1] > grid[r2][c2] where either r1 == r2 or c1 == c2, then it must be true that grid[r1][c1] > grid[r2][c2] after the replacements.
//
//For example, if grid = [[2, 4, 5], [7, 3, 9]] then a good replacement could be either grid = [[1, 2, 3], [2, 1, 4]] or grid = [[1, 2, 3], [3, 1, 4]].
//
//Return the resulting matrix. If there are multiple answers, return any of them.

public class MinimizeMaxValueInGrid {

	class Solution {
		public int[][] minScore(int[][] grid) {
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

			// get all the points from the grid in ascending order
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					pq.add(new int[] { i, j, grid[i][j] });
				}
			}
			// here, we store the maximum value we have seen till now for ith row and column
			int[] maxRow = new int[grid.length];
			int[] maxCol = new int[grid[0].length];

			// for each point we fetch in order, it is going to be greater than any
			// previously seen point
			// so what we need to do is, find the max value in the current rowe and column
			// till now and put next number as the next point, update max values
			// this way for each row and column, we greedily get numbers in ascendding order
			// and make sure that the order is maintained, using extra space to store max
			// row and col values, we ensure that no duplicates are there in current row and
			// col
			while (!pq.isEmpty()) {
				int[] point = pq.poll();
				int i = point[0], j = point[1];
				int maxR = maxRow[i];
				int maxC = maxCol[j];
				int newVal = Math.max(maxR, maxC) + 1;
				grid[i][j] = newVal;
				maxRow[i] = newVal;
				maxCol[j] = newVal;
			}

			return grid;
		}
	}

}
