package leetCodeArrays2;

//You are given an integer array nums sorted in non-decreasing order.
//
//Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
//
//In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
//
// 

public class SumOfAbsoluteDifferenceInSortedArray {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		long prel[] = new long[nums.length];
		long prer[] = new long[nums.length];
		int n = nums.length;
		prel[0] = nums[0];
		prer[n - 1] = nums[n - 1];
		for (int i = 1; i < nums.length; i++) {
			prel[i] = prel[i - 1] + nums[i];
		}
		for (int i = n - 2; i >= 0; i--) {
			prer[i] = prer[i + 1] + nums[i];
		}

		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			long sumleft = i > 0 ? prel[i - 1] : 0;
			long sumright = i < n - 1 ? prer[i + 1] : 0;
			int v1 = (int) Math.abs(sumright - (nums[i] * (n - i - 1)));
			int v2 = (int) Math.abs(sumleft - (nums[i] * (i)));
			res[i] = v1 + v2;
		}

		return res;
	}

}
