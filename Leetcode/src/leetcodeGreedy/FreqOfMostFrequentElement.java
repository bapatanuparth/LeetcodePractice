package leetcodeGreedy;

import java.util.Arrays;

//The frequency of an element is the number of times it occurs in an array.
//
//You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.
//
//Return the maximum possible frequency of an element after performing at most k operations.

public class FreqOfMostFrequentElement {
	public int maxFrequency(int[] nums, int k) {
		// sort elements
		// as we can only increase an element, we need to check which lower elements can
		// be made to which higher element
		// for this, we can traverse a window and check which all previous element can
		// be == curr staying within k
		Arrays.sort(nums);

		int ans = 1;
		int left = 0, sum = 0;
		// create a window
		for (int right = 1; right < nums.length; right++) {
			// we calculate cumulative sum of all the elements in the window, as all thowse
			// elements need to be increased by that amount
			sum = sum + (right - left) * (nums[right] - nums[right - 1]);
			// while the sum > k move left ahead
			while (left <= right && sum > k) {
				sum -= (nums[right] - nums[left]);
				left++;
			}
			// now we have right and left positioned in such a way that all elements within
			// window can be made == nums[right]
			ans = Math.max(ans, right - left + 1);
		}

		return ans;
	}

}
