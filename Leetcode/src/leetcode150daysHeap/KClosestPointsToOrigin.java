package leetcode150daysHeap;

import java.util.Arrays;

public class KClosestPointsToOrigin {

	// can be done using heap in O(nlogk)

	// O(nlogn) solution
	public int[][] kClosest(int[][] points, int k) {
		Arrays.sort(points, (a, b) -> squareDistance(a) - squareDistance(b));

		return Arrays.copyOf(points, k);

	}

	private int squareDistance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

	class Solution {
		// quickselect algorithm avg time O(n)
		public int[][] kClosest(int[][] points, int k) {
			int len = points.length, l = 0, r = len - 1;
			while (l <= r) {
				int mid = select(points, l, r);
				if (mid == k)
					break;
				if (mid < k) {
					l = mid + 1;
				} else
					r = mid - 1;
			}

			return Arrays.copyOfRange(points, 0, k);

		}

		int select(int[][] A, int l, int r) {
			int[] pivot = A[r];
			int i = l - 1;
			for (; l < r; l++) {
				if (compare(A[l], pivot) <= 0) {
					i++;
					swap(A, l, i);
				}
			}
			swap(A, i + 1, r);
			return i + 1;
		}

		int compare(int p1[], int p2[]) {
			int dist1 = p1[0] * p1[0] + p1[1] * p1[1];
			int dist2 = p2[0] * p2[0] + p2[1] * p2[1];
			return dist1 - dist2;
		}

		void swap(int[][] arr, int a, int b) {
			int[] temp = arr[a];
			arr[a] = arr[b];
			arr[b] = temp;
		}
	}
}
