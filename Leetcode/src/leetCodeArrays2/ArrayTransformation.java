package leetCodeArrays2;

import java.util.LinkedList;
import java.util.List;

public class ArrayTransformation {

	public List<Integer> transformArray(int[] arr) {

		int[] newArr = new int[arr.length];
		boolean changed = false;

		// add to new array while making change
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || i == arr.length - 1) {
				newArr[i] = arr[i];
				continue;
			}

			if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
				newArr[i] = arr[i] + 1;
				changed = true;
				continue;
			}

			if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
				newArr[i] = arr[i] - 1;
				changed = true;
				continue;
			}

			newArr[i] = arr[i];
		}

		// if changed happened, then recursively call the function
		if (changed) {
			return transformArray(newArr);
		}
		// else return result list
		List<Integer> result = new LinkedList<>();

		for (int i : arr) {
			result.add(i);
		}

		return result;
	}
}
