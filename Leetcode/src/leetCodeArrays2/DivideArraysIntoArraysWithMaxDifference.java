package leetCodeArrays2;

import java.util.Arrays;

//You are given an integer array nums of size n and a positive integer k.
//
//Divide the array into one or more arrays of size 3 satisfying the following conditions:
//
//Each element of nums should be in exactly one array.
//The difference between any two elements in one array is less than or equal to k.
//Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.

public class DivideArraysIntoArraysWithMaxDifference {

	public int[][] divideArray(int[] nums, int k) {
		Arrays.sort(nums);
		int n = nums.length;

		int[][] res = new int[n / 3][3];
		int a = 0;

		for (int i = 0; i < nums.length;) {
			int j = i;
			int temp[] = new int[3];
			int r = 0;
			while (j < nums.length && nums[j] - nums[i] <= k && r < 3) {
				temp[r] = nums[j];
				j++;
				r++;
			}

			if (r < 3)
				return new int[][] {};

			res[a++] = temp;
			i = j;
		}

		return res;
	}

}
