package leetcodeHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumDataStructure {

	List<Integer> ls;
	Map<Integer, Integer> map;

	public TwoSumDataStructure() {
		ls = new ArrayList<>();
		map = new HashMap<>();
	}

	public void add(int number) {
		if (map.containsKey(number)) {
			map.put(number, map.get(number) + 1);
		} else {
			ls.add(number);
			map.put(number, 1);
		}
	}

	public boolean find(int value) {

		for (int num1 : ls) {
			int num2 = value - num1;

			if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2)))
				return true;

		}
		return false;
	}
}
