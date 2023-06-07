package leetCodeArrays2;

//You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

public class CheckIfStraightLine {

	class Solution {
		public boolean checkStraightLine(int[][] coordinates) {
			if (coordinates.length <= 2)
				return true;

			int[] p1 = coordinates[0];
			int[] p2 = coordinates[1];
			int a = p1[1] - p2[1];
			int b = p1[0] * a;
			int c = p1[0] - p2[0];
			int d = p1[1] * c;

			for (int i = 2; i < coordinates.length; i++) {
				int[] p = coordinates[i];
				int lhs = p[0] * a - b;
				int rhs = p[1] * c - d;
				if (lhs != rhs)
					return false;
			}

			return true;
		}
	}

}
