package leetcodeGraphs;
//There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

//
//A province is a group of directly or indirectly connected cities and no other cities outside of the group.
//
//You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.
//
//Return the total number of provinces.

public class NumberOfProvinces {

	public int findCircleNum(int[][] isConnected) {
		int v = isConnected.length;
		boolean[] visited = new boolean[v];
		int province = 0;
		for (int i = 0; i < v; i++) {
			if (!visited[i]) {
				dfs(isConnected, i, visited, v);
				province++;
			}
		}
		return province;
	}

	public void dfs(int[][] isConnected, int sv, boolean[] visited, int v) {
		visited[sv] = true;
		for (int i = 0; i < v; i++) {
			if (!visited[i] && isConnected[sv][i] == 1) {
				dfs(isConnected, i, visited, v);
			}
		}
	}
}
