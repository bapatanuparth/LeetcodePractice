package leetCodeArrays2;

//Given a positive integer n, find the pivot integer x such that:
//
//The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
//Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.

public class FindPivotInteger {

	public int pivotInteger(int n) {
		int presum[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			presum[i] = i + presum[i - 1];
		}

		for (int i = 1; i <= n; i++) {
			if (presum[i] == presum[n] - presum[i - 1])
				return i;
		}

		return -1;
	}
}
