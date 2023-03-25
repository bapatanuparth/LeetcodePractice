package leetcodeheap;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//You have k lists of sorted integers in non-decreasing order. Find the smallest range that includes at least one number from each of the k lists.
//
//We define the range [a, b] is smaller than range [c, d] if b - a < d - c or a < c if b - a == d - c.

public class SmallestRangeCoveringElementsKLists {

	class Solution {
		public int[] smallestRange(List<List<Integer>> nums) {
			Queue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);

			// fill priorityQueue with all values
			fillQueue(q, nums);

			// this is used to keep track of each next element from all the lists
			int[][] table = new int[nums.size()][2];

			// make sure before that 1 element from each list is considered
			Set<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.size(); i++) {
				set.add(i);
			}
			// fill the table by polling from queue while making sure that the table has a
			// value from each list
			// get the min and max of table in each iteration and that is the current range.
			// get minimum of this range and elements for which minima is seen
			while (!set.isEmpty()) {
				int[] arr = q.poll();
				int ind = arr[1];
				if (set.contains(ind))
					set.remove(ind);
				table[ind] = arr;
			}

			int range = Integer.MAX_VALUE;
			int ans1 = 0, ans2 = 0;

			// repeat--
			// find min max, get range, add next element to the table
			while (!q.isEmpty()) {
				int[] minmax = findMinMax(table);
				int r = findrange(minmax[0], minmax[1]);

				// update range and answer if lower value is found
				if (r < range) {
					ans1 = minmax[0];
					ans2 = minmax[1];
					range = r;
				}

				int arr[] = q.poll();
				table[arr[1]] = arr;
			}
			// to account for the last value from the table
			int[] minmax = findMinMax(table);
			if (findrange(minmax[0], minmax[1]) < range) {
				ans1 = minmax[0];
				ans2 = minmax[1];
			}
			// return the required array
			return new int[] { ans1, ans2 };
		}

		void fillQueue(Queue<int[]> q, List<List<Integer>> nums) {
			for (int i = 0; i < nums.size(); i++) {
				for (int j = 0; j < nums.get(i).size(); j++) {
					int val = nums.get(i).get(j);
					q.add(new int[] { val, i });
				}
			}
		}

		int findrange(int min, int max) {
			return max - min;
		}

		int[] findMinMax(int[][] table) {
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			for (int i = 0; i < table.length; i++) {
				int arr[] = table[i];
				max = Math.max(max, arr[0]);
				min = Math.min(min, arr[0]);
			}
			return new int[] { min, max };
		}
	}
}
