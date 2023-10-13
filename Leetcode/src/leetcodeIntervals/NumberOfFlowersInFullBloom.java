package leetcodeIntervals;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

//You are given a 0-indexed 2D integer array flowers, where flowers[i] = [starti, endi] means the ith flower will be in full bloom from starti to endi (inclusive). You are also given a 0-indexed integer array people of size n, where people[i] is the time that the ith person will arrive to see the flowers.
//
//Return an integer array answer of size n, where answer[i] is the number of flowers that are in full bloom when the ith person arrives.

public class NumberOfFlowersInFullBloom {

	public int[] fullBloomFlowers(int[][] flowers, int[] people) {
		Queue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
		// sort the flowers based on starting time
		Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
		int[][] mapper = new int[people.length][2];
		// just to map people to theire right index
		for (int i = 0; i < people.length; i++) {
			mapper[i][0] = people[i];
			mapper[i][1] = i;
		}
		// sort people based on their entry time
		Arrays.sort(mapper, (a, b) -> a[0] - b[0]);

		int[] res = new int[people.length];
		int i = 0;
		// for each person
		for (int j = 0; j < mapper.length; j++) {
			// add in all those flowers that bloomed before or on the time of his entry
			while (i < flowers.length && mapper[j][0] >= flowers[i][0]) {
				pq.offer(flowers[i][1]);
				i++;
			}
			// remove all the flowers that are already dead
			while (!pq.isEmpty() && pq.peek() < mapper[j][0])
				pq.poll();

			// the remaining flowers in pq will be the ones that are bloomed on the given
			// day
			res[mapper[j][1]] = pq.size();

		}

		return res;
	}

}
