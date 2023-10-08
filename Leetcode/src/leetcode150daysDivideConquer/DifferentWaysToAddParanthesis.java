package leetcode150daysDivideConquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Given a string expression of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. You may return the answer in any order.
//
//The test cases are generated such that the output values fit in a 32-bit integer and the number of different results does not exceed 104.

public class DifferentWaysToAddParanthesis {

	/*
	 * We will call +/-symbols.
	 * 
	 * (base) case 1: if there is 0 symbol, e.g. 1, we simply return it as a list,
	 * [1].
	 * 
	 * case 2: if there is 1 symbol, e.g., 1 + 2, we divide it by symbol and add
	 * parenthesis in both sides: (1) + (2), (1) and (2) reduce to case 1, and we
	 * add the results of both sides and return as a list, [3].
	 * 
	 * case 3: if there are 2 symbols, e.g., 1 + 2 + 3, we divide it by symbol and
	 * add parenthesis in both sides: (1) + (2 + 3) or (1 + 2) + (3). Take (1) + (2
	 * + 3) for example, (1) reduces to case1, (2 + 3) reduces to case 2 (then case
	 * 1), finally we add the results of both sides and add the final ressult to the
	 * list, [6]. ...
	 * 
	 * If there are n symbols, for each symbol, we divide it into two parts and add
	 * parenthesis in both sides, each side is reduced to a subproblem which can be
	 * solved recursively, finally we combine the results of both sides by the
	 * symbol and add to the final result list.
	 */
	Map<String, List<Integer>> map;

	public List<Integer> diffWaysToCompute(String input) {
		map = new HashMap<>();

		if (map.containsKey(input))
			return map.get(input);

		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				String p1 = input.substring(0, i);
				String p2 = input.substring(i + 1);

				List<Integer> r1 = map.getOrDefault(p1, diffWaysToCompute(p1));
				List<Integer> r2 = map.getOrDefault(p2, diffWaysToCompute(p2));

				for (int i1 : r1) {
					for (int i2 : r2) {
						if (c == '+')
							res.add(i1 + i2);
						else if (c == '-')
							res.add(i1 - i2);
						else
							res.add(i1 * i2);
					}
				}
			}
		}
		if (res.size() == 0) {
			res.add(Integer.parseInt(input));
		}
		map.put(input, res);
		return res;
	}

}
