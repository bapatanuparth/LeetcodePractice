package leetcode150daysDynamicProgramming;

//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

public class FibonacciNumber {

	public int fib(int n) {
		if (n == 0)
			return 0;
		int[] arr = new int[n + 1];
		arr[1] = 1;
		for (int i = 2; i < arr.length; i++) {
			arr[i] = arr[i - 2] + arr[i - 1];
		}
		return arr[arr.length - 1];
	}
}
