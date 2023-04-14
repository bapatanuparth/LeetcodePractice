package leetcodeGreedy;

import java.util.Arrays;

public class BoatsToSavePeople {

	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);

		int boats = 0;
		int left = 0;
		int right = people.length - 1;

		while (left <= right) {
			// we count a whole new boat for a single people[right] if he cannot be paired
			// with poeple[left]
			while (left < right && people[left] + people[right] > limit) {
				boats++;
				right--;
			}
			// this means only one person left, assign a new boat and end loop
			if (left == right) {
				boats++;
				break;
			}

			// if we get here, means we encountered a case where 2 separate people can be
			// fit on the same boat
			// so we add one boat for these two and move both pointers for next possible
			// pair
			if (people[left] + people[right] <= limit) {
				boats++;
				left++;
				right--;
			}

		}

		return boats;
	}
}
