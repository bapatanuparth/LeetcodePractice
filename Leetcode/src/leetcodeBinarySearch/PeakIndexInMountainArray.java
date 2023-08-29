package leetcodeBinarySearch;

//An array arr a mountain if the following properties hold:

//
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
//Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
//
//You must solve it in O(log(arr.length)) time complexity.

public class PeakIndexInMountainArray {
	public int peakIndexInMountainArray(int[] arr) {
		int left = 0, right = arr.length - 1;
		int ans = 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid - 1] > arr[mid])
				right = mid;
			else if (arr[mid] > arr[mid - 1]) {
				ans = mid;
				left = mid + 1;
			}
			;
		}

		return ans;
	}

}
