package leetcodeStack;

import java.util.HashMap;
import java.util.Stack;
//The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//
//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//
//For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
//
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

public class NextGreaterElement1 {

	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		// monotonic stack
		// while the new element > st.peek() , the new element is the next greater
		// element than the st.peek()
		// so in map, add this as answer for the element of that index
		for (int i = 0; i < nums2.length; i++) {
			while (!stack.empty() && nums2[i] > stack.peek())
				map.put(stack.pop(), nums2[i]); // nums2[i] will be the answer for all the elements that satisfy the
												// condition
			stack.push(nums2[i]);
		}

		while (!stack.empty())
			map.put(stack.pop(), -1); // fill in the remaining elements as -1

		int[] res = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			res[i] = map.get(nums1[i]);
		}

		return res;
	}
}
