package leetcodeIntervals;

public class DetermineIfTwoIntervalsHaveConflict {

	public boolean haveConflict(String[] event1, String[] event2) {

		int c1 = event1[0].compareTo(event2[0]);
		int c2 = event1[1].compareTo(event2[0]);
		int c3 = event2[1].compareTo(event1[0]);

		// if starting 1st is less than starting second, check if their ends overlap or
		// else vice versa
		return (c1 <= 0) ? c2 >= 0 : c3 >= 0;

		// return event1[0]<event2[0]? event1[1]>=event2[0]:event2[1]>=event1[0];

	}
}
