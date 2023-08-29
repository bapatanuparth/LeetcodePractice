package leetcodeDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SmallestSufficientTeam {

	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		int n = req_skills.length, m = people.size();
		HashMap<String, Integer> skill_index = new HashMap<>();
		// map a skill to the number
		for (int i = 0; i < n; ++i)
			skill_index.put(req_skills[i], i);
		// create an array of lists
		// these 1 << n represents the bitmask final till the last skill
		// thidp holds the number of people required to fulfil the current skill
		// requirement
		// 1000 represents the max bitmask of the 3 skills by 2^3 in bits so
		// our requirement is that for 3 skiils 2^3 -1 i.e. 0111 should be the value to
		// achieve with least number of people
		List<Integer>[] dp = new List[1 << n]; // n is max number of skills, so each bit needs to be positive for the
												// final
		dp[0] = new ArrayList<>();

		for (int i = 0; i < m; ++i) {
			int cur_skill = 0;
			for (String s : people.get(i)) // for each skill of given person, mark its bit
				cur_skill |= 1 << skill_index.get(s);
			// for all the previous skill sets
			for (int prev = 0; prev < dp.length; ++prev) {
				if (dp[prev] == null)
					continue;
				// combine the previous skills with the current skill set
				int comb = prev | cur_skill;
				if (dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
					dp[comb] = new ArrayList<>(dp[prev]);
					dp[comb].add(i);
				}
			}
		}
		return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
	}

}
