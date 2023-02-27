package leetcodeStrings;
import java.util.*;

//Given an array of strings words and an integer k, return the k most frequent strings.
//
//Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

//Input: words = ["i","love","leetcode","i","love","coding"], k = 2
//Output: ["i","love"]
public class TopKWords {

	public List<String> topKFrequent(String[] words, int k) {
		//map to store frequencies of eachword
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            int count = wordCount.containsKey(words[i]) ? wordCount.get(words[i]) : 0;
            wordCount.put(words[i], count + 1);
        }
        //priority queue with lambda function. 
        //if the elements have same frequency, compare them lexicographically and add lexicographically.
        //otherwise add is ascending order of frequency
        Queue<String> pq = new PriorityQueue<String>((x, y) -> {
            if (wordCount.get(x) == wordCount.get(y)) {
                return y.compareTo(x);
            }
            return wordCount.get(x) - wordCount.get(y);
        });
        //fill priority queue only upto k elements to save space
        for (String word : wordCount.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        String[] res = new String[k];
        for (int i=k-1; i>=0; i--) {
            res[i] = pq.poll();
        }
        return Arrays.asList(res);
    }
}
