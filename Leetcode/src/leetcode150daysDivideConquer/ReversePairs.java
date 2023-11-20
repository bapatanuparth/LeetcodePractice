package leetcode150daysDivideConquer;

//Given an integer array nums, return the number of reverse pairs in the array.
//
//A reverse pair is a pair (i, j) where:
//
//0 <= i < j < nums.length and
//nums[i] > 2 * nums[j].

public class ReversePairs {

	public int reversePairs(int[] nums) {
		return mergeSort(nums, 0, nums.length - 1);
	}

	int mergeSort(int[] nums, int low, int high) {

		if (low >= high)
			return 0;

		int mid = low + (high - low) / 2;
		int res = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);

		int j = mid + 1;
		for (int i = low; i <= mid; i++) {

			while (j <= high && nums[i] > 2L * nums[j])
				j++;
			res += j - (mid + 1);
		}

		merge(nums, low, mid, high);
		return res;
	}

	void merge(int[] nums, int low, int mid, int high) {
		int k = 0;
		int i = low, j = mid + 1;

		int temp[] = new int[high - low + 1];
		while (i <= mid && j <= high) {
			if (nums[i] <= nums[j]) {
				temp[k++] = nums[i++];
			} else
				temp[k++] = nums[j++];
		}

		while (i <= mid)
			temp[k++] = nums[i++];

		while (j <= high)
			temp[k++] = nums[j++];

		System.arraycopy(temp, 0, nums, low, temp.length);

	}

}
