package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//You are given an array nums that consists of non-negative integers. Let us define rev(x) as the reverse of the non-negative integer x. For example, rev(123) = 321, and rev(120) = 21. A pair of indices (i, j) is nice if it satisfies all of the following conditions:
//
//0 <= i < j < nums.length
//nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
//Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7.0

public class CountNicePairsInArray {

	public int countNicePairs(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int MOD = 1000000007;
		int res = 0;
		for (int i : nums) {
			int re = rev(i);
			int lo = i - rev(i);
			if (map.containsKey(lo)) {
				res = (res + map.get(lo)) % MOD;
				map.put(lo, map.get(lo) + 1);
			} else {
				map.put(lo, 1);
			}
		}
		return res;

	}

	int rev(int x) {
		int ans = 0;
		while (x > 0) {
			ans = ans * 10 + (x % 10);
			x /= 10;
		}
		return ans;
	}

}
