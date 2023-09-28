package leetcode150daysHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//Implement the RandomizedSet class:
//
//RandomizedSet() Initializes the RandomizedSet object.
//bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
//bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
//int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
//You must implement the functions of the class such that each function works in average O(1) time complexity.

public class InsertDeleteGetRandom {

	class RandomizedSet {

		ArrayList<Integer> list;
		Map<Integer, Integer> map;

		public RandomizedSet() {
			map = new HashMap<>();
			list = new ArrayList<>();
		}

		public boolean insert(int val) {
			if (map.containsKey(val))
				return false;

			map.put(val, list.size());
			list.add(val);
			return true;
		}

		public boolean remove(int val) {
			if (!map.containsKey(val))
				return false;

			int lastIndex = list.size() - 1;
			int lastElement = list.get(lastIndex);

			int indexToRemove = map.get(val);

			list.set(indexToRemove, lastElement);

			list.remove(lastIndex);

			map.replace(lastElement, indexToRemove);
			map.remove(val);
			return true;

		}

		public int getRandom() {
			int random = new Random().nextInt(list.size());
			return list.get(random);

		}
	}

	/**
	 * Your RandomizedSet object will be instantiated and called as such:
	 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
	 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
	 */

}
