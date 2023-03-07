package leetcodeBinarySearch;

//Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

//
//Return the kth positive integer that is missing from this array.

public class KthMissingPositiveInteger {

	// O(logn)
	public int findKthPositive(int[] nums, int k) {
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			int pos = nums[mid] - mid - 1;

			if (pos < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		// At the end of the loop, left = right + 1,
		// and the kth missing is in-between arr[right] and arr[left].
		// The number of integers missing before arr[right] is
		// arr[right] - right - 1 -->
		// the number to return is
		// arr[right] + k - (arr[right] - right - 1) = k + left
		return left + k;

	}

	// O(n)
	public int findKthPositiveN(int[] nums, int k) {
		int i = 1;
		int j = 0;
		while (k > 0) {
			if (j >= nums.length) {
				k--;
				i++;
				continue;
			}
			if (nums[j] != i) {
				k--;
			}
			if (i < nums[j])
				i++;
			else {
				j++;
				i++;
			}
		}
		return i - 1;
	}
}
