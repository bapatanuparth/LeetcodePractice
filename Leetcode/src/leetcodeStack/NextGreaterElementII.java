package leetcodeStack;

import java.util.Arrays;
import java.util.Stack;

//Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
//
//The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
public class NextGreaterElementII {

	public int[] nextGreaterElements(int[] nums) {
		int n = nums.length;

		// using temp array of size 2*n
		// use the same logic as next greater element 1 and calculate
		int arr[] = new int[2 * n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = nums[i % n];
		}

		Stack<Integer> st = new Stack<>();

		int res[] = new int[n];
		Arrays.fill(res, -1);
		for (int i = 0; i < arr.length; i++) {

			while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
				res[st.peek() % n] = nums[i % n];
				st.pop();
			}
			st.push(i);
		}

		return res;
	}
}
