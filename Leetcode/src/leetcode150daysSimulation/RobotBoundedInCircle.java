package leetcode150daysSimulation;

//On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:
//
//The north direction is the positive direction of the y-axis.
//The south direction is the negative direction of the y-axis.
//The east direction is the positive direction of the x-axis.
//The west direction is the negative direction of the x-axis.
//The robot can receive one of three instructions:
//
//"G": go straight 1 unit.
//"L": turn 90 degrees to the left (i.e., anti-clockwise direction).
//"R": turn 90 degrees to the right (i.e., clockwise direction).
//The robot performs the instructions given in order, and repeats them forever.
//
//Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

public class RobotBoundedInCircle {

//	(x,y) is the location of robot.
//	d[i] is the direction he is facing.
//	i = (i + 1) % 4 will turn right
//	i = (i + 3) % 4 will turn left
//	Check the final status after instructions.

//	if robot return to the origin, he is obvious in an circle.
//			if robot finishes with face not towards north,
//			it will get back to the initial status in another one or three sequences.

	public boolean isRobotBounded(String ins) {
		int x = 0, y = 0, i = 0, d[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		for (int j = 0; j < ins.length(); ++j)
			if (ins.charAt(j) == 'R')
				i = (i + 1) % 4;
			else if (ins.charAt(j) == 'L')
				i = (i + 3) % 4;
			else {
				x += d[i][0];
				y += d[i][1];
			}
		return x == 0 && y == 0 || i > 0;
	}
}
