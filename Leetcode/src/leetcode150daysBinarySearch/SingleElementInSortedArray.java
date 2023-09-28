package leetcode150daysBinarySearch;

//You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
//
//Return the single element that appears only once.
//
//Your solution must run in O(log n) time and O(1) space.

public class SingleElementInSortedArray {

	public int singleNonDuplicate(int[] nums) {
		if (nums.length == 1)
			return nums[0];
		int left = 0, right = nums.length - 1;
		if (nums[0] != nums[1])
			return nums[0];
		if (nums[nums.length - 1] != nums[nums.length - 2])
			return nums[nums.length - 1];
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid - 1] != nums[mid] && nums[mid] != nums[mid + 1])
				return nums[mid];
			if (nums[mid] == nums[mid - 1]) {
				if (mid % 2 != 0) {
					left = mid;
				} else
					right = mid;
			} else {
				if (mid % 2 == 0)
					left = mid;
				else
					right = mid;
			}

		}
		return -1;
	}

}
