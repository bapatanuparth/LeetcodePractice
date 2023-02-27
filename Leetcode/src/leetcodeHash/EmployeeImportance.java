package leetcodeHash;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
//
//You are given an array of employees employees where:
//
//employees[i].id is the ID of the ith employee.
//employees[i].importance is the importance value of the ith employee.
//employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
//Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.

//Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
//Output: 11

class Employee {
	public int id;
	public int importance;
	public List<Integer> subordinates;
}

public class EmployeeImportance {

	Map<Integer, Employee> emap;

	public int getImportance(List<Employee> employees, int queryid) {
		emap = new HashMap<>();
		for (Employee e : employees)
			emap.put(e.id, e);
		return dfs(queryid);
	}

	public int dfs(int eid) {
		Employee employee = emap.get(eid);
		int ans = employee.importance;
		for (Integer subid : employee.subordinates)
			ans += dfs(subid);
		return ans;
	}
}
