package leetcodeStrings;
import java.util.*;
//Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
//
//Return the sorted string. If there are multiple answers, return any of them.

//Input: s = "tree"
//Output: "eert"

public class SortWordsOnCharacterFrequency {

	
	 public String frequencySort(String s) {
	        
	        Map<Character, Integer> map= new HashMap<>();
	        //insert in priority queue in descending order based on frequency value
	        Queue<Character> heap = new PriorityQueue<>((a,b)->{
	            return map.get(b)-map.get(a);
	        });
	        
	        //fill map to get frequencies
	        for(char c: s.toCharArray()){
	            map.put(c, map.getOrDefault(c,0)+1);
	        }
	        //put each character in heap
	        System.out.println(map);
	        for(char c: map.keySet()){
	            heap.add(c);
	        }
	        
	        StringBuilder sb = new StringBuilder();
	        
	        while(!heap.isEmpty()){
	            char c = heap.poll();
	            //write each character separately to match frequency count
	            for(int i=0;i<map.get(c);i++)
	                sb.append(c);
	        }
	        return sb.toString();

	    }
}
