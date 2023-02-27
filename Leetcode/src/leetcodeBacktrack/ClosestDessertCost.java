package leetcodeBacktrack;

//You would like to make dessert and are preparing to buy the ingredients. You have n ice cream base flavors and m types of toppings to choose from. You must follow these rules when making your dessert:
//
//There must be exactly one ice cream base.
//You can add one or more types of topping or have no toppings at all.
//There are at most two of each type of topping.
//You are given three inputs:
//
//baseCosts, an integer array of length n, where each baseCosts[i] represents the price of the ith ice cream base flavor.
//toppingCosts, an integer array of length m, where each toppingCosts[i] is the price of one of the ith topping.
//target, an integer representing your target price for dessert.
//You want to make a dessert with a total cost as close to target as possible.
//
//Return the closest possible cost of the dessert to target. If there are multiple, return the lower one.

public class ClosestDessertCost {

	int result;

	public int closestCostEff(int[] baseCosts, int[] toppingCosts, int target) {
		result = baseCosts[0];
		for (int base : baseCosts)
			helper(base, toppingCosts, 0, target);
		return result;
	}

	private void helper(int current, int[] toppingCosts, int index, int target) {
		if (Math.abs(target - current) < Math.abs(target - result)
				|| Math.abs(target - current) == Math.abs(target - result) && current < result)
			result = current;
		if (index == toppingCosts.length || current >= target)
			return;
		helper(current, toppingCosts, index + 1, target);
		helper(current + toppingCosts[index], toppingCosts, index + 1, target);
		helper(current + toppingCosts[index] * 2, toppingCosts, index + 1, target);
	}

	int min = Integer.MAX_VALUE;
	int ans = Integer.MAX_VALUE;

	// this is primary backtrack solution which needs to be optimized for dynamic
	// programming
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {

		// we can have exactly one base, so we start with each base and backtrack for
		// all possible values of all toppings
		for (int i : baseCosts) {
			backtrack(toppingCosts, target, 0, i);
		}

		return ans;
	}

	void backtrack(int[] toppingCosts, int target, int start, int sum) {

		// for each case, if the current sum after including/ excluding topping is
		// closer to target,
		// update answer
		if ((Math.abs(sum - target)) <= min) {
			// we have to choose the lower answer value of there is a tie among the closest
			// values
			if (min == Math.abs(sum - target)) {
				ans = Math.min(ans, sum);
			} else
				ans = sum;
			min = Math.abs(sum - target);
		}
		// from problem, there can be 3 possibilities,
		// for each topping
		for (; start < toppingCosts.length; start++) {
			// we can either choose the topping twice
			backtrack(toppingCosts, target, start + 1, sum + (2 * toppingCosts[start]));
			// take the topping only once
			backtrack(toppingCosts, target, start + 1, sum + toppingCosts[start]);
			// dont take the topping at all
			backtrack(toppingCosts, target, start + 1, sum);
		}

	}
}
