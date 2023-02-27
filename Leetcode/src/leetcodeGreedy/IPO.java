package leetcodeGreedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
//
//You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
//
//Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
//
//Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
//
//The answer is guaranteed to fit in a 32-bit signed integer.
public class IPO {

	// sort the list based on capital values.
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		int n = capital.length;
		List<int[]> ls = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			ls.add(new int[] { capital[i], profits[i] });
		}

		// Collections.sort(ls, (a,b)-> a[0]-b[0]);
		ls.sort((a, b) -> a[0] - b[0]);

		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int i = 0;
		// for each value in capital , while that value is <= w , add all the profits in
		// a priorityQueue.
		// this means that we will have the maximum possible profit in the admissible
		// projects after this loop runs.
		// add this profit to the weight and continue this process.
		// by the end we will have chosen only from the top of maxheap which will mean
		// that we chose only the max output projects
		while (k > 0) {

			while (i < n && ls.get(i)[0] <= w) {
				pq.add(ls.get(i)[1]);
				i++;
			}

			if (pq.isEmpty())
				return w;

			w += pq.poll();
			k--;
		}

		return w;
	}
}
