package leetcode150daysBinarySearch;

//An array arr is a mountain if the following properties hold:
//
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
//
//You must solve it in O(log(arr.length)) time complexity.

public class PeakIndexInMountain {

	public int peakIndexInMountainArray(int[] arr) {
		int left = 1, right = arr.length - 2;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
				return mid;
			else if (arr[mid] > arr[mid - 1])
				left = mid + 1;
			else
				right = mid - 1;
		}

		return -1;
	}

}
