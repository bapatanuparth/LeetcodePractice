package leetcodeheap;

import java.util.Arrays;
import java.util.PriorityQueue;

//There is a party where n friends numbered from 0 to n - 1 are attending. There is an infinite number of chairs in this party that are numbered from 0 to infinity. When a friend arrives at the party, they sit on the unoccupied chair with the smallest number.
//
//For example, if chairs 0, 1, and 5 are occupied when a friend comes, they will sit on chair number 2.
//When a friend leaves the party, their chair becomes unoccupied at the moment they leave. If another friend arrives at that same moment, they can sit in that chair.
//
//You are given a 0-indexed 2D integer array times where times[i] = [arrivali, leavingi], indicating the arrival and leaving times of the ith friend respectively, and an integer targetFriend. All arrival times are distinct.
//
//Return the chair number that the friend numbered targetFriend will sit on.

public class NumberOfSmallestUnoccupiedChair {

	class Pair {
		int chair;
		int vacancyTime;

		public Pair(int c, int v) {
			this.chair = c;
			this.vacancyTime = v;
		}
	}

	public int smallestChair(int[][] times, int targetFriend) {
		int targetArrival = times[targetFriend][0];

		Arrays.sort(times, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

		PriorityQueue<Integer> availableSeats = new PriorityQueue<>();
		for (int i = 0; i < times.length; i++) {
			availableSeats.offer(i);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.vacancyTime - b.vacancyTime);

		for (int i = 0; i < times.length; i++) {
			int arr = times[i][0];
			int leave = times[i][1];
			while (!pq.isEmpty() && pq.peek().vacancyTime <= arr)
				availableSeats.offer(pq.poll().chair);
			if (arr == targetArrival)
				return availableSeats.peek();

			pq.offer(new Pair(availableSeats.poll(), leave));
		}

		return 0;
	}

}
