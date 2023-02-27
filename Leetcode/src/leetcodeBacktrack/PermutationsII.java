package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {

	class Solution {
		public List<List<Integer>> permuteUnique(int[] nums) {

			List<List<Integer>> res = new ArrayList<>();
			List<Integer> temp = new ArrayList<>();
			Map<Integer, Integer> map = new HashMap<>();
			for (int i : nums) {
				map.put(i, map.getOrDefault(i, 0) + 1);
			}

			backtrack(nums, map, res, temp);

			return res;

		}

		void backtrack(int[] nums, Map<Integer, Integer> map, List<List<Integer>> res, List<Integer> temp) {
			if (temp.size() == nums.length) {
				res.add(new ArrayList<>(temp));
			}

			for (int i : map.keySet()) {
				if (map.get(i) > 0) {
					temp.add(i);
					map.replace(i, map.get(i) - 1);

					backtrack(nums, map, res, temp);

					temp.remove(temp.size() - 1);
					map.replace(i, map.get(i) + 1);
				}
			}
		}

	}
}
