package leetcodeDynamicProgramming;

//You are given two 0-indexed integer arrays, cost and time, of size n representing the costs and the time taken to paint n different walls respectively. There are two painters available:
//
//A paid painter that paints the ith wall in time[i] units of time and takes cost[i] units of money.
//A free painter that paints any wall in 1 unit of time at a cost of 0. But the free painter can only be used if the paid painter is already occupied.
//Return the minimum amount of money required to paint the n walls.

public class PaintingTheWalls {

	int[][] memo;

	public int paintWalls(int[] cost, int[] time) {
		int n = time.length;
		memo = new int[n][n + 1];
		return dfs(cost, time, 0, 0);
	}

	int dfs(int cost[], int time[], int i, int coveredTime) {

		if (coveredTime >= time.length)
			return 0;

		if (i == cost.length) {
			return 1000000000;
		}

		if (memo[i][coveredTime] != 0)
			return memo[i][coveredTime];

		int paid = cost[i] + dfs(cost, time, i + 1, coveredTime + time[i] + 1);
		int free = dfs(cost, time, i + 1, coveredTime);

		return memo[i][coveredTime] = Math.min(paid, free);

	}

}
