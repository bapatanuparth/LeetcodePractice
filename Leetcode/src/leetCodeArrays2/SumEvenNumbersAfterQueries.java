package leetCodeArrays2;

//You are given an integer array nums and an array queries where queries[i] = [vali, indexi].
//
//For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.
//
//Return an integer array answer where answer[i] is the answer to the ith query.

public class SumEvenNumbersAfterQueries {

	// make sum of all even numbers beforehand
	public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
		int even_sum = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0)
				even_sum += nums[i];
		}

		int[] res = new int[queries.length];

		// the query number can be even /odd and number we are adding to can be even/odd
		// handle these 4 cases separately
		int i = 0;
		for (int[] query : queries) {
			int ind = query[1];
			int val = query[0];

			// query ==4
			if (val % 2 == 0) {

				// i==2
				if (nums[ind] % 2 == 0) {
					nums[ind] += val;
					even_sum += val;
				} else { // i==1
					nums[ind] += val;
				}
			} else { // query ==3
				if (nums[ind] % 2 == 0) { // i==2
					even_sum -= nums[ind];
					nums[ind] += val;
				} else { // i==1
					nums[ind] += val;
					even_sum += nums[ind];
				}
			}

			res[i] = even_sum;
			i++;
		}

		return res;
	}

}
