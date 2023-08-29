package leetcodeHash;

import java.util.HashMap;
import java.util.Map;

//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

public class ContiguousArray {

	public int findMaxLength(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				nums[i] = -1;
		}

		map.put(0, -1);
		int res = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum)) {
				res = Math.max(res, i - map.get(sum));
			} else {
				map.put(sum, i);
			}
		}

		return res;
	}

}
