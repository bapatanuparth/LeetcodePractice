package leetcode150daysStackAndQueue;

import java.util.Arrays;
import java.util.Stack;

//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.

public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] A) {
		int n = A.length, res[] = new int[n];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n * 2; i++) {
			while (!stack.isEmpty() && A[stack.peek()] < A[i % n])
				res[stack.pop()] = A[i % n];
			stack.push(i % n);
		}
		return res;
	}

}
