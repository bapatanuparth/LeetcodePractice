package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given an array of transactions transactions where transactions[i] = [fromi, toi, amounti] indicates that the person with ID = fromi gave amounti $ to the person with ID = toi.
//
//Return the minimum number of transactions required to settle the debt.

public class OptimalAccountBalancing {

	List<Integer> balance;

	public int minTransfers(int[][] transactions) {
		// get net balance of each person.
		// it will be either + or - based on if person owes or lends
		Map<Integer, Integer> map = new HashMap<>();
		for (int[] t : transactions) {
			map.put(t[0], map.getOrDefault(t[0], 0) + t[2]);
			map.put(t[1], map.getOrDefault(t[1], 0) - t[2]);
		}
		// create a list of all the balances and run a dfs on that
		balance = new ArrayList<>(map.values());
		int n = balance.size();
		return dfs(0, n);
	}

	int dfs(int cur, int n) {
		// if the person has 0 net balance then he is satisfied
		while (cur < n && balance.get(cur) == 0)
			cur++;
		// if we reach end return 0, no more transaction needed
		if (cur == n)
			return 0;
		int r = Integer.MAX_VALUE;
		// for eachy element after current
		for (int i = cur + 1; i < n; i++) {
			// if their signs dont match, we are trying to cancel out the debts and lends
			// so check whise signs dont match
			if (balance.get(i) * balance.get(cur) < 0) {
				// add the balance of current to the next person simulating that current person
				// gives off all his balance to the next guy with differing signs
				balance.set(i, balance.get(i) + balance.get(cur));
				r = Math.min(r, 1 + dfs(cur + 1, n)); // here count that as +1 transaction. and go ahead
				// backtrack
				balance.set(i, balance.get(i) - balance.get(cur));
			}
		}
		return r;
	}

}
