package leetcodeStack;

import java.util.Arrays;
import java.util.Stack;

//Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. Since the answer may be large, return the answer modulo 109 + 7.

public class SumOfSubarrayMinimums {
//	For a subarray arr, pick the minimum element e_arr to be the 1st appearance of minimum element; for example, the minimum element of [3,1,3,1,2] is at index 1 instead of 3;
//
//			For each element e, consider all the subarray whose minimum element is e, whose index is i;
//			1. find the index of first element e_l to the left of e s.t. e_l <= e;
//			2. find the index of first element e_r tp the right of e s.t. e_r < e;
//
//			Denote the index of e_l as i_l and index of er as i_r;
//
//			Then for any subarray whose starting point chosen from [i_l+1, i] & ending index chosen from [i, i_r-1], e is the minimum element of subch subarray.

	public int sumSubarrayMins(int[] arr) {

		// we are trying to find all the subarrays in which A[i] is the minimum
		// this can be done by finding the left index till which A[i] is min i.e.
		// finding the index of next min element of left will give the left boundary of
		// the subarray for which A[i] will be minimum
		int MOD = 1000000007;
		int left[] = new int[arr.length];
		// left stores the distance of each element A[i] from the next lesser element to
		// its left
		Arrays.fill(left, -1);

		// right stores the distance of element A[i] from the next lesser element to its
		// right
		int right[] = new int[arr.length];
		Arrays.fill(right, arr.length); // mark first that next small element iof each element is on its right

		Stack<Integer> st = new Stack<>();

		// store index of previous lesser element in the left[]
		for (int i = arr.length - 1; i >= 0; i--) {

			while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
				left[st.pop()] = i;
			}
			st.push(i);
		}

		st.clear();
		// store the index of next lesser element in the right[]
		for (int i = 0; i < arr.length; i++) {

			while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
				int rightindex = st.pop();
				right[rightindex] = i;
			}
			st.push(i);
		}

		long res = 0;
		for (int i = 0; i < arr.length; i++) {
			long leftrange = (long) i - left[i];
			long rightrange = right[i] - (long) i;

			res = (res + arr[i] * leftrange % MOD * rightrange % MOD) % MOD;
		}

		return (int) res;
	}
}
