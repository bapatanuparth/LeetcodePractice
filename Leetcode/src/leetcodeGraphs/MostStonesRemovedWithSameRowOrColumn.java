package leetcodeGraphs;

import java.util.HashSet;
import java.util.Set;

//On a 2D plane, we place n stones at some integer coordinate points. Each coordinate point may have at most one stone.
//
//A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
//
//Given an array stones of length n where stones[i] = [xi, yi] represents the location of the ith stone, return the largest possible number of stones that can be removed.

//Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
//Output: 5
public class MostStonesRemovedWithSameRowOrColumn {

	void dfs(int[] s1, Set<int[]> visited, int[][] stones) {

		visited.add(s1);

		// Iterate over the adjacent, and iterate over it if not visited yet
		for (int[] s2 : stones) {
			if (!visited.contains(s2)) {
				if (s1[0] == s2[0] || s1[1] == s2[1]) {
					dfs(s2, visited, stones);
				}
			}
		}
	}

	int removeStones(int[][] stones) {
		Set<int[]> visited = new HashSet<>();
		int numOfIsland = 0;
		// here num of islands mark the element points that can be used as starting
		// points and find all the other points that lie in either same row or column of
		// that point
		// all such elements that are part of one island will be removed except the 1
		// stone that was used as starting point
		// there can exist different islands in the graph. and the stones that can be
		// removed == total stones- total starting points of different islands, i.e
		// total # of islands
		for (int[] s1 : stones) {
			if (!visited.contains(s1)) {
				dfs(s1, visited, stones);
				numOfIsland++;
			}
		}

		return stones.length - numOfIsland;
	}
}
