package leetcode150daysTwoPointer;

import java.util.ArrayList;
import java.util.List;

//Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.
//
//An integer a is closer to x than an integer b if:
//
//|a - x| < |b - x|, or
//|a - x| == |b - x| and a < b

public class FindKClosestElements {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> res = new ArrayList<>();
		if (k == arr.length) {
			for (int i = 0; i < arr.length; i++)
				res.add(arr[i]);
			return res;
		}

		int left = 0, right = arr.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < x) {
				left = mid + 1;
			} else
				right = mid;
		}

		right = left;
		left -= 1;

		while (right - left - 1 < k) {
			if (left == -1) {
				right++;
				continue;
			}

			if (right == arr.length) {
				left--;
				continue;
			}

			if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))
				left--;
			else
				right++;
		}

		for (int i = left + 1; i < right; i++)
			res.add(arr[i]);

		return res;
	}

}
