package leetCodeArrays2;

//There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store. You are given an integer array customers of length n where customers[i] is the number of the customer that enters the store at the start of the ith minute and all those customers leave after the end of that minute.
//
//On some minutes, the bookstore owner is grumpy. You are given a binary array grumpy where grumpy[i] is 1 if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.
//
//When the bookstore owner is grumpy, the customers of that minute are not satisfied, otherwise, they are satisfied.
//
//The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, but can only use it once.
//
//Return the maximum number of customers that can be satisfied throughout the day.

//Input: customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
//Output: 16
public class GrumpyBookstoreOwner {
	
	//sliding window
//	Say the store owner uses their power in minute 1 to X and we have some answer A. If they instead use their power from minute 2 to X+1, we only have to use data from minutes 1, 2, X and X+1 to update our answer A.
	 public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
	        int max=0;
	        int left=0,right=0;
	        int sum=0;
	        
	        //calculate the initial sum without using the power for any minutes
	        for(int i=0;i<customers.length;i++){
	            if(grumpy[i]==0){
	                sum+=customers[i];
	            }
	        }
	        
	        for(right=0;right<minutes;right++){ //calculate the sum for the first window of size == minutes for which power can be used
	            if(grumpy[right]==1)
	                sum+=customers[right];
	        }
	        max=sum;
	        left=1; right=minutes;
	        
	        //as we have already accounted for the time when grumpy == 0 in first loop sum, we dont need to check for that
	        //we maintain a sliding window of sum of all consecutive elements of that window of size == minutes
	        while(right<customers.length){ //perform sliding window on whole array
	            if(grumpy[right]==1)	//if next element is 1, means bookstore is grumpy, add it to the sum
	                sum+=customers[right];
	            if(grumpy[left-1]==1)	//check whether the beginning element was 1, if yes, it means we need to subtract this value to make sure
	            	//that window is of size == minutes with next subarray of consecutive elements
	                sum-=customers[left-1];
	            
	            max=Math.max(sum,max); // take maximum sum
	            right++;
	            left++;
	        }
	        
	        return max;
	        
	    }
}
