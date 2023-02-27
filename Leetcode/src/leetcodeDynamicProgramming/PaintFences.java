package leetcodeDynamicProgramming;

//You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
//
//Every post must be painted exactly one color.
//There cannot be three or more consecutive posts with the same color.
//Given the two integers n and k, return the number of ways you can paint the fence.

public class PaintFences {

	public int numWays(int n, int k) {

		if (n == 1)
			return k;

		int end_same = k;
		int end_diff = k * (k - 1);

		int total = end_same + end_diff;

		for (int i = 3; i <= n; i++) {
			end_same = end_diff;
			end_diff = total * (k - 1);
			total = end_same + end_diff;
		}

		return total;
	}
}
