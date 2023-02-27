package leetcodeHash;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
//
//Return a list answer of size 2 where:
//
//answer[0] is a list of all players that have not lost any matches.
//answer[1] is a list of all players that have lost exactly one match.
//The values in the two lists should be returned in increasing order.
//
//Note:
//
//You should only consider the players that have played at least one match.
//The testcases will be generated such that no two matches will have the same outcome.

public class PlayersWithZeroOrOneLosses {

	public List<List<Integer>> findWinners(int[][] matches) {
		Map<Integer, Integer> map = new TreeMap<>();

		for (int[] match : matches) {
			int i = match[0];
			int j = match[1];

			if (!map.containsKey(i)) {
				map.put(i, 0);
			}

			map.put(j, map.getOrDefault(j, 0) + 1);
		}

		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for (int key : map.keySet()) {
			if (map.get(key) == 0)
				list1.add(key);
			else if (map.get(key) == 1)
				list2.add(key);
		}

		List<List<Integer>> res = new ArrayList<>();
		res.add(list1);
		res.add(list2);

		return res;
	}
}
