package leetcodeGreedy;

import java.util.PriorityQueue;
import java.util.Queue;

//You have some number of sticks with positive integer lengths. These lengths are given as an array sticks, where sticks[i] is the length of the ith stick.
//
//You can connect any two sticks of lengths x and y into one stick by paying a cost of x + y. You must connect all the sticks until there is only one stick remaining.
//
//Return the minimum cost of connecting all the given sticks into one stick in this way.

public class MinCostToConnectSticks {

	public int connectSticks(int[] sticks) {

		if (sticks.length == 1)
			return 0;
		Queue<Integer> q = new PriorityQueue<>();

		for (int i : sticks)
			q.add(i);

		int sum = 0;
		while (q.size() > 1) {
			int a = q.poll();
			int b = q.poll();
			sum += a + b;
			q.add(a + b);
		}

		return sum;
	}

}
