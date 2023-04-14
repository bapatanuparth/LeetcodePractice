package leetcodeGraphs;

public class LongestCycleInGraph {

	// use floyd's cycle detection algorithm
	// start from each index and see if there is a cycle starting there or not
	// if yes, use fast and slow pointers to check the length of cycle like we did
	// in linked list
	// keep track of each length starting with this index, in a memoization array,
	// so as to nopt do repeated work.
	public int longestCycle(int[] edges) {
		int n = edges.length;
		int longest = -1;

		int[] memo = new int[n]; // memoization array to store previously computed cycle lengths

		for (int start = 0; start < n; start++) {

			int slow = start, fast = start;
			while (edges[fast] != -1 && edges[edges[fast]] != -1) { // loop until a cycle is found or a dead end is
																	// reached
				slow = edges[slow];
				fast = edges[edges[fast]];
				if (slow == fast) { // if a cycle is found
					int cycleLen = 1;
					slow = edges[slow];
					while (slow != fast) { // compute the length of the cycle
						cycleLen++;
						slow = edges[slow];
					}
					longest = Math.max(longest, cycleLen); // update longest cycle length if necessary
					memo[start] = cycleLen; // memoize cycle length for future use

					break;
				}
				if (memo[slow] != 0) { // if we've already computed the cycle length for this node
					memo[start] = memo[slow]; // memoize previously computed cycle length

					break;
				}
			}

		}

		return longest;

	}
}
