package leetcodeHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

//An underground railway system is keeping track of customer travel times between different stations. They are using this data to calculate the average time it takes to travel from one station to another.
//
//Implement the UndergroundSystem class:
//
//void checkIn(int id, string stationName, int t)
//A customer with a card ID equal to id, checks in at the station stationName at time t.
//A customer can only be checked into one place at a time.
//void checkOut(int id, string stationName, int t)
//A customer with a card ID equal to id, checks out from the station stationName at time t.
//double getAverageTime(string startStation, string endStation)
//Returns the average time it takes to travel from startStation to endStation.
//The average time is computed from all the previous traveling times from startStation to endStation that happened directly, meaning a check in at startStation followed by a check out from endStation.
//The time it takes to travel from startStation to endStation may be different from the time it takes to travel from endStation to startStation.
//There will be at least one customer that has traveled from startStation to endStation before getAverageTime is called.
//You may assume all calls to the checkIn and checkOut methods are consistent. If a customer checks in at time t1 then checks out at time t2, then t1 < t2. All events happen in chronological order.

public class DesignUndergroundSystem {

	class UndergroundSystem {

		Map<Integer, Pair<String, Integer>> checkInMap;
		Map<Pair<String, String>, ArrayList<Integer>> checkOutMap;

		public UndergroundSystem() {
			checkInMap = new HashMap<>();
			checkOutMap = new HashMap<>();
		}

		public void checkIn(int id, String stationName, int t) {
			Pair<String, Integer> pair = new Pair<>(stationName, t);
			checkInMap.put(id, pair);
		}

		public void checkOut(int id, String stationName, int t) {
			String start = checkInMap.get(id).getKey();
			Pair<String, String> p = new Pair<>(start, stationName);

			int starttime = checkInMap.get(id).getValue();
			if (checkOutMap.containsKey(p)) {
				checkOutMap.get(p).add(t - starttime);
			} else {
				ArrayList<Integer> ls = new ArrayList<>();
				ls.add(t - starttime);
				checkOutMap.put(p, ls);
			}
		}

		public double getAverageTime(String startStation, String endStation) {
			Pair<String, String> p = new Pair<>(startStation, endStation);
			ArrayList<Integer> times = checkOutMap.get(p);

			double sum = 0;
			for (int i : times) {
				sum += i;
			}
			return sum / times.size();
		}
	}

	/**
	 * Your UndergroundSystem object will be instantiated and called as such:
	 * UndergroundSystem obj = new UndergroundSystem();
	 * obj.checkIn(id,stationName,t); obj.checkOut(id,stationName,t); double param_3
	 * = obj.getAverageTime(startStation,endStation);
	 */

}
