package leetCodeArrays;
import java.util.*;

//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
public class TopKFrequentElements {

	//same approach priority queue
	//without using extra array space to add in priority queue
	 public int[] topKFrequentEff(int[] nums, int k) {
	        // O(1) time
	        if (k == nums.length) {
	            return nums;
	        }
	        
	        // 1. build hash map : character and how often it appears
	        // O(N) time
	        Map<Integer, Integer> count = new HashMap();
	        for (int n: nums) {
	          count.put(n, count.getOrDefault(n, 0) + 1);
	        }

	        // init heap 'the less frequent element first'
	        Queue<Integer> heap = new PriorityQueue<>(
	            (n1, n2) -> count.get(n1) - count.get(n2));

	        // 2. keep k top frequent elements in the heap
	        // O(N log k) < O(N log N) time
	        for (int n: count.keySet()) {
	          heap.add(n);
	          if (heap.size() > k) heap.poll();    
	        }

	        // 3. build an output array
	        // O(k log k) time
	        int[] top = new int[k];
	        for(int i = k - 1; i >= 0; --i) {
	            top[i] = heap.poll();
	        }
	        return top;
	    }
	
	
	//using priority queue
	//naive approach used extra array to save in priority queue
	  public int[] topKFrequent(int[] nums, int k) {
	      HashMap<Integer, Integer> map= new HashMap<>();
	        
	        for(int i:nums){
	            map.compute(i,(key,v)->(v==null)?1:v+1);
	        }
	        
	        Queue<int[]> maxHeap= new PriorityQueue<>((a,b)-> b[1]-a[1]);
	        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
	            int [] temp= new int[2];
	            temp[0]=entry.getKey();
	            temp[1]=entry.getValue();
	            
	            maxHeap.add(temp);
	        }
	        
	        int [] output= new int[k];
	        for(int i=0;i<k;i++){
	            output[i]=maxHeap.poll()[0];
	        }
	        return output;
	    }
}
