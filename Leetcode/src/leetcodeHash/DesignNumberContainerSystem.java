package leetcodeHash;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

//Design a number container system that can do the following:
//
//Insert or Replace a number at the given index in the system.
//Return the smallest index for the given number in the system.
//Implement the NumberContainers class:
//
//NumberContainers() Initializes the number container system.
//void change(int index, int number) Fills the container at index with the number. If there is already a number at that index, replace it.
//int find(int number) Returns the smallest index for the given number, or -1 if there is no index that is filled by number in the system.

public class DesignNumberContainerSystem {

	// use treeset, numbers will be in order and support fast remove
	Map<Integer, Integer> index;
	Map<Integer, TreeSet<Integer>> map;

	public DesignNumberContainerSystem() {
		index = new HashMap<>();
		map = new HashMap<>();
	}

	public void change(int in, int number) {
		if (index.containsKey(in)) {
			int val = index.get(in);
			map.get(val).remove(in);
			if (map.get(val).size() == 0)
				map.remove(val);
		}
		index.put(in, number);
		if (map.containsKey(number)) {
			map.get(number).add(in);
		} else {
			TreeSet<Integer> set = new TreeSet<>();
			set.add(in);
			map.put(number, set);
		}

	}

	public int find(int number) {
		if (!map.containsKey(number))
			return -1;
		return map.get(number).first();
	}

}
