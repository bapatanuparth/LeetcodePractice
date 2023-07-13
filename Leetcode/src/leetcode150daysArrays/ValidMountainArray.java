package leetcode150daysArrays;

//Given an array of integers arr, return true if and only if it is a valid mountain array.
//
//Recall that arr is a mountain array if and only if:
//
//arr.length >= 3
//There exists some i with 0 < i < arr.length - 1 such that:
//arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
//arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

public class ValidMountainArray {

	public boolean validMountainArray(int[] arr) {
		if (arr.length < 3)
			return false;
		int increasing = 0, decreasing = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[i - 1]) {
				if (decreasing != 0)
					return false;
				increasing++;
			} else if (arr[i] == arr[i - 1]) {
				return false;
			} else
				decreasing++;
		}
		if (decreasing == 0 || increasing == 0)
			return false;
		return true;
	}
}
