package leetcodeTwoPointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements {

	class Solution { // similar approach using binary search
		// dont add elements to output, just create a window and then copy all the
		// elements from the window in the output
		public List<Integer> findClosestElements(int[] arr, int k, int x) {
			List<Integer> result = new ArrayList<Integer>();

			// Base case
			if (arr.length == k) {
				for (int i = 0; i < k; i++) {
					result.add(arr[i]);
				}

				return result;
			}

			// Binary search to find the closest element
			int left = 0;
			int right = arr.length;
			int mid = 0;
			while (left < right) {
				mid = (left + right) / 2;
				if (arr[mid] >= x) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			// Initialize our sliding window's bounds
			left -= 1;
			right = left + 1;

			// While the window size is less than k
			while (right - left - 1 < k) {
				// Be careful to not go out of bounds
				if (left == -1) {
					right += 1;
					continue;
				}

				// Expand the window towards the side with the closer number
				// Be careful to not go out of bounds with the pointers
				if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
					left -= 1;
				} else {
					right += 1;
				}
			}

			// Build and return the window
			for (int i = left + 1; i < right; i++) {
				result.add(arr[i]);
			}

			return result;
		}
	}

	public List<Integer> findClosestElements(int[] arr, int k, int x) {

		List<Integer> res = new ArrayList<>();

		// Queue<Integer> res = new PriorityQueue<>((a,b)->b-a);

		int temp = 0;
		int left = 0, right = 0;

		// find the element ==x or the next element greater than x
		int i = 0;
		while (i < arr.length && arr[i] < x) {
			i++;
		}

		// if element == x, add it in output and make 2 pointer left and right point to
		// i-1 and i+1
		if (i < arr.length && arr[i] == x) {
			res.add(arr[i]);
			k--;
			left = i - 1;
			right = i + 1;
		}

		// if element x is not present, take left and right to immediate lower and upper
		// element of x
		if (i >= arr.length || arr[i] > x) {
			right = i;
			left = i - 1;
		}

		// add greedily whichever is closest and move right ++ or left -- in array
		while (left >= 0 && right < arr.length && k > 0) {
			if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
				res.add(arr[left]);
				left--;
				k--;
			}

			else if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
				res.add(arr[right]);
				right++;
				k--;
			}
		}

		// if we reach any end of array and still k>0, add elements from the remaining
		// side
		if (left < 0 && k > 0) {
			while (right < arr.length && k > 0) {
				res.add(arr[right]);
				right++;
				k--;
			}
		}

		else if (right >= arr.length && k > 0) {

			while (left >= 0 && k > 0) {
				res.add(arr[left]);
				left--;
				k--;
			}
		}

		// sort and return, idk for some reason pq did not work
		Collections.sort(res);

		return res;

	}
}
