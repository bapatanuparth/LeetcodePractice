package leetcodeGraphs;

public class FindTheCelebrity {

	// more efficient solution
	public int findCelebrityEff(int n) {

		int candidate = 0;
		for (int other = 1; other < n; other++) {
			// if (knows(candidate, other) || !knows(other, candidate))
			candidate = other;
		}

		for (int other = 0; other < n; other++) {
			if (other == candidate)
				continue;
			// if (knows(candidate, other) || !knows(other, candidate))
			return -1;
		}

		return candidate;
	}

	// Naive solution
	public int findCelebrity(int n) {

		int[] incoming = new int[n];
		int[] outgoing = new int[n];

		for (int i = 0; i < n; i++) {

			for (int j = 0; j < n; j++) {
				if (i != j) { // && knows(i, j)) {
					incoming[j]++;
					outgoing[i]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {

			if (incoming[i] == n - 1 && outgoing[i] == 0)
				return i;
		}

		return -1;
	}
}
