package leetcodeInterviewPrep;

import java.util.Arrays;

//You are assigned to put some amount of boxes onto one truck. You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
//
//numberOfBoxesi is the number of boxes of type i.
//numberOfUnitsPerBoxi is the number of units in each box of the type i.
//You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck. You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
//
//Return the maximum total number of units that can be put on the truck.

//Input: boxTypes = [[5,10],[2,5],[4,7],[3,9]], truckSize = 10
//Output: 91
public class MaximumUnitsOnTruck {

	// o(n) solution using bucket sort
//	The constraint that "boxes per unit" will be max 1000 allows us to use 1000 buckets to sort by boxes per unit.
//	Ie., we can create an array where the indices represent 0 boxes per unit, 1 boxes per unit, 2 boxes per unit, 3 boxes per unit, ... 1000 boxes per unit. And the buckets[i] will represent the number of boxes at each index.
//
//	Algorithm:
//
//	take the given data and sort it into the 1000 buckets. this is O(n) because we loop over the given data once.
//	loop over the buckets backwards- so that we start at a higher boxes per unit to get as many units as possible. in each iteration:
//	check if the current bucket has any values (isn't -1).
//	if the bucket has a value, check if the truck has space enough for all the boxes. if yes, load up all units.
//	if the truck hasn't enough space, load up only the units you can.
	public int maximumUnitsEff(int[][] boxTypes, int truckSize) {
		int[] map = new int[1001];
		for (int[] boxType : boxTypes) {
			map[boxType[1]] += boxType[0];
		}
		int total = 0;
		for (int i = 1000; i >= 0; i--) {
			if (map[i] != 0) {
				if (map[i] < truckSize) {
					total += i * map[i];
					truckSize -= map[i];
				} else {
					total += i * truckSize;
					break;
				}
			}
		}
		return total;
	}

	// o(nlogn) solution
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

		int count = 0;

		outer: for (int i = 0; i < boxTypes.length; i++) {

			for (int numbox = 0; numbox < boxTypes[i][0]; numbox++) {
				if (truckSize == 0)
					break outer;
				count += boxTypes[i][1];
				truckSize--;
			}

		}

		return count;
	}
}
