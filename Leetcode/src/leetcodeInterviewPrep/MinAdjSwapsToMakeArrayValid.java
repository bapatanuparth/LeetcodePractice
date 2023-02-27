package leetcodeInterviewPrep;

public class MinAdjSwapsToMakeArrayValid {

	public int minimumSwaps(int[] nums) {
		int n = nums.length - 1;
		int min = 0; // keep track of min element index
		int max = 0; // keep track of max element index

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < nums[min]) {
				min = i;
			}
			if (nums[i] >= nums[max]) {
				max = i;
			}
		}

		int val = 0;
		val += n - max; // count swaps to reach rightmost for max
		val += min - 0; // count swaps to reach leftmost for min
		if (min > max)
			val -= 1; // if min is ahead of max, it will already get swapped by 1 position when we
						// move max to right, so we subtract one

		return val;
	}
}
