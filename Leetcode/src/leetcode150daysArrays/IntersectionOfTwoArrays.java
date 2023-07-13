package leetcode150daysArrays;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set = new HashSet<>();
		for (int i : nums1) {
			set.add(i);
		}
		Set<Integer> ls = new HashSet<>();
		for (int i : nums2) {
			if (set.contains(i))
				ls.add(i);
		}
		int[] res = new int[ls.size()];
		int j = 0;
		for (Integer i : ls) {
			res[j] = i;
			j++;
		}
		return res;
	}

}
