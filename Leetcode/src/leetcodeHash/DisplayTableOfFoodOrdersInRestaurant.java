package leetcodeHash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

//Given the array orders, which represents the orders that customers have done in a restaurant. More specifically orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the name of the customer, tableNumberi is the table customer sit at, and foodItemi is the item customer orders.
//
//Return the restaurant's “display table”. The “display table” is a table whose row entries denote how many of each food item each table ordered. The first column is the table number and the remaining columns correspond to each food item in alphabetical order. The first row should be a header whose first column is “Table”, followed by the names of the food items. Note that the customer names are not part of the table. Additionally, the rows should be sorted in numerically increasing order.

public class DisplayTableOfFoodOrdersInRestaurant {

	public List<List<String>> displayTable(List<List<String>> orders) {
		TreeSet<Integer> tables = new TreeSet<>();
		TreeSet<String> food = new TreeSet<>();

		Map<Integer, Map<String, Integer>> table = new HashMap<>();

		for (List<String> order : orders) {
			int tableNumber = Integer.parseInt(order.get(1));
			if (!table.containsKey(tableNumber)) {
				Map<String, Integer> nmap = new HashMap<>();
				table.put(tableNumber, nmap);
			}
			Map<String, Integer> foodlog = table.get(tableNumber);
			foodlog.put(order.get(2), foodlog.getOrDefault(order.get(2), 0) + 1);
			tables.add(tableNumber);
			food.add(order.get(2));
		}

		// System.out.println(table);

		List<List<String>> ans = new ArrayList<>();
		List<String> header = new ArrayList<>();
		header.add("Table");
		for (String foodItem : food) {
			header.add(foodItem);
		}
		ans.add(header);
		for (int tableNumber : tables) {
			List<String> row = new ArrayList<>();
			row.add(String.valueOf(tableNumber));
			for (int i = 1; i < header.size(); i++) {
				String currFood = header.get(i);
				if (!table.get(tableNumber).containsKey(currFood)) {
					row.add("0");
					continue;
				}
				row.add(table.get(tableNumber).get(currFood) + "");
			}
			ans.add(row);
		}

		return ans;
	}
}
