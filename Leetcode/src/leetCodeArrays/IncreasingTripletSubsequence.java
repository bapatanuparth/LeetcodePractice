package leetCodeArrays;

//Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. 
//If no such indices exists, return false.

//Input: nums = [2,1,5,0,4,6]
//Output: true
//
//Input: nums = [1,2,3,4,5]
//Output: true
public class IncreasingTripletSubsequence {

	  public boolean increasingTriplet(int[] arr) {
	        int i=Integer.MAX_VALUE,j=Integer.MAX_VALUE;
	        if(arr.length<3)return false;
	        for(int x=0;x<arr.length;x++){
	            if(arr[x]<=i){
	                i=arr[x];
	            }else if(arr[x]<=j){
	                j=arr[x];
	            }else return true;
	            
	        }
	        return false;
	    }
}
