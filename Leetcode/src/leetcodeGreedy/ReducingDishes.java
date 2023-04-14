package leetcodeGreedy;

import java.util.Arrays;

//A chef has collected data on the satisfaction level of his n dishes. Chef can cook any dish in 1 unit of time.
//
//Like-time coefficient of a dish is defined as the time taken to cook that dish including previous dishes multiplied by its satisfaction level i.e. time[i] * satisfaction[i].
//
//Return the maximum sum of like-time coefficient that the chef can obtain after dishes preparation.
//
//Dishes can be prepared in any order and the chef can discard some dishes to get this maximum value.

public class ReducingDishes {

	public int maxSatisfaction(int[] satisfaction) {
		// dishes can be prepared in any order, so we take dishes in ascending order of
		// their satisfaction
		Arrays.sort(satisfaction);
		int n = satisfaction.length;

		int ans = 0;
		// to get max like-time coeff, we want the maximum value to be multipled by max
		// possible index
		// so we go on checking in reverse to see how far back we can go such that our
		// max satisfaction value is multipled by max possible index
		// to get max like-time coeff, we traverse in reverse, and build the like-time
		// coeff by adding new value in the
		// equation one by one
		// i.e. first we only do satisfaction[n-1]*1 then in second iteration,
		// satisfaction[n-1]*2+satisfaction[n-2]*1
		// this shows we are building an array and last dish is prepared at time 2, and
		// second last prepared at time 1
		for (int i = 1; i <= n; i++) {
			int j = 0;
			int val = 0;
			while (j < i) {
				val += satisfaction[n - 1 - j] * (i - j);
				j++;
			}
			ans = Math.max(val, ans);
		}
		// taking max of answer gives us the exaact max like-time coeff that we can get
		return ans;
	}

}
