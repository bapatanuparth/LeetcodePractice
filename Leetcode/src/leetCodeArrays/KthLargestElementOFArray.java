package leetCodeArrays;
import java.util.*;

//Given an integer array nums and an integer k, return the kth largest element in the array.
//
//Note that it is the kth largest element in the sorted order, not the kth distinct element.

//Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4

public class KthLargestElementOFArray {
	 public int findKthLargest(int[] nums, int k) {
	        
		 //sorts queue descending order
	        Queue<Integer> maxHeap= new PriorityQueue<>((a,b)->b-a);
	        
	        for(int i:nums){
	            maxHeap.add(i);
	        }
	        
	        for(int i=1;i<k;i++){
	            maxHeap.poll();
	        }
	        return maxHeap.poll();
	        
	    }
	
}
