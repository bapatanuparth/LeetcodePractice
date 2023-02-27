package leetCodeArrays2;

import java.util.HashSet;
import java.util.Set;

//Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

//
//You must write an algorithm that runs in O(n) time.

//Input: nums = [100,4,200,1,3,2]
//Output: 4
//Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] nums) {

		Set<Integer> set = new HashSet<>();

		for (int i : nums)
			set.add(i);// add each element in set

		int longestmax = 0;
		int currmax = 0;

		for (int i : nums) {

			if (!set.contains(i - 1)) { // check if the current element is the starting point of consecutive elements
				int temp = i;
				currmax = 1;
				while (set.contains(temp + 1)) { // if there are next consecutive elements, keep counting them and find
													// how many are there
					currmax++;
					temp++;
				}

				longestmax = Math.max(longestmax, currmax);

			}
		}

		return longestmax;

	}
}
