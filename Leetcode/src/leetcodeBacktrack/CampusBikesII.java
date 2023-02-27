package leetcodeBacktrack;

public class CampusBikesII {

	// backtracking solution
	int sum = Integer.MAX_VALUE;

	// consider all possibilities..
	// each worker tries out each other bike and form their combination
	public int assignBikes(int[][] workers, int[][] bikes) {

		backtrack(workers, bikes, 0, 0);
		return sum;
	}

	void backtrack(int[][] workers, int[][] bikes, int ind, int dist) {

		if (ind == workers.length) {
			sum = Math.min(sum, dist);
			return;
		}
		// ind reperesents the worker we are considering for current call
		// each worker tries out all available bikes one by one and we find the
		// combination that yields smallest sum
		for (int i = 0; i < bikes.length; i++) {
			int bike[] = bikes[i];
			if (bike[0] != -1) {
				int val = Math.abs(workers[ind][0] - bike[0]) + Math.abs(workers[ind][1] - bike[1]);
				int x = bike[0];
				bike[0] = -1; // mark bike's value as -1 so that next recursive calls wont pick up the same
								// bike for new worker.
				backtrack(workers, bikes, ind + 1, dist + val);
				bike[0] = x; // refill the previous bike value after that recursive call stack finishes for
								// next iteration
			}

		}

	}

}
