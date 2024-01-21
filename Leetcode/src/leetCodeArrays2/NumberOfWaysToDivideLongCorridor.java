package leetCodeArrays2;

//Along a long library corridor, there is a line of seats and decorative plants. You are given a 0-indexed string corridor of length n consisting of letters 'S' and 'P' where each 'S' represents a seat and each 'P' represents a plant.
//
//One room divider has already been installed to the left of index 0, and another to the right of index n - 1. Additional room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1), at most one divider can be installed.
//
//Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of plants. There may be multiple ways to perform the division. Two ways are different if there is a position with a room divider installed in the first way but not in the second way.
//
//Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 109 + 7. If there is no way, return 0.

public class NumberOfWaysToDivideLongCorridor {

	public int numberOfWays(String a) {
		int presum[] = new int[a.length()];
		int MOD = 1000000007;
		int n = a.length();

		presum[0] = a.charAt(0) == 'S' ? 1 : 0;

		for (int i = 1; i < a.length(); i++) {
			if (a.charAt(i) == 'S') {
				presum[i] = presum[i - 1] + 1;
			} else
				presum[i] = presum[i - 1];
		}
		// if there are total odd number of seats, we cannot divide in any way
		if (presum[n - 1] % 2 != 0)
			return 0;
		// if there are 0 seatch, we cannot divide
		if (presum[n - 1] == 0)
			return 0;

		long ans = 1;

		for (int i = 0; i < presum.length;) {
			if (presum[i] % 2 != 0 || presum[i] == 0) {
				i++;
				continue;
			}
			if (presum[i] == presum[n - 1])
				break;
			// for each even number that we encounter, calculate the plants in between the
			// next seat and current number
			int j = i;
			int count = 0;
			while (j < n && presum[j] == presum[i]) {
				count++;
				j++;
			}
			// our ans gets multiplied by this value
			ans = (ans * count) % MOD;
			i = j;
		}

		return (int) ans;
	}

}
