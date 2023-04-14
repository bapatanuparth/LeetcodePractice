package leetcodeTwoPointers;

//You are given a 0-indexed, strictly increasing integer array nums and a positive integer diff. A triplet (i, j, k) is an arithmetic triplet if the following conditions are met:
//
//i < j < k,
//nums[j] - nums[i] == diff, and
//nums[k] - nums[j] == diff.
//Return the number of unique arithmetic triplets.

public class NumberOfArithmeticTriplets {

	public int arithmeticTriplets(int[] nums, int diff) {

		int n = nums.length;
		int count = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			int left = i - 1, right = i + 1;
			while (left >= 0 && right < n) {
				if (nums[i] - nums[left] > diff)
					break;
				if (nums[right] - nums[i] > diff)
					break;
				if (nums[i] - nums[left] == diff && nums[right] - nums[i] == diff) {
					count++;
					break;
				}
				if (nums[i] - nums[left] < diff)
					left--;
				if (nums[right] - nums[i] < diff)
					right++;
			}

		}

		return count;
	}

}
