package leetcode150daysGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.
//
//You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.
//
//Return the answers to all queries. If a single answer cannot be determined, return -1.0.
//
//Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.
//
//Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.

public class EvaluateDivision {

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int n = queries.size();
		double[] result = new double[n];

		Map<String, Map<String, Double>> map = new HashMap<>();

		for (int i = 0; i < values.length; i++) {
			List<String> equation = equations.get(i);
			String first = equation.get(0);
			String sec = equation.get(1);

			map.putIfAbsent(first, new HashMap<>());
			map.putIfAbsent(sec, new HashMap<>());

			map.get(first).put(sec, values[i]);
			map.get(sec).put(first, 1 / values[i]);
		}

		int index = 0;
		for (List<String> query : queries) {
			String from = query.get(0);
			String target = query.get(1);

			if (!map.containsKey(from) || !map.containsKey(target)) {
				result[index++] = -1;
				continue;
			}
			result[index++] = dfs(map, from, target, new HashSet<>());
		}

		return result;
	}

	double dfs(Map<String, Map<String, Double>> map, String from, String target, Set<String> isVisited) {
		if (from.equals(target))
			return 1;

		Map<String, Double> next = map.get(from);
		for (Map.Entry<String, Double> e : next.entrySet()) {
			String to = e.getKey();
			if (isVisited.contains(to))
				continue;
			isVisited.add(to);
			double value = e.getValue();
			double result = dfs(map, to, target, isVisited);
			if (result >= 0)
				return value * result;
		}

		return -1;
	}
}
