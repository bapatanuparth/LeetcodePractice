package leetcodeGraphs;

import java.util.HashSet;
import java.util.Set;

public class FindCenterStar {

	// easy solution
	public int findCenterEff(int[][] e) {
		return e[0][0] == e[1][0] || e[0][0] == e[1][1] ? e[0][0] : e[0][1];
	}

	public int findCenter(int[][] edges) {

		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < edges.length; i++) {

			for (int j = 0; j < edges[0].length; j++) {

				if (set.contains(edges[i][j]))
					return edges[i][j];
				else
					set.add(edges[i][j]);
			}
		}

		return 1;
	}
}
