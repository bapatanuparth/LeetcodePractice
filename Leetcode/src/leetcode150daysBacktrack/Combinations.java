package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//
//You may return the answer in any order.

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {
		List<Integer> out = new ArrayList<>();
		List<List<Integer>> res = new ArrayList<>();

		makeCombine(res, out, n, k, 0);
		return res;
	}

	void makeCombine(List<List<Integer>> res, List<Integer> out, int n, int k, int i) {

		if (out.size() == k) {
			res.add(new ArrayList<>(out));
			return;
		}

		for (; i < n; i++) {
			out.add(i + 1);
			makeCombine(res, out, n, k, i + 1);
			out.remove(out.size() - 1);
		}

	}

}
