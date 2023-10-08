package leetcode150daysDynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//You are given an integer array nums. You want to maximize the number of points you get by performing the following operation any number of times:
//
//Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must delete every element equal to nums[i] - 1 and every element equal to nums[i] + 1.
//Return the maximum number of points you can earn by applying the above operation some number of times.

public class DeleteAndEarn {

	public int deleteAndEarn(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int max = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + i);
			max = Math.max(max, i);
		}

		int points[] = new int[max + 1];
		points[1] = map.getOrDefault(1, 0);

		for (int i = 2; i < points.length; i++) {
			int gain = map.getOrDefault(i, 0);
			points[i] = Math.max(points[i - 1], points[i - 2] + gain);
		}

		return points[max];
	}

}
