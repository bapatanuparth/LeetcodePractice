package leetcodeInterviewPrep;

import java.util.Arrays;

public class PartitionArrayMaxDifferenceK {

	// even if we need to find a subsequence, we only need to know min and max of
	// the subsequence, so order actually does not matter
	public int partitionArray(int[] nums, int k) {
		Arrays.sort(nums);

		int i = 0;
		int min = 0;
		int max = 0;
		int count = 0;
		while (min < nums.length) {

			while (max < nums.length && nums[max] - nums[min] <= k) {
				max = max + 1;
			}
			count++;
			min = max;
		}

		return count;
	}
}
