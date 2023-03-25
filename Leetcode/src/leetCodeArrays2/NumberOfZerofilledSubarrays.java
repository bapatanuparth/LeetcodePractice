package leetCodeArrays2;

//Given an integer array nums, return the number of subarrays filled with 0.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
public class NumberOfZerofilledSubarrays {

	public long zeroFilledSubarray(int[] nums) {
		long count = 0;
		int left = 0;
		for (int i = 0; i < nums.length;) {
			if (nums[i] != 0) {
				i++;
				continue;
			}
			int j = 0;
			while (i < nums.length && nums[i] == 0) {
				j++;
				count += j;
				i++;
			}
		}

		return count;
	}

}
