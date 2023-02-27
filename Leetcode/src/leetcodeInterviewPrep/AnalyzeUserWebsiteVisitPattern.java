package leetcodeInterviewPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyzeUserWebsiteVisitPattern {

	class Pair {
		int time;
		String web;

		public Pair() {
		}

		public Pair(int t, String w) {
			time = t;
			web = w;
		}

	}

	// we have a [usrname, timestamp, website visited on that timestamp]
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

		// we will map a user with a [pair of timestamp and corresponding website
		// visited at that time]
		// this will give us a list of pairs telling when a user visited which website
		Map<String, List<Pair>> map = new HashMap<>();

		for (int i = 0; i < username.length; i++) {

			map.putIfAbsent(username[i], new ArrayList<Pair>());
			map.get(username[i]).add(new Pair(timestamp[i], website[i]));
		}

		String res = "";

		Map<String, Integer> count = new HashMap<>(); // to count all the string patterns possible and their counter

		for (String user : map.keySet()) {

			List<Pair> userwebsites = map.get(user); // for each user, get list of all websites he visited
			Collections.sort(userwebsites, (a, b) -> a.time - b.time); // sort the list based on timestamp as it matters
																		// which was visited first

			Set<String> set = new HashSet<>(); // to avoid adding duplicate pattern for same user

			for (int i = 0; i < userwebsites.size(); i++) {

				for (int j = i + 1; j < userwebsites.size(); j++) {

					for (int k = j + 1; k < userwebsites.size(); k++) { // for all the websites in set of 3, add this
																		// pattern in the map

						String out = userwebsites.get(i).web + " " + userwebsites.get(j).web + " "
								+ userwebsites.get(k).web;
						if (!set.contains(out)) { // if a distinct pattern was found for that user, add it in map and
													// increment counter
							count.put(out, count.getOrDefault(out, 0) + 1);
							set.add(out);
						}

						if (res == "" || count.get(res) < count.get(out)
								|| (count.get(res) == count.get(out)) && res.compareTo(out) > 0) // if count current>
																									// count result or
																									// if counters are
																									// same, then take
																									// lexicographically
																									// smaller as result
							res = out;

					}
				}
			}

		}

		String arr[] = res.split(" ");
		List<String> output = new ArrayList<>();

		for (String s : arr) {
			output.add(s);
		}

		return output;

	}
}
