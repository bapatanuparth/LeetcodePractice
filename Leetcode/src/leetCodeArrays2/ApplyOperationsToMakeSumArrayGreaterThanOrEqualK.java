package leetCodeArrays2;

//You are given a positive integer k. Initially, you have an array nums = [1].
//
//You can perform any of the following operations on the array any number of times (possibly zero):
//
//Choose any element in the array and increase its value by 1.
//Duplicate any element in the array and add it to the end of the array.
//Return the minimum number of operations required to make the sum of elements of the final array greater than or equal to k.

public class ApplyOperationsToMakeSumArrayGreaterThanOrEqualK {

	public int minOperations(int k) {
		int res = k + 1;
		for (int i = 1; i <= k; i++) {
			int vertical = i - 1; // signifies the number of steps we need to increase one vertically to get to i
			int horizontal = 0; // signifies number of times we need to duplicate i so that sum>=k
			if (k % i == 0) {
				horizontal = k / i - 1;
			} else
				horizontal = k / i;

			res = Math.min(res, vertical + horizontal);
		}

		return res;
	}

}
