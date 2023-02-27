package leetcodeGreedy;

//Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
//
//Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
//
//Return the minimum time Bob needs to make the rope colorful.
public class MinTimeToMakeRopeColorful {

	public int minCost(String colors, int[] neededTime) {
		// totalTime: total time needed to make rope colorful;
		// currMaxTime: maximum time of a balloon needed.
		int totalTime = 0, currMaxTime = 0;

		// For each balloon in the array:
		for (int i = 0; i < colors.length(); ++i) {
			// If this balloon is the first balloon of a new group
			// set the currMaxTime as 0.
			if (i > 0 && colors.charAt(i) != colors.charAt(i - 1)) {
				currMaxTime = 0;
			}

			// Increment totalTime by the smaller one.
			// Update currMaxTime as the larger one.
			totalTime += Math.min(currMaxTime, neededTime[i]);
			currMaxTime = Math.max(currMaxTime, neededTime[i]);
		}

		// Return totalTime as the minimum removal time.
		return totalTime;
	}
}
