package leetcodeGreedy;

import java.util.Arrays;

public class MinimumCostToMakeArrayEqual {

	public long minCost(int[] nums, int[] cost) {
		int n = nums.length;
		int[][] numsAndCost = new int[n][2];

		for (int i = 0; i < n; i++) {
			numsAndCost[i][0] = nums[i];
			numsAndCost[i][1] = cost[i];
		}
		Arrays.sort(numsAndCost, (a, b) -> a[0] - b[0]);

		// store prefix sum of the array
		long[] prefix = new long[n];
		prefix[0] = numsAndCost[0][1];
		for (int i = 1; i < n; i++) {
			prefix[i] = numsAndCost[i][1] + prefix[i - 1];
		}

		// calculate total cost to make all elements == 1st element
		long totalCost = 0;
		for (int i = 1; i < n; i++) {
			// cost for each element to make = 0th element
			// (ith element - 0th element) * cost of ith element
			totalCost += 1l * (numsAndCost[i][1]) * (numsAndCost[i][0] - numsAndCost[0][0]);
		}

		long answer = totalCost;

		// then we try for nums[1], nums[2]
		for (int i = 1; i < n; i++) {
			// difference between current element and prev element
			int gap = numsAndCost[i][0] - numsAndCost[i - 1][0];
			// to reach here, multiply prefix sum till i-1 with gap and add to the total
			// cost
			totalCost += prefix[i - 1] * gap;
			// at the same time, reduce the cost of all the next elements by the difference
			// as the array is sorted, the current element is greater than prev
			// so we need to compensate for the extra cost we paid to reach the previous
			// element
			totalCost -= 1l * (prefix[n - 1] - prefix[i - 1]) * gap;
			answer = Math.min(answer, totalCost);
		}

		return answer;
	}

}
