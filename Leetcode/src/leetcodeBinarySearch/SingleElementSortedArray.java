package leetcodeBinarySearch;

//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//Return the single element that appears only once.
//
//Your solution must run in O(log n) time and O(1) space.

public class SingleElementSortedArray {

	// O(logn) binary search
	// approach- before the single element, all the previous pairs have first
	// element on even index
	// after the single element, all next pairs have first element at odd index
	public int singleNonDuplicateEff(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		int left = 0, right = n - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (mid == 0)
				if (nums[mid + 1] != nums[mid])
					return nums[mid];
			if (mid == n - 1)
				if (nums[mid - 1] != nums[mid])
					return nums[mid];
			if ((mid % 2 == 0) && nums[mid + 1] == nums[mid] || (mid % 2 == 1) && nums[mid - 1] == nums[mid])
				left = mid + 1;
			else
				right = mid - 1;
		}

		return nums[left];
	}

	// worst case O(n)
	public int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		return search(0, n - 1, nums);

	}

	int search(int start, int end, int[] nums) {

		if (start > end)
			return -1;

		int mid = start + (end - start) / 2;

		if (mid == 0) {
			if (nums[mid + 1] != nums[mid])
				return nums[mid];
		} else if (mid == nums.length - 1) {
			if (nums[mid - 1] != nums[mid])
				return nums[mid];
		} else {
			if (nums[mid - 1] != nums[mid] && nums[mid + 1] != nums[mid])
				return nums[mid];
		}

		int left = search(start, mid - 1, nums);
		if (left != -1)
			return left;
		int right = search(mid + 1, end, nums);
		if (right != -1)
			return right;

		return -1;

	}

}
