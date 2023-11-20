package leetcodeGreedy;

import java.util.PriorityQueue;
import java.util.Queue;

//You are playing a video game where you are defending your city from a group of n monsters. You are given a 0-indexed integer array dist of size n, where dist[i] is the initial distance in kilometers of the ith monster from the city.
//
//The monsters walk toward the city at a constant speed. The speed of each monster is given to you in an integer array speed of size n, where speed[i] is the speed of the ith monster in kilometers per minute.
//
//You have a weapon that, once fully charged, can eliminate a single monster. However, the weapon takes one minute to charge. The weapon is fully charged at the very start.
//
//You lose when any monster reaches your city. If a monster reaches the city at the exact moment the weapon is fully charged, it counts as a loss, and the game ends before you can use your weapon.
//
//Return the maximum number of monsters that you can eliminate before you lose, or n if you can eliminate all the monsters before they reach the city.

public class EliminateMaxNumberOfMonsters {

	public int eliminateMaximum(int[] dist, int[] speed) {
		Queue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < dist.length; i++) {
			int val = (int) Math.ceil((double) dist[i] / speed[i]);
			q.add(val);
		}

		int t = 0, count = 0;
		for (; t <= 100000 && !q.isEmpty(); t++) {
			if (q.peek() <= t && t != 0)
				return count;
			q.poll();
			count++;
		}

		return count;
	}

}
