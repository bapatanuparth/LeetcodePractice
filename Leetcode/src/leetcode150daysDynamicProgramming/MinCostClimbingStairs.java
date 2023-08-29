package leetcode150daysDynamicProgramming;

//You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

//
//You can either start from the step with index 0, or the step with index 1.
//
//Return the minimum cost to reach the top of the floor.
//

public class MinCostClimbingStairs {

	int finalVal = Integer.MAX_VALUE;

	public int minCostClimbingStairs(int[] cost) {

		int[] minCost = new int[cost.length];

		minCost[0] = cost[0];
		minCost[1] = cost[1];

		for (int i = 2; i < cost.length; i++) {
			minCost[i] = cost[i] + Math.min(minCost[i - 1], minCost[i - 2]);
		}

		return Math.min(minCost[cost.length - 2], minCost[cost.length - 1]);

	}
}
