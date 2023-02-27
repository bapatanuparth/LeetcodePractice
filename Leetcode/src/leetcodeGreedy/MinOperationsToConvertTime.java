package leetcodeGreedy;

//You are given two strings current and correct representing two 24-hour times.
//
//24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. The earliest 24-hour time is 00:00, and the latest is 23:59.
//
//In one operation you can increase the time current by 1, 5, 15, or 60 minutes. You can perform this operation any number of times.
//
//Return the minimum number of operations needed to convert current to correct.

public class MinOperationsToConvertTime {
	public int convertTime(String current, String correct) {
		int currMin = Integer.parseInt(current.substring(0, 2)) * 60 + Integer.parseInt(current.substring(3));
		int correctMin = Integer.parseInt(correct.substring(0, 2)) * 60 + Integer.parseInt(correct.substring(3));

		int[] arr = new int[] { 60, 15, 5, 1 };

		int i = 0;
		int moves = 0;
		while (i < arr.length && currMin <= correctMin) {

			while (i < arr.length && currMin + arr[i] <= correctMin) {
				currMin += arr[i];

				moves++;
			}

			if (currMin == correctMin)
				return moves;
			i++;
		}

		return 0;
	}

}
