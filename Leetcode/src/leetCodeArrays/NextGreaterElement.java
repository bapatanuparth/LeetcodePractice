package leetCodeArrays;
import java.util.*;

//The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
//
//You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
//
//For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
//
//Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]

public class NextGreaterElement {

	//my solution - 97% 
	 public int[] nextGreaterElement(int[] nums1, int[] nums2) {
	        List<Integer> list= new ArrayList<>();
	        Map<Integer, Integer> map = new HashMap<>();
	        boolean flag;
	        
	        for(int i=0;i<nums2.length;i++){
	            map.put(nums2[i],i);
	        }
	        
	        for(int i=0;i<nums1.length;i++){
	            int temp= nums1[i];
	            flag=false;
	            for(int j=map.get(nums1[i]);j<nums2.length;j++){
	                if(nums2[j]>temp){
	                    list.add(nums2[j]);
	                    flag=true;
	                    break;
	                }    
	            }
	            if(!flag)list.add(-1);
	        }
	        
	        int [] res = new int[nums1.length];
	        for(int i=0;i<nums1.length;i++){
	            res[i]= list.get(i);
	        }
	        return res;
	    }
}
