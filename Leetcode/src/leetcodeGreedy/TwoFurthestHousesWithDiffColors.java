package leetcodeGreedy;

//There are n houses evenly lined up on the street,and each house is beautifully painted.You are given a 0-indexed integer array colors of length n,where colors[i]represents the color of the ith house.
//
//Return the maximum distance between two houses with different colors.
//
//The distance between the ith and jth houses is abs(i-j),where abs(x)is the absolute value of x.

public class TwoFurthestHousesWithDiffColors {

//	Greedily, the maximum distance will come from either the pair of the 
	// leftmost house and possibly some house on the right with a different color,
	// or the pair of the rightmost house and possibly some house on the left with a
	// different color.
	public int maxDistance(int[] colors) {
		int max = 0;
		int n = colors.length;
		for (int i = 0; i < colors.length; i++) {
			if (colors[i] != colors[n - 1]) {
				max = Math.max(max, Math.abs(n - 1 - i));
			}
		}

		for (int i = n - 1; i >= 0; i--) {
			if (colors[0] != colors[i]) {
				max = Math.max(max, Math.abs(i - 0));
			}
		}
		return max;
	}
}
