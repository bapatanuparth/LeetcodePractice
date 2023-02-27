package leetcodeIntervals;

import java.util.Arrays;

//You are given a 0-indexed 2D integer array peaks where peaks[i] = [xi, yi] states that mountain i has a peak at coordinates (xi, yi). A mountain can be described as a right-angled isosceles triangle, with its base along the x-axis and a right angle at its peak. More formally, the gradients of ascending and descending the mountain are 1 and -1 respectively.
//
//A mountain is considered visible if its peak does not lie within another mountain (including the border of other mountains).
//
//Return the number of visible mountains.
public class FindingNumberOfVisibleMountains {

//	Since we know the slopes of all mountains must be 1 going uphill and -1 going downhill, we can convert each peak to a start and end.
	// We then sort all mountains by earliest start(breaking ties by earliest end).
	// Now we go through our mountains in sorted order.
	// We initially assume the mountain we're considering is visible and increment
	// size by 1. If this is the last mountain, we're done.
	// If not, we check if the next mountain has the same start as our current
	// mountain.
	// If it does, our current mountain cannot be visible since the next mountain is
	// guaranteed to finish at least as late as our current mountain does and
	// we decrement size by 1. Now, we want to skip all mountains we know cannot be
	// visible, namely those that end at or before our current end.
	// After we have skipped all possible mountains, we continue to our next
	// iteration on the next unconsidered mountain).
	// Finally, after considering all mountains we return our size.

	public int visibleMountains(int[][] peaks) {

		for (int i = 0; i < peaks.length; i++) {
			int temp = peaks[i][0];
			peaks[i][0] -= peaks[i][1];
			peaks[i][1] += temp;
		}
		Arrays.sort(peaks, (a, b) -> {
			if (a[0] - b[0] != 0) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		int i = 0;
		int size = 0;

		while (i < peaks.length) {
			size++;
			if (i + 1 == peaks.length)
				return size;
			if (peaks[i][0] == peaks[i + 1][0])
				size--;
			int currEnd = peaks[i][1];
			while (i + 1 != peaks.length && currEnd >= peaks[i + 1][1]) {
				i++;
			}
			i++;
		}

		return size;
	}
}
