package leetcode150daysArrays;

import java.util.Arrays;
import java.util.HashMap;

//Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

public class InteresectionOfTwoArraysII {

	public int[] intersectM2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0, k = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				++i;
			} else if (nums1[i] > nums2[j]) {
				++j;
			} else {
				nums1[k++] = nums1[i++];
				++j;
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}

	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length) {
			return intersect(nums2, nums1);
		}
		HashMap<Integer, Integer> m = new HashMap<>();
		for (int n : nums1) {
			m.put(n, m.getOrDefault(n, 0) + 1);
		}
		int k = 0;
		for (int n : nums2) {
			int cnt = m.getOrDefault(n, 0);
			if (cnt > 0) {
				nums1[k++] = n;
				m.put(n, cnt - 1);
			}
		}
		return Arrays.copyOfRange(nums1, 0, k);
	}

}
