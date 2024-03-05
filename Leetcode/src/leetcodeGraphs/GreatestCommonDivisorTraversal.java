package leetcodeGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You are given a 0-indexed integer array nums, and you are allowed to traverse between its indices. You can traverse between index i and index j, i != j, if and only if gcd(nums[i], nums[j]) > 1, where gcd is the greatest common divisor.
//
//Your task is to determine if for every pair of indices i and j in nums, where i < j, there exists a sequence of traversals that can take us from i to j.
//
//Return true if it is possible to traverse between all such pairs of indices, or false otherwise.

public class GreatestCommonDivisorTraversal {
	class Graph {
		private int n;
		private Map<Integer, List<Integer>> edges;
		private boolean[] visited;

		private void traverse(int x) {
			visited[x] = true;
			if (!edges.containsKey(x)) {
				return;
			}
			for (int y : edges.get(x)) {
				if (!visited[y]) {
					traverse(y);
				}
			}
		}

		public Graph(int n) {
			this.n = n;
			edges = new HashMap<>();
			visited = new boolean[n];
		}

		public void addEdge(int x, int y) {
			edges.computeIfAbsent(x, value -> new ArrayList<Integer>()).add(y);
			edges.computeIfAbsent(y, value -> new ArrayList<Integer>()).add(x);
		}

		public boolean isConnected() {
			Arrays.fill(visited, false);
			traverse(0);
			int count = 0;
			for (boolean v : visited) {
				count += v ? 1 : 0;
			}
			return count == n;
		}
	}

	class Solution {
		private List<Integer> getPrimeFactors(int x) {
			List<Integer> primeFactors = new ArrayList<>();
			for (int i = 2; i * i <= x; i++) {
				if (x % i == 0) {
					primeFactors.add(i);
					while (x % i == 0) {
						x /= i;
					}
				}
			}
			if (x != 1) {
				primeFactors.add(x);
			}
			return primeFactors;
		}

		public boolean canTraverseAllPairs(int[] nums) {
			int n = nums.length;
			if (n == 1) {
				return true;
			}
			Graph g = new Graph(n);
			HashMap<Integer, Integer> seen = new HashMap<>();
			for (int i = 0; i < n; i++) {
				if (nums[i] == 1) {
					return false;
				}
				List<Integer> primeFactors = getPrimeFactors(nums[i]);
				for (int prime : primeFactors) {
					if (seen.containsKey(prime)) {
						g.addEdge(i, seen.get(prime));
					} else {
						seen.put(prime, i);
					}
				}
			}
			return g.isConnected();
		}
	}

}
