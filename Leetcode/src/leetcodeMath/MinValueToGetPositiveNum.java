package leetcodeMath;
//Given an array of integers nums, you start with an initial positive value startValue.

//
//In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
//
//Return the minimum positive value of startValue such that the step by step sum is never less than 1.

public class MinValueToGetPositiveNum {

	public int minStartValue(int[] nums) {
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i : nums) {
			sum += i;
			if (sum < min) {
				min = sum;
			}
		}

		if (min >= 0)
			return 1;
		else {
			min = Math.abs(min) + 1;
		}

		return min;
	}
}
