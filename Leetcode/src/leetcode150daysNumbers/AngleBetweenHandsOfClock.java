package leetcode150daysNumbers;

//Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
//
//Answers within 10-5 of the actual value will be accepted as correct.

public class AngleBetweenHandsOfClock {

	public double angleClock(int hour, int minutes) {
		if (hour == 12)
			hour = 0;
		double minAngle = minutes * 6;
		double hrAngle = 30 * ((double) minutes / 60.0) + 30 * hour;
		double a1 = Math.abs(hrAngle - minAngle);

		double minAngle2 = minutes * 6;
		double hrAngle2 = 30 * (12 - hour) - 30 * ((double) minutes / 60);
		double a2 = hrAngle2 + minAngle2;

		double minAngle3 = (60 - minutes) * 6;
		double hrAngle3 = 30 * ((double) minutes / 60.0) + 30 * hour;
		double a3 = hrAngle3 + minAngle3;

		return Math.min(Math.min(a1, a2), a3);
	}
}
