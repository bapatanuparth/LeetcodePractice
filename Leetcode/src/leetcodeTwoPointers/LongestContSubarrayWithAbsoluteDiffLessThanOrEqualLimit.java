package leetcodeTwoPointers;

import java.util.ArrayDeque;

public class LongestContSubarrayWithAbsoluteDiffLessThanOrEqualLimit {

	class Solution {
		public int longestSubarray(int[] nums, int limit) {
			int left = 0, right = 0;
			ArrayDeque<Integer> maxq = new ArrayDeque<>();
			ArrayDeque<Integer> minq = new ArrayDeque<>();

			int max = 0;

			for (; right < nums.length; right++) {
				while ((!maxq.isEmpty() && Math.abs(nums[right] - nums[maxq.peekFirst()]) > limit)
						|| (!minq.isEmpty() && Math.abs(nums[right] - nums[minq.peekFirst()]) > limit)) {
					if (maxq.peekFirst() == left)
						maxq.pollFirst();
					if (minq.peekFirst() == left)
						minq.pollFirst();
					left++;
				}
				while (!maxq.isEmpty() && nums[maxq.peekLast()] <= nums[right])
					maxq.pollLast();
				maxq.offerLast(right);

				while (!minq.isEmpty() && nums[minq.peekLast()] >= nums[right])
					minq.pollLast();
				minq.offerLast(right);

				max = Math.max(right - left + 1, max);
			}

			return max;
		}
	}
}
