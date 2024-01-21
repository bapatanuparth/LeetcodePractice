package leetcodeMatrix;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
//
//The 2D array should contain only the elements of the array nums.
//Each row in the 2D array contains distinct integers.
//The number of rows in the 2D array should be minimal.
//Return the resulting array. If there are multiple answers, return any of them.
//
//Note that the 2D array can have a different number of elements on each row.

public class ConvertArrayIn2DArrayWithConditions {

	public List<List<Integer>> findMatrix(int[] nums) {
		Queue<int[]> q = new ArrayDeque<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for (int i : map.keySet()) {
			q.offer(new int[] { i, map.get(i) });
		}

		List<List<Integer>> res = new ArrayList<>();

		while (!q.isEmpty()) {
			int s = q.size();
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < s; i++) {
				int[] p = q.poll();
				temp.add(p[0]);
				if (p[1] > 1)
					q.offer(new int[] { p[0], p[1] - 1 });
			}
			res.add(temp);
		}

		return res;
	}

}
