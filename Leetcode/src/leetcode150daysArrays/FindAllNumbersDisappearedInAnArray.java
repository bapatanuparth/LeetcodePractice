package leetcode150daysArrays;

import java.util.LinkedList;
import java.util.List;

//Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.

public class FindAllNumbersDisappearedInAnArray {

	class Solution {
		public List<Integer> findDisappearedNumbers(int[] nums) {

			// Iterate over each of the elements in the original array
			for (int i = 0; i < nums.length; i++) {

				// Treat the value as the new index
				int newIndex = Math.abs(nums[i]) - 1;

				// Check the magnitude of value at this new index
				// If the magnitude is positive, make it negative
				// thus indicating that the number nums[i] has
				// appeared or has been visited.
				if (nums[newIndex] > 0) {
					nums[newIndex] *= -1;
				}
			}

			// Response array that would contain the missing numbers
			List<Integer> result = new LinkedList<Integer>();

			// Iterate over the numbers from 1 to N and add all those
			// that have positive magnitude in the array
			for (int i = 1; i <= nums.length; i++) {

				if (nums[i - 1] > 0) {
					result.add(i);
				}
			}

			return result;
		}
	}

}
