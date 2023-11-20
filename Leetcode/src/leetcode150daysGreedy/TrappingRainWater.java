package leetcode150daysGreedy;

//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

public class TrappingRainWater {

	public int trap(int[] height) {
		int[] left = new int[height.length];
		int[] right = new int[height.length];
		int n = height.length;
		if (n <= 2)
			return 0;

		left[0] = height[0];
		int lmax = left[0];
		for (int i = 1; i < height.length; i++) {
			lmax = Math.max(lmax, height[i]);
			left[i] = lmax;
		}

		right[n - 1] = height[n - 1];
		int rmax = right[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			rmax = Math.max(rmax, height[i]);
			right[i] = rmax;
		}

		int res = 0;
		for (int i = 1; i < n - 1; i++) {
			res = res + Math.min(left[i], right[i]) - height[i];
		}

		return res;
	}

}
