package leetcode150daysHeap;

//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//Can you solve it without sorting?

public class KthLargestElementInArray {
	public int findKthLargest(int[] nums, int k) {
		int left = 0, right = nums.length - 1;
		while (left <= right) {
			int pivotIndex = partition(left, right, nums);

			if (pivotIndex == k - 1) {
				return nums[pivotIndex];
			} else if (pivotIndex < k - 1) {
				left = pivotIndex + 1;
			} else {
				right = pivotIndex - 1;
			}
		}

		return -1;
	}

	int partition(int l, int r, int[] nums) {
		int pivot = nums[r];
		int i = l; // Initialize i at 'l' instead of 'l-1'
		for (int j = l; j < r; j++) {
			if (nums[j] >= pivot) {
				swap(i, j, nums);
				i++;
			}
		}
		swap(i, r, nums);
		return i;
	}

	void swap(int i, int j, int[] nums) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
