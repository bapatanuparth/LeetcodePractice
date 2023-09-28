package leetcodeGreedy;

//There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the point n. (i.e The length of the garden is n).
//
//There are n + 1 taps located at points [0, 1, ..., n] in the garden.
//
//Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
//
//Return the minimum number of taps that should be open to water the whole garden, If the garden cannot be watered return -1.

public class MinimumNumberOfTapsToOpenToWaterGarden {

	public int minTaps(int n, int[] ranges) {
		int maxArr[] = new int[ranges.length];
		// for each plant, find the maximum right range that can be watered including
		// that pkant
		// pre compute this array
		// so for ith plant, we know the maximum range a tap can go starting from that
		// plant.
		for (int i = 0; i < ranges.length; i++) {
			int left = Math.max(0, i - ranges[i]);
			int right = i + ranges[i];
			maxArr[left] = Math.max(maxArr[left], right);
		}

		int end = 0;
		int count = 0;
		int farReach = 0;
		// now mark the first maximum point we can reach from this i
		for (int i = 0; i < ranges.length && end < n; end = farReach) {
			count++; // opened first tap
			// go through all possible points in between up to the current watered range
			// so means we have already watered till end==4, go till that plant and see if
			// we can reach any
			// max point ahead of 4
			// if yes, gop back in the loop until we reach the end
			while (i <= end && i < ranges.length) {
				farReach = Math.max(farReach, maxArr[i]);
				i++;
			}
			if (farReach == end)
				return -1;
		}

		return count;
	}

}
