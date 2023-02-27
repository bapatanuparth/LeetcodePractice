package leetcodeHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.
//
//You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.
//
//Return a list of groups such that each person i is in a group of size groupSizes[i].
//
//Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.

//Input: groupSizes = [3,3,3,3,3,1,3]
//Output: [[5],[0,1,2],[3,4,6]]
public class GroupThePeopleGivenGroupSizeTheyBelongTo {

	public List<List<Integer>> groupThePeople(int[] groupSizes) {
		Map<Integer, List<Integer>> map = new HashMap<>();

		// form buckets of the group sizes, add elements in the bucket that belong to
		// same size
		for (int i = 0; i < groupSizes.length; i++) {
			if (map.containsKey(groupSizes[i])) {
				map.get(groupSizes[i]).add(i);
			} else {
				List<Integer> t = new ArrayList<>();
				t.add(i);
				map.put(groupSizes[i], t);
			}
		}

		// create separate lists out of the buckets and append to the result
		List<List<Integer>> res = new ArrayList<>();
		for (int key : map.keySet()) {

			List<Integer> ls = map.get(key);
			int listnum = ls.size() / key;

			for (int i = 0; i < ls.size(); i += key) {

				List<Integer> temp = new ArrayList<>();
				for (int k = 0; k < key; k++) {
					temp.add(ls.get(i + k));
				}
				res.add(temp);
			}

		}

		return res;

	}
}
