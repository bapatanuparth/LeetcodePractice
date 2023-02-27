package leetCodeArrays2;

public class MaximizeDistanceToTheClosestPerson {

	class Solution {

		// for each seat, find the closest filled seat to its left and to its right
		// now for both these values, consider min(closest to left, closest to right)
		// this will give us the seat's distance from other closest seats to its left or
		// right
		// now take maximum of all these distances, this will be our maximized distance
		// from closest filled seat
		public int maxDistToClosest(int[] seats) {

			int[] left = new int[seats.length];
			int[] right = new int[seats.length];
			int n = seats.length - 1;

			int index = 0;
			for (int i = 0; i < seats.length; i++) {
				if (seats[i] == 1)
					left[i] = 0;
				else {
					if (i == 0)
						left[i] = Integer.MAX_VALUE;
					else
						left[i] = left[i - 1] != Integer.MAX_VALUE ? left[i - 1] + 1 : Integer.MAX_VALUE;
				}
			}

			for (int i = seats.length - 1; i >= 0; i--) {
				if (seats[i] == 1)
					right[i] = 0;
				else {
					if (i == n)
						right[i] = Integer.MAX_VALUE;
					else
						right[i] = right[i + 1] != Integer.MAX_VALUE ? right[i + 1] + 1 : Integer.MAX_VALUE;
				}
			}

			int max = 0;
			for (int i = 0; i < seats.length; i++) {
				max = Math.max(max, Math.min(left[i], right[i]));
			}

			return max;
		}
	}
}
