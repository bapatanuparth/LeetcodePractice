//package leetcodeBinarySearch;
//
////(This problem is an interactive problem.)
////
////You may recall that an array arr is a mountain array if and only if:
////
////arr.length >= 3
////There exists some i with 0 < i < arr.length - 1 such that:
////arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
////arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
////Given a mountain array mountainArr, return the minimum index such that mountainArr.get(index) == target. If such an index does not exist, return -1.
////
////You cannot access the mountain array directly. You may only access the array using a MountainArray interface:
////
////MountainArray.get(k) returns the element of the array at index k (0-indexed).
////MountainArray.length() returns the length of the array.
////Submissions making more than 100 calls to MountainArray.get will be judged Wrong Answer. Also, any solutions that attempt to circumvent the judge will result in disqualification.
//
//public class FindMountainArray {
//	class MountainArray {
//
//	}
//
//	public int findInMountainArray(int target, MountainArray mountainArr) {
//		 int n = mountainArr.length();
//		int peak = peakIndex(mountainArr, n);
//		int leftIndex = search(mountainArr, 0, peak, target, true);
//		if (leftIndex != -1)
//			return leftIndex;
//		int rightIndex = search(mountainArr, peak + 1, n - 1, target, false);
//		return rightIndex;
//	}
//
//	int peakIndex(MountainArray mountainArr, int n) {
//		int left = 1, right = n - 2;
//		while (left <= right) {
//			int mid = left + (right - left) / 2;
//			int midElement = mountainArr.get(mid);
//			int prev = mountainArr.get(mid - 1);
//			int next = mountainArr.get(mid + 1);
//			if (midElement > prev && midElement > next)
//				return mid;
//			else if (midElement > prev)
//				left = mid + 1;
//			else
//				right = mid - 1;
//		}
//
//		return -1;
//	}
//
//	int search(MountainArray mountainArr, int left, int right, int target, boolean leftbool) {
//		int ans = -1;
//		while (left <= right) {
//			int mid = left + (right - left) / 2;
//			int midElement = mountainArr.get(mid);
//
//			if (midElement == target) {
//				ans = mid;
//				right = mid - 1;
//			} else if (midElement > target && leftbool)
//				right = mid - 1;
//			else if (midElement > target && !leftbool)
//				left = mid + 1;
//			else if (midElement < target && leftbool)
//				left = mid + 1;
//			else if (midElement < target && !leftbool)
//				right = mid - 1;
//		}
//
//		return ans;
//	}
//
//}
//
