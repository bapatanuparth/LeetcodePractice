package leetCodeArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//You are given a 0-indexed array of positive integers nums and a positive integer limit.
//
//In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.
//
//Return the lexicographically smallest array that can be obtained by performing the operation any number of times.
//
//An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.0

public class MakeLexicographicallySmallestArrayBySwappingElements {

	// main intuition is that if we can swap a and b, b and c, then we can swap a
	// and c
	// sort the array, maintain a reference to the indices
	// create small groups that satisfy this of <= limit condition
	// sort these elements within themselves, so now you have all the indices in
	// which a group can be put into, arrange these elements in sorted way within
	// these indices
	// put these elements on their re

	public int[] lexicographicallySmallestArray(int[] nums, int limit) {
		int[][] nums2 = new int[nums.length][2];

		for (int i = 0; i < nums.length; i++) {
			nums2[i] = new int[] { nums[i], i };
		}

		Arrays.sort(nums2, (a, b) -> a[0] - b[0]);

		List<List<Integer>> out = new ArrayList<>();
		List<Integer> ind = new ArrayList<>();

		for (int i = 0; i < nums2.length; i++) {
			if (i > 0 && nums2[i][0] - nums2[i - 1][0] > limit) {
				out.add(ind);
				ind = new ArrayList<>();
			}
			ind.add(nums2[i][1]);
		}
		out.add(ind);

		int[] res = new int[nums.length];

		for (List<Integer> i : out) {
			List<Integer> sorted = new ArrayList<>(i);
			Collections.sort(sorted);
			for (int j = 0; j < sorted.size(); j++) {
				res[sorted.get(j)] = nums[i.get(j)];
			}
		}

		return res;
	}

}
