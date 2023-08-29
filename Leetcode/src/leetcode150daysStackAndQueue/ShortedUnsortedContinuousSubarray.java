package leetcode150daysStackAndQueue;

import java.util.Stack;

//Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.
//
//Return the shortest such subarray and output its length.

public class ShortedUnsortedContinuousSubarray {

	public int findUnsortedSubarray(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		int left = nums.length, right = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
				left = Math.min(left, stack.pop());
			}
			stack.push(i);
		}
		stack.clear();

		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
				right = Math.max(right, stack.pop());
			}
			stack.push(i);
		}

		return right > left ? right - left + 1 : 0;
	}

}
