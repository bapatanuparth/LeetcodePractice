package leetcode150daysBacktrack;

import java.util.ArrayList;
import java.util.List;

//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

public class CombinationSumIII {

	List<List<Integer>> res;

	public List<List<Integer>> combinationSum3(int k, int n) {
		res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		combinations(k, 9, n, temp);
		return res;
	}

	void combinations(int k, int n, int sum, List<Integer> temp) {
		if (sum == 0 && k == 0) {
			res.add(new ArrayList<>(temp));
			return;
		}

		if (k == 0 || n == 0 || sum == 0)
			return;

		combinations(k, n - 1, sum, temp);

		if (n <= sum) {
			temp.add(n);
			combinations(k - 1, n - 1, sum - n, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
