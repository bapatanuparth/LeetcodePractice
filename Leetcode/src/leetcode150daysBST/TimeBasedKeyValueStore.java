package leetcode150daysBST;

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

	Map<String, TreeMap<Integer, String>> map;
	int lowest = Integer.MAX_VALUE;

//	public TimeMap() {
//        map= new HashMap<>();
//    }

	public void set(String key, String value, int timestamp) {
		if (!map.containsKey(key)) {
			TreeMap<Integer, String> tm = new TreeMap<>();
			map.put(key, tm);
		}
		map.get(key).put(timestamp, value);
		if (timestamp < lowest)
			lowest = timestamp;
	}

	public String get(String key, int timestamp) {
		if (!map.containsKey(key))
			return "";
		if (timestamp < lowest)
			return "";
		TreeMap<Integer, String> temp = map.get(key);
		return map.get(key).floorEntry(timestamp).getValue();
	}

}
