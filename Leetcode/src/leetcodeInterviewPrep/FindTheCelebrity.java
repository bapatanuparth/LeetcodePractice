package leetcodeInterviewPrep;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class FindTheCelebrity {

	private int numberOfPeople;
	private Map<Pair<Integer, Integer>, Boolean> cache = new HashMap<>();

	public boolean knows(int a, int b) {
		if (!cache.containsKey(new Pair<Integer, Integer>(a, b))) {
			cache.put(new Pair<Integer, Integer>(a, b), true); // replace true by super.knows(a, b));
		}
		return cache.get(new Pair<Integer, Integer>(a, b));
	}

	public int findCelebrity(int n) {

		int candidate = 0;
		for (int other = 1; other < n; other++) {
			if (knows(candidate, other) || !knows(other, candidate))
				candidate = other;
		}

		for (int other = 0; other < n; other++) {
			if (other == candidate)
				continue;
			if (knows(candidate, other) || !knows(other, candidate))
				return -1;
		}

		return candidate;
	}
}
