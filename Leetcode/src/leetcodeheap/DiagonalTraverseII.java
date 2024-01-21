package leetcodeheap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Given a 2D integer array nums, return all elements of nums in diagonal order as shown in the below images.
public class DiagonalTraverseII {

	// Notice that numbers with equal sums of row and column indexes belong to the
	// same diagonal.
	class Point {
		int x;
		int y;
		int sum;

		public Point(int x, int y, int s) {
			this.x = x;
			this.y = y;
			this.sum = s;
		}

	}

	class Solution {
		public int[] findDiagonalOrder(List<List<Integer>> nums) {
			List<Point> ls = new ArrayList<>();
			for (int i = 0; i < nums.size(); i++) {
				for (int j = 0; j < nums.get(i).size(); j++) {
					int sum = i + j;
					ls.add(new Point(i, j, sum));
				}
			}

			Collections.sort(ls, (a, b) -> {
				if (a.sum == b.sum)
					return a.y - b.y;
				else
					return a.sum - b.sum;
			});

			int[] array = new int[ls.size()];
			for (int i = 0; i < ls.size(); i++) {
				Point p = ls.get(i);
				array[i] = nums.get(p.x).get(p.y);
			}
			return array;
		}
	}

}
