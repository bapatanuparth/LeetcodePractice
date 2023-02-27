package leetcodeHash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
//Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.
//
//Implement the TimeMap class:
//
//TimeMap() Initializes the object of the data structure.
//void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
//String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".

public class TimeBasedKeyValueStore {

	class TimeMap {

		Map<String, TreeMap<Integer, String>> map; // using treemap as we can get floor of the timestamp easily
		// so we can get any timestamp before the current one
		int lowest = Integer.MAX_VALUE;

		public TimeMap() {

			map = new HashMap<>();
		}

		public void set(String key, String value, int timestamp) {

			if (map.containsKey(key)) {
				map.get(key).put(timestamp, value);

			} else {
				TreeMap<Integer, String> temp = new TreeMap<>();
				temp.put(timestamp, value);
				map.put(key, temp);
				if (timestamp < lowest) // keep track of lowest timestamp we can have, so while getting values, we can
										// check whether any entry before this time is present ot not
					lowest = timestamp;
			}
		}

		public String get(String key, int timestamp) {

			if (map.containsKey(key)) {
				if (timestamp < lowest)
					return "";
				else
					return map.get(key).floorEntry(timestamp).getValue();
			} else
				return "";
		}
	}

}
