package leetcode150daysBinarySearch;

//Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.

public class SearchInsertPosition {
	class Solution {
		public int searchInsert(int[] nums, int target) {
			int pivot, left = 0, right = nums.length - 1;
			while (left <= right) {
				pivot = left + (right - left) / 2;
				if (nums[pivot] == target)
					return pivot;
				if (target < nums[pivot])
					right = pivot - 1;
				else
					left = pivot + 1;
			}
			return left;
		}
	}

}
