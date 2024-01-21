package leetcode150daysStackAndQueue;

import java.util.Stack;

//Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

public class LargestRerctangleArea {

	public int largestRectangleArea(int[] heights) {
		Stack<int[]> st = new Stack<>();
		int n = heights.length;
		int maxArea = 0;

		for (int i = 0; i < heights.length; i++) {
			if (st.isEmpty()) {
				st.push(new int[] { i, heights[i] });
			} else {
				int temp[] = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
				while (!st.isEmpty() && st.peek()[1] > heights[i]) {

					temp = st.pop();
					maxArea = Math.max(maxArea, (i - temp[0]) * temp[1]);
				}
				st.push(new int[] { Math.min(i, temp[0]), heights[i] });
			}
		}
		while (!st.isEmpty()) {
			int temp[] = st.pop();
			maxArea = Math.max(maxArea, (n - temp[0]) * temp[1]);
		}

		return maxArea;
	}

}
