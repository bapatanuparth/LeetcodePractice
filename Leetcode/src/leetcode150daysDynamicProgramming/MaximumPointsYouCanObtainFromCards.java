package leetcode150daysDynamicProgramming;

//There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
//
//In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
//
//Your score is the sum of the points of the cards you have taken.
//
//Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

public class MaximumPointsYouCanObtainFromCards {

	public int maxScore(int[] arr, int k) {
		int n = arr.length;
		int[] front = new int[k + 1];
		int[] rear = new int[k + 1];

		// calculate prefix sum of both
		for (int i = 0; i < k; i++) {
			front[i + 1] = arr[i] + front[i];
			rear[i + 1] = arr[n - i - 1] + rear[i];
		}

		// either we choose 1 from start, k-1 from end
		// or 2 from start and k-2 from end.
		// so utilize the prefix sums of both start and end
		int max = 0;
		for (int i = 0; i <= k; i++) {
			int curr = front[i] + rear[k - i];
			max = Math.max(max, curr);
		}

		return max;
	}

}
