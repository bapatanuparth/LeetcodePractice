package leetcodeGreedy;

import java.util.Arrays;
//You have n bags numbered from 0 to n - 1. You are given two 0-indexed integer arrays capacity and rocks. The ith bag can hold a maximum of capacity[i] rocks and currently contains rocks[i] rocks. You are also given an integer additionalRocks, the number of additional rocks you can place in any of the bags.
//
//Return the maximum number of bags that could have full capacity after placing the additional rocks in some bags.

public class MaxBagsWithFullCapacityRocks {

	public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		long total = 0;
		int length = capacity.length;
		for (int i = 0; i < length; i++) {
			capacity[i] -= rocks[i];
			total += capacity[i];
		}
		if (total > additionalRocks) {
			Arrays.sort(capacity);
			for (int i = 0; i < length; i++) {
				if (additionalRocks < capacity[i]) {
					return i;
				}
				additionalRocks -= capacity[i];
			}
		}
		return length;
	}
}
