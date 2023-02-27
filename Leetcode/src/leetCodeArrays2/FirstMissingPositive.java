package leetCodeArrays2;

import java.util.HashSet;
import java.util.Set;

//Given an unsorted integer array nums, return the smallest missing positive integer.
//
//You must implement an algorithm that runs in O(n) time and uses constant extra space.

public class FirstMissingPositive {

	public class Solution {
		public int firstMissingPositive(int[] nums) {
			int n = nums.length;

			// 1. mark numbers (num < 0) and (num > n) with a special marker number (n+1)
			// (we can ignore those because if all number are > n then we'll simply return
			// 1)
			for (int i = 0; i < n; i++) {
				if (nums[i] <= 0 || nums[i] > n) {
					nums[i] = n + 1;
				}
			}
			// note: all number in the array are now positive, and on the range 1..n+1

			// 2. mark each cell appearing in the array, by converting the index for that
			// number to negative
			for (int i = 0; i < n; i++) {
				int num = Math.abs(nums[i]);
				if (num > n) {
					continue;
				}
				num--; // -1 for zero index based array (so the number 1 will be at pos 0)
				if (nums[num] > 0) { // prevents double negative operations
					nums[num] = -1 * nums[num];
				}
			}

			// 3. find the first cell which isn't negative (doesn't appear in the array)
			for (int i = 0; i < n; i++) {
				if (nums[i] >= 0) {
					return i + 1;
				}
			}

			// 4. no positive numbers were found, which means the array contains all numbers
			// 1..n
			return n + 1;
		}
	}

	// solution using extra space
	class Solution2 {
		public int firstMissingPositive(int[] nums) {
			Set<Integer> set = new HashSet<>();

			int min = Integer.MAX_VALUE;
			int max = 0;

			for (int i = 0; i < nums.length; i++) {
				set.add(nums[i]);
				if (nums[i] > 0) {
					min = Math.min(min, nums[i]);
					max = Math.max(max, nums[i]);
				}
			}

			if (min != 1 || max == 0)
				return 1;

			for (int i = 1; i <= Integer.MAX_VALUE; i++) {
				if (!set.contains(i))
					return i;
			}

			return -1;
		}
	}
}
