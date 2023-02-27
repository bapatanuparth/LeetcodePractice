package leetcodeGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EarliestPossibleDayOfFullBloom {

	// Sort the seeds by their growTime in descending order. Can you prove why this
	// strategy is the other part of
	// the optimal solution? Note the bloom time of a seed is the sum of plantTime
	// of all seeds preceding this seed
	// plus the growTime of this seed.
	public int earliestFullBloom(int[] plantTime, int[] growTime) {

		int n = growTime.length;

		List<Integer> indices = new ArrayList<>();
		for (int i = 0; i < n; i++)
			indices.add(i);

		Collections.sort(indices, (a, b) -> growTime[b] - growTime[a]);

		int result = 0;
		int curPlantTime = 0;
		for (int i = 0; i < n; i++) {

			int ind = indices.get(i); // this will give us indices in the descending order of growtime
			int time = curPlantTime + plantTime[ind] + growTime[ind];
			result = Math.max(result, time);
			curPlantTime += plantTime[ind];
		}

		return result;
	}
}
