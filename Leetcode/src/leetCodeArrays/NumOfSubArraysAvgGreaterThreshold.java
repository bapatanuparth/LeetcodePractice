package leetCodeArrays;

//Given an array of integers arr and two integers k and threshold, return the number of sub-arrays of size k and average greater than or equal to threshold.

//Input: arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//Output: 3	 

public class NumOfSubArraysAvgGreaterThreshold {

	//sliding window
	 public int numOfSubarrays(int[] arr, int k, int threshold) {
	        if(arr.length<k)return 0;
	        int count=0;
	        int left=0, right=0, temp=1;
	        int sum=arr[left];
	        //calculate first window sum
	        while(temp<k){
	            right++;
	            sum=sum+arr[right];
	            temp++;
	        }
	        if(sum/k>=threshold)count++;
	        //calculate each window
	        while(right<arr.length-1){
	            sum=sum-arr[left++];
	            right++;
	            sum=sum+arr[right];
	            if(sum/k>=threshold)count++;
	        }
	        return count;
	    }
}
