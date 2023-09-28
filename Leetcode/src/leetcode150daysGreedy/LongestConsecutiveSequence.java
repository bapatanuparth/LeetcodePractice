package leetcode150daysGreedy;

import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
//
//You must write an algorithm that runs in O(n) time.

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums)
			set.add(i);
		int longest = 0;
		Set<Integer> temp = new HashSet<>();
		for (int i : nums) {
			if (!set.contains(i - 1)) {
				temp.add(i);
			}
		}
		int max = 1;
		for (int i : temp) {
			int j = i;
			while (set.contains(j))
				j++;
			max = Math.max(max, j - i);
		}
		return nums.length == 0 ? 0 : max;
	}

}
