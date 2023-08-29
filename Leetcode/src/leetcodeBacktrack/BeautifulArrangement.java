package leetcodeBacktrack;

//Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
//
//perm[i] is divisible by i.
//i is divisible by perm[i].
//Given an integer n, return the number of the beautiful arrangements that you can construct.

public class BeautifulArrangement {
	int count = 0;

	public int countArrangement(int n) {
		int[] arr = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			arr[i] = i;
		}
		dfs(arr, n);
		return count;
	}

	void dfs(int arr[], int ind) {
		if (ind == 0) {
			count++;
			return;
		}

		for (int i = ind; i > 0; i--) {
			int temp = arr[i];
			arr[i] = arr[ind];
			arr[ind] = temp;

			if (ind % arr[ind] == 0 || arr[ind] % ind == 0)
				dfs(arr, ind - 1);

			temp = arr[i];
			arr[i] = arr[ind];
			arr[ind] = temp;
		}
	}

}
