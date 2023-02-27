package leetcodeGraphs;

//You have a map that marks the location of a treasure island. Some of the map area has jagged rocks and dangerous reefs. Other areas are safe to sail in. There are other explorers trying to find the treasure. So you must figure out a shortest route to the treasure island.
//
//Assume the map area is a two dimensional grid, represented by a matrix of characters. You must start from the top-left corner of the map and can move one block up, down, left or right at a time. The treasure island is marked as X in a block of the matrix. X will not be at the top-left corner. Any block with dangerous rocks or reefs will be marked as D. You must not enter dangerous blocks. You cannot leave the map area. Other areas O are safe to sail in. The top-left corner is always safe. Output the minimum number of steps to get to the treasure.

public class TreasureIsland {

	private int distance = Integer.MAX_VALUE;

	public int findShortestRoute(char[][] island) {
		if (island == null) {
			return -1;
		}
		boolean[][] visited = new boolean[island.length][island[0].length];
		dfs(island, 0, 0, visited, 0);

		return distance;
	}

	public void dfs(char[][] grid, int i, int j, boolean[][] visited, int levelDistance) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 'D' || visited[i][j]) {
			return;
		}
		if (grid[i][j] == 'X') {
			distance = Math.min(distance, levelDistance);
			return;
		}
		visited[i][j] = true;

		dfs(grid, i, j - 1, visited, levelDistance + 1); // back
		dfs(grid, i - 1, j, visited, levelDistance + 1);// up
		dfs(grid, i, j + 1, visited, levelDistance + 1);// forward
		dfs(grid, i + 1, j, visited, levelDistance + 1);// downward

		visited[i][j] = false;
	}

	public static void main(String[] args) {
		TreasureIsland obj = new TreasureIsland();
		char[][] input = { { 'O', 'O', 'O', 'O' }, { 'D', 'O', 'D', 'O' }, { 'X', 'O', 'O', 'O' },
				{ 'O', 'D', 'D', 'O' } };

		System.out.println(obj.findShortestRoute(input));

	}
}
