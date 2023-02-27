package leetcodeHash;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Given an integer array nums and two integers k and p, return the number of distinct subarrays which have at most k elements divisible by p.
//
//Two arrays nums1 and nums2 are said to be distinct if:
//
//They are of different lengths, or
//There exists at least one index i where nums1[i] != nums2[i].
//A subarray is defined as a non-empty contiguous sequence of elements in an array.

public class KDivisibeElementsSubarrays {

	public int countDistinct(int[] nums, int k, int p) {
		Set<List<Integer>> set = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {

			List<Integer> ls = new ArrayList<>();
			for (int j = i; j < nums.length; j++) {
				ls.add(nums[j]);
				set.add(new ArrayList<>(ls));
			}
		}

		int res = 0;
		for (List<Integer> ls : set) {
			int divnos = 0;
			for (int i : ls) {
				if (i % p == 0)
					divnos++;
			}
			if (divnos <= k)
				res++;
		}

		return res;
	}

}
