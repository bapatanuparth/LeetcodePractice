package leetcodeStrings;

//You are given a 0-indexed array of strings garbage where garbage[i] represents the assortment of garbage at the ith house. garbage[i] consists only of the characters 'M', 'P' and 'G' representing one unit of metal, paper and glass garbage respectively. Picking up one unit of any type of garbage takes 1 minute.
//
//You are also given a 0-indexed integer array travel where travel[i] is the number of minutes needed to go from house i to house i + 1.
//
//There are three garbage trucks in the city, each responsible for picking up one type of garbage. Each garbage truck starts at house 0 and must visit each house in order; however, they do not need to visit every house.
//
//Only one garbage truck may be used at any given moment. While one truck is driving or picking up garbage, the other two trucks cannot do anything.
//
//Return the minimum number of minutes needed to pick up all the garbage.

public class MinimumAmountOfTimeToCollectGarbage {

	public int garbageCollection(String[] garbage, int[] travel) {
		int last[] = new int[128], res = 0;
		// as each type of garbage takes same amount of time, each string length can be
		// added directly to result
		for (int i = 0; i < garbage.length; ++i) {
			res += garbage[i].length(); // add string length to result
			// find the last occurrence of every type of garbage
			for (int j = 0; j < garbage[i].length(); ++j)
				last[garbage[i].charAt(j)] = i;
		}

		// calculate prefix sum of the travel array, this way we get the amount of time
		// required to reach the last occurring index of any type of garbage directly
		for (int j = 1; j < travel.length; ++j)
			travel[j] += travel[j - 1];
		// for each type of garbage, add directly the total travel time for the truck to
		// reach its last occurrence
		for (int c : "PGM".toCharArray())
			if (last[c] > 0)
				res += travel[last[c] - 1];
		return res;
	}
}
