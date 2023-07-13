package leetcodeGraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

public class PathWithMaxProbability {

	class Solution {

		// using Dijkstras shortest path algo
		public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
			Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
			for (int i = 0; i < edges.length; i++) {
				int u = edges[i][0], v = edges[i][1];
				double pathProb = succProb[i];
				graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
				graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
			}

			double[] maxProb = new double[n];
			maxProb[start] = 1d;

			// to keep probabilities in descending order, so we fetch only the element with
			// highest probability value from current element
			PriorityQueue<Pair<Double, Integer>> pq = new PriorityQueue<>(
					(a, b) -> -Double.compare(a.getKey(), b.getKey()));
			pq.add(new Pair<>(1.0, start));
			while (!pq.isEmpty()) {
				Pair<Double, Integer> cur = pq.poll();
				double curProb = cur.getKey();
				int curNode = cur.getValue();
				if (curNode == end) {
					return curProb;
				}
				for (Pair<Integer, Double> nxt : graph.getOrDefault(curNode, new ArrayList<>())) {
					int nxtNode = nxt.getKey();
					double pathProb = nxt.getValue();
					if (curProb * pathProb > maxProb[nxtNode]) {
						maxProb[nxtNode] = curProb * pathProb;
						pq.add(new Pair<>(maxProb[nxtNode], nxtNode));
					}
				}
			}

			return 0d;
		}
	}

	// without dijkstra

	public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		Map<Integer, List<Pair<Integer, Double>>> graph = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0], v = edges[i][1];
			double pathProb = succProb[i];
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair<>(v, pathProb));
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair<>(u, pathProb));
		}

		double[] maxProb = new double[n];
		maxProb[start] = 1d;

		// use simple queue
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int curNode = queue.poll();
			for (Pair<Integer, Double> neighbor : graph.getOrDefault(curNode, new ArrayList<>())) {
				int nxtNode = neighbor.getKey();
				double pathProb = neighbor.getValue();

				// Only update maxProb[nxtNode] if the current path increases
				// the probability of reach nxtNode.
				if (maxProb[curNode] * pathProb > maxProb[nxtNode]) {
					maxProb[nxtNode] = maxProb[curNode] * pathProb;
					queue.offer(nxtNode);
				}
			}
		}

		return maxProb[end];
	}

}
