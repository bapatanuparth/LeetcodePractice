package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//Given an array of digit strings nums and a digit string target, return the number of pairs of indices (i, j) (where i != j) such that the concatenation of nums[i] + nums[j] equals target.

public class NumberOfPairsStringsWithConcatenationEqualTarget {

	// O(n)
	// count each words frequency in hashmap
	// use it while counting pairs
	public int numOfPairs(String[] nums, String target) {
		Map<String, Integer> map = new HashMap<>();

		for (String s : nums) {
			map.put(s, map.getOrDefault(s, 0) + 1);
		}

		int count = 0;
		for (String s : nums) {
			if (target.indexOf(s) != 0)
				continue;
			String suffix = target.substring(s.length());

			if (map.containsKey(suffix)) {
				count += map.get(suffix);
				if (suffix.equals(s))
					count -= 1;
			}
		}

		return count;
	}
}
