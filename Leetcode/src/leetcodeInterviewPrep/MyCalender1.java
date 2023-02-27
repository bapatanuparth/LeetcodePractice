package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalender1 {

	// use treemap to maintain start and end in sorted order
	// get the floor of start and ceiling of start.
	// check if the intervals after and before start intersect with start or no
	class MyCalendar2 {

		TreeMap<Integer, Integer> calendar;

		public MyCalendar2() {
			calendar = new TreeMap<>();
		}

		public boolean book(int start, int end) {
			Integer floorKey = calendar.floorKey(start);
			if (floorKey != null && calendar.get(floorKey) > start)
				return false;
			Integer ceilingKey = calendar.ceilingKey(start);
			if (ceilingKey != null && ceilingKey < end)
				return false;

			calendar.put(start, end);
			return true;
		}
	}

	// solution without treemap
	// use binary search to find the point where the new interval should be placed.
	// check for the conditions whether it is overlapping with any existing interval
	class MyCalendar {

		List<int[]> events;

		public MyCalendar() {
			events = new ArrayList<>(1000);
		}

		public boolean book(int start, int end) {
			int y = lower_bound(events, start); // gives the position where it needs to be present.
			// System.out.println(y);
			if (y != events.size() && !(events.get(y)[0] >= end) || y != 0 && !(events.get(y - 1)[1] <= start))
				return false;
			int[] temp = { start, end };
			events.add(y, temp);
			return true;

		}

		int lower_bound(List<int[]> arr, int key) {
			int low = 0, high = arr.size();

			while (low < high) {
				int mid = low + (high - low) / 2;
				if (key <= arr.get(mid)[0]) {
					high = mid;
				} else
					low = mid + 1;
			}
			return low;
		}
	}
}
