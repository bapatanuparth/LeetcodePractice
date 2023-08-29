package leetcode150daysGreedy;

import java.util.ArrayList;
import java.util.List;

//Given an array of integers arr, sort the array by performing a series of pancake flips.
//
//In one pancake flip we do the following steps:
//
//Choose an integer k where 1 <= k <= arr.length.
//Reverse the sub-array arr[0...k-1] (0-indexed).
//For example, if arr = [3,2,1,4] and we performed a pancake flip choosing k = 3, we reverse the sub-array [3,2,1], so arr = [1,2,3,4] after the pancake flip at k = 3.
//
//Return an array of the k-values corresponding to a sequence of pancake flips that sort arr. Any valid answer that sorts the array within 10 * arr.length flips will be judged as correct.

public class PancakeSorting {

	public List<Integer> pancakeSort(int[] A) {
		List<Integer> ans = new ArrayList<>();

		for (int valueToSort = A.length; valueToSort > 0; valueToSort--) {
			// locate the position for the value to sort in this round
			int index = this.find(A, valueToSort);

			// sink the value_to_sort to the bottom,
			// with at most two steps of pancake flipping.
			if (index == valueToSort - 1)
				continue;
			// 1). flip the value to the head if necessary
			if (index != 0) {
				ans.add(index + 1);
				this.flip(A, index + 1);
			}
			// 2). now that the value is at the head, flip it to the bottom
			ans.add(valueToSort);
			this.flip(A, valueToSort);
		}

		return ans;
	}

	protected void flip(int[] sublist, int k) {
		int i = 0;
		while (i < k / 2) {
			int temp = sublist[i];
			sublist[i] = sublist[k - i - 1];
			sublist[k - i - 1] = temp;
			i += 1;
		}
	}

	protected int find(int[] a, int target) {
		for (int i = 0; i < a.length; i++)
			if (a[i] == target)
				return i;
		return -1;
	}

}
