package leetcode150daysArrays;

//We can mark the start and end of each life as +1 and -1 on the timeline. Then, we go through timeline from 1950 to 2050 and accumulate the current population for each year.

public class MaximumPopulationYear {

	public int maximumPopulation(int[][] logs) {
		int year[] = new int[2051];

		for (int[] log : logs) {
			year[log[0]] += 1;
			year[log[1]] -= 1;
		}

		int maxNum = year[1950], maxYear = 1950;

		for (int i = 1951; i <= 2050; i++) {
			year[i] += year[i - 1];
			if (year[i] > maxNum) {
				maxNum = year[i];
				maxYear = i;
			}
		}

		return maxYear;
	}
}
