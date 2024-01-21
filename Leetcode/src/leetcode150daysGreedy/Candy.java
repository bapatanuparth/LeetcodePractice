package leetcode150daysGreedy;

import java.util.Arrays;

public class Candy {

	public int candy(int[] ratings) {

		int left2right[] = new int[ratings.length];
		int[] right2left = new int[ratings.length];
		Arrays.fill(left2right, 1);
		Arrays.fill(right2left, 1);

		// go from left to right, and consider only the the case where i+1 > i
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left2right[i] = left2right[i - 1] + 1;
			}
		}
		// go from rioght to left and consider case where i > i+1 and increment the
		// value
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				right2left[i] = right2left[i + 1] + 1;
			}
		}

		int sum = 0;
		// sum will be the sum of max between these 2 arrays for each element as we will
		// assign the max value to that position
		for (int i = 0; i < ratings.length; i++) {
			sum += Math.max(left2right[i], right2left[i]);
		}

		return sum;

	}
}
