package leetcode150daysHash;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class ContainsDuplicateII {

	// O(nlogk) because we use a BST -- TreeSet
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Set<Integer> set = new TreeSet<>();
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

	// O(n)
	public boolean containsNearbyDuplicateOn(int[] nums, int k) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

}
