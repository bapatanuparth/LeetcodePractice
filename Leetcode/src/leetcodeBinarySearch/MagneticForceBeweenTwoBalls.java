package leetcodeBinarySearch;

import java.util.Arrays;

//In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket. Rick has n empty baskets, the ith basket is at position[i], Morty has m balls and needs to distribute the balls into the baskets such that the minimum magnetic force between any two balls is maximum.
//
//Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
//
//Given the integer array position and the integer m. Return the required force.

public class MagneticForceBeweenTwoBalls {

	boolean canPlaceBalls(int mid, int[] position, int m) {
		int prevPos = position[0];
		int ballsPlaced = 1;

		for (int i = 1; i < position.length && ballsPlaced < m; i++) {
			int nextPos = position[i];
			if (nextPos - prevPos >= mid) {
				ballsPlaced++;
				prevPos = nextPos;
			}
		}

		if (ballsPlaced == m)
			return true;
		return false;

	}

	public int maxDistance(int[] position, int m) {

		Arrays.sort(position);
		int maxPos = position[position.length - 1];

		int left = 1, right = maxPos, ans = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (canPlaceBalls(mid, position, m)) {
				ans = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return ans;
	}

}
