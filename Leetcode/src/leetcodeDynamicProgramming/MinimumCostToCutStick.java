package leetcodeDynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Given a wooden stick of length n units. The stick is labelled from 0 to n. For example, a stick of length 6 is labelled as follows:
//
//
//Given an integer array cuts where cuts[i] denotes a position you should perform a cut at.
//
//You should perform the cuts in order, you can change the order of the cuts as you wish.
//
//The cost of one cut is the length of the stick to be cut, the total cost is the sum of costs of all cuts. When you cut a stick, it will be split into two smaller sticks (i.e. the sum of their lengths is the length of the stick before the cut). Please refer to the first example for a better explanation.
//
//Return the minimum total cost of the cuts.

public class MinimumCostToCutStick {

//	Perform Brute Force Recursion
//	At any state of recursion, we would be having a piece of rod (or wood), from index l to index r.
//	Try all the possible cuts on this segment, which splits it into further 2 segments and 
	// recurse for the minimum cost in which those 2 segments can be made.
//	The minimum cost among all those possible cuts + the cost of making our current cut, would be our best cost for cutting the wood in this segment, i.e. from l to r.
//	Memoize the minimum cost for the current l and r value in a memo.
//	If the answer for l to r was already present in our memo, then directly retrun the value stored in the memo corresponding to this l and r instead of performing from step 1.

	Map<ArrayList<Integer>, Integer> map;

	public int minCost(int n, int[] cuts) {
		int m = cuts.length;
		map = new HashMap<>();
		return dfs(0, n, cuts);
	}

	int dfs(int start, int end, int[] cuts) {
		// memoize the value for given start and end
		ArrayList<Integer> ind = new ArrayList<>();
		ind.add(start);
		ind.add(end);
		if (map.containsKey(ind)) // return if already exists
			return map.get(ind);
		if (start + 1 == end)
			return 0;
		// we have to minimize the result
		int res = Integer.MAX_VALUE;
		// loop through all possible cuts
		for (int cut : cuts) {
			if (start < cut && cut < end)
				// res for this cut == current cost + min cost for left half + min cost for
				// right half
				res = Math.min(res, (end - start) + dfs(cut, end, cuts) + dfs(start, cut, cuts));
		}
		// this case, there is no valid cut to be made
		if (res == Integer.MAX_VALUE)
			res = 0;
		// memoize the solution
		map.put(ind, res);
		return res;
	}

}
