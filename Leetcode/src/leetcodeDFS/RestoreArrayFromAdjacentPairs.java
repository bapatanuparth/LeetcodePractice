package leetcodeDFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember every pair of adjacent elements in nums.
//
//You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] indicates that the elements ui and vi are adjacent in nums.
//
//It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
//
//Return the original array nums. If there are multiple solutions, return any of them

public class RestoreArrayFromAdjacentPairs {

	Map<Integer, List<Integer>> adj;
	Set<Integer> set;
	int[] res;
	int index = 0;

	public int[] restoreArray(int[][] adjacentPairs) {
		res = new int[adjacentPairs.length + 1];
		adj = new HashMap<>();
		set = new HashSet<>();

		int start = getStartingPoint(adjacentPairs);

		for (int[] a : adjacentPairs) {
			if (!adj.containsKey(a[0])) {
				List<Integer> ls = new ArrayList<>();
				adj.put(a[0], ls);
			}
			adj.get(a[0]).add(a[1]);
			if (!adj.containsKey(a[1])) {
				List<Integer> ls = new ArrayList<>();
				adj.put(a[1], ls);
			}
			adj.get(a[1]).add(a[0]);
		}

		dfs(start);

		return res;

	}

	void dfs(int node) {
		set.add(node);
		res[index++] = node;
		for (int neigh : adj.get(node)) {
			if (!set.contains(neigh)) {
				dfs(neigh);
			}
		}
	}

	int getStartingPoint(int[][] adjacent) {
		Set<Integer> s = new HashSet<>();
		for (int[] arr : adjacent) {
			if (s.contains(arr[0]))
				s.remove(arr[0]);
			else
				s.add(arr[0]);
			if (s.contains(arr[1]))
				s.remove(arr[1]);
			else
				s.add(arr[1]);
		}

		for (int i : s)
			return i;

		return 2;
	}
}
