package leetcodeMath;

import java.util.ArrayList;
import java.util.List;

//You are given a 0-indexed 2D array variables where variables[i] = [ai, bi, ci, mi], and an integer target.
//
//An index i is good if the following formula holds:
//
//0 <= i < variables.length
//((aibi % 10)ci) % mi == target
//Return an array consisting of good indices in any order.

public class DoubleModularExponentiation {

	public List<Integer> getGoodIndices(int[][] variables, int target) {
		List<Integer> ans = new ArrayList<>();
		for (int i = 0; i < variables.length; i++) {
			int val = task(variables[i][0], variables[i][1], 10);
			int val1 = task(val, variables[i][2], variables[i][3]);
			if (val1 == target) {
				ans.add(i);
			}
		}
		return ans;
	}

	public int task(int a, int b, int m) {
		int sum = 1;
		while (b != 0) {
			sum *= a;
			sum = sum % m;
			b--;
		}
		return sum;
	}

}
