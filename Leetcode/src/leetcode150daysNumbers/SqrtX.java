package leetcode150daysNumbers;

//Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//
//You must not use any built-in exponent function or operator.
//
//For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

public class SqrtX {

	public int mySqrt(int x) {
		if (x < 2)
			return x;
		long num = 0;
		int left = 0, right = x / 2;
		int pivot = 0;
		while (left <= right) {
			pivot = left + (right - left) / 2;
			num = (long) pivot * pivot;
			if (num > x)
				right = pivot - 1;
			else if (num < x)
				left = pivot + 1;
			else
				return pivot;
		}
		return right;
	}
}
