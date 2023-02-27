package leetcodeStack;

import java.util.Arrays;
import java.util.Stack;

//There are n cars going to the same destination along a one-lane road. The destination is target miles away.
//
//You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
//
//A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed. The faster car will slow down to match the slower car's speed. The distance between these two cars is ignored (i.e., they are assumed to have the same position).
//
//A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
//
//If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
//
//Return the number of car fleets that will arrive at the destination.

//Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
//Output: 3
//Explanation:
//The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
//The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
//The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
//Note that no other cars meet these fleets before the destination, so the answer is 3.
class Car {
	int position;
	int speed;

	public Car() {
	}

	public Car(int pos, int speed) {
		this.position = pos;
		this.speed = speed;
	}
}

public class CarFleet {

	// monotonic stack
	public int carFleet(int target, int[] position, int[] speed) {

		// we need to arrange cars in the ascending order of their position, hence make
		// a car class and sort the cars
		Car[] cars = new Car[position.length];

		for (int i = 0; i < position.length; i++) {
			cars[i] = new Car(position[i], speed[i]);
		}

		Arrays.sort(cars, (a, b) -> a.position - b.position);
		Stack<Double> st = new Stack<>();

		// for each car from the end, calculate the time it will require to finish the
		// line
		for (int i = cars.length; i >= 0; i--) {

			double time = (target - cars[i].position) / cars[i].speed; // time for the car to reach end

			// we know that the faster car will form a fleet with slower car, so in
			// monotonic stack,
			// maintain the order such that if the new car's time <= previous cars time to
			// reach, i.e.
			// new car is faster than the previous car that was ahead of it, it will form a
			// fleet with that car
			// so no need to push it in stack, push only if the car behind is slower than
			// the car ahead, because that car will reach destination separately

			if (!st.isEmpty() && time <= st.peek()) {
				continue;
			}

			st.push(time);

		}

		return st.size();
	}

}
