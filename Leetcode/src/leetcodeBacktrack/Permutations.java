package leetcodeBacktrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Permutations {

	// Best Solution
	public List<List<Integer>> permuteEfficient(int[] nums) {
		List<List<Integer>> result = new LinkedList<List<Integer>>();
		generatePermutations(nums, 0, nums.length - 1, result);
		return result;
	}

	private void generatePermutations(int nums[], int start, int end, List<List<Integer>> result) {
		if (start == end) {
			List<Integer> list = new LinkedList<Integer>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			result.add(list);
			return;
		}

		for (int i = start; i <= end; i++) {
			int t = nums[start];
			nums[start] = nums[i];
			nums[i] = t;

			generatePermutations(nums, start + 1, end, result);

			t = nums[start];
			nums[start] = nums[i];
			nums[i] = t;
		}
	}

	// solution can even be optimized further by adding visited[] array to maintain
	// instead of a set
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> out = new ArrayList<>(); // output
		List<Integer> temp = new ArrayList<>(); // temp list that we will modify recursively
		Set<Integer> set = new HashSet<>(); // to keep track of which indexes have been chosen already

		perm(out, temp, set, nums);
		return out;
	}

	void perm(List<List<Integer>> out, List<Integer> temp, Set<Integer> set, int[] nums) {
		if (set.size() == nums.length)
			out.add(new ArrayList<>(temp));

		for (int i = 0; i < nums.length; i++) { // check for all numbers in array, if the number is not added in temp,
												// then add it
			if (!set.contains(i)) { // if set contains i, it means nums[i] is already chosen in permutation
				set.add(i); // if i not in set, add it, so that all future calls wont add nums[i] and it
							// will be locked
				temp.add(nums[i]); // add no in temp list
				perm(out, temp, set, nums); // keep modifying temp list, from beginning add those elements that arent in
											// set one at a time
				temp.remove(temp.size() - 1);
				set.remove(i); // remove element from set and go for next iteration to bring the next element
								// ahead and repeat the process so all combinations are seen
			}
		}

		return;
	}
}
