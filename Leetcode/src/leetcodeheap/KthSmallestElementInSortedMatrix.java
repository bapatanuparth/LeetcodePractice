package leetcodeheap;

import java.util.PriorityQueue;
import java.util.Queue;

//Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
//
//Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//You must find a solution with a memory complexity better than O(n2).

public class KthSmallestElementInSortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {

		int m = matrix.length;
		int n = matrix[0].length;

		Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

		for (int row = 0; row < Math.min(m, k); row++) {
			// save [value, row, col] for 0th column in heap
			q.offer(new int[] { matrix[row][0], row, 0 });
		}

		int ans = 0;
		// run a loop k times, starting from lowest element which will be to of minheap
		for (int i = 1; i <= k; i++) {
			int top[] = q.poll();

			// current row and column of the element in sorted order
			int r = top[1], c = top[2];
			ans = top[0];
			// enter the next row element in the queue to be considered as a valid element
			if (c + 1 < n) {
				q.offer(new int[] { matrix[r][c + 1], r, c + 1 });
			}
		}

		return ans;

	}
}
