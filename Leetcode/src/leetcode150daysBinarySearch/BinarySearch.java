package leetcode150daysBinarySearch;

//Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//
//You must write an algorithm with O(log n) runtime complexity.

public class BinarySearch {

	public int search(int[] nums, int target) {
		int mid;
		int left = 0, right = nums.length - 1;

		while (left <= right) {
			mid = (left + right) / 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return -1;
	}
}
