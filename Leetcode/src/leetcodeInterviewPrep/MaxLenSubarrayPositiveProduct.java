package leetcodeInterviewPrep;

public class MaxLenSubarrayPositiveProduct {

	// genius approach
//	At every iteration, tracking maximum length of positive multiplicative result and negative multiplicative result can help.
//	Multiplicative Result : result(+ve/-ve) of multiplication of bunch of numbers(some of which can be +ve/-ve)
//
//	Algorithm
//
//	If we see a 0, we gotta start off things again
//	If we see a positive number :
//	2.1. Increase length of positive mutilpicative result till now.
//	2.2. Increase length of negative mutilpicative result till now, unless we had not encountered any negative before.
//	If we see a negative number:
//	3.1. It's time to swap positive and negative multiplicative results' lengths and do similar task as we did in above case.
//	In each iteration, use the length of positive mutilpicative result to compute answer.
	public int getMaxLenEFF(int[] nums) {
		int positive = 0, negative = 0; // length of positive and negative results
		int ans = 0;
		for (int x : nums) {
			if (x == 0) {
				positive = 0;
				negative = 0;
			} else if (x > 0) {
				positive++;
				negative = negative == 0 ? 0 : negative + 1;
			} else {
				int temp = positive;
				positive = negative == 0 ? 0 : negative + 1;
				negative = temp + 1;
			}
			ans = Math.max(ans, positive);
		}
		return ans;
	}

	// my solution
	public int getMaxLen(int[] nums) {
		if (nums.length == 1)
			return nums[0] > 0 ? 1 : 0;

		int left = 0, right = 0;
		int pos = 0;
		int neg = 0;

		int maxlen = 0;

		// idea is to keep track of negatives in given subarray
		while (right < nums.length) {

			if (nums[right] == 0) { // if encounter zero, we need to check in previous subarray till zero, whether
				// its possible to get a subarray > maxlen
				if (neg % 2 == 1) {
					while (left < right) {
						if (nums[left] < 0) { // we check if removal of the first negative in prev array is giving
												// bigger
												// subarray
							// example -> [-1,-2,-3,1,2,3,54,6,6,67,3,0,1] removal of -1 ar 0th index gives
							// longer array with +ve product
							neg--;
							left++;
							maxlen = Math.max(maxlen, right - left);
							break;
						}
						left++;
					}
				}

				++right;
				left = right; // start fresh from 1 index after element zero
				pos = 0;
				neg = 0;
				continue;

			}

			if (nums[right] > 0)
				++pos;
			else
				++neg;

			if (neg % 2 == 0) { // if negatives are even, check for max length between left and right
				maxlen = Math.max(maxlen, right - left + 1);
			}

			right++;

		}

		// similarly after array ends, check whether removal of a negative is giving
		// bigger array
		if (neg % 2 == 1) {
			while (left < right) {
				if (nums[left] < 0) {
					neg--;
					left++;
					maxlen = Math.max(maxlen, right - left);
					break;
				}
				left++;
			}

		}

		return maxlen;
	}
}
