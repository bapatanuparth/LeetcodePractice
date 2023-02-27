package leetCodeArrays;

//Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
//
//Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == 
//arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

public class PartitionArray3EqualParts {

	 public boolean canThreePartsEqualSum(int[] arr) {
	        int sum=0;
	        
	        for(int n:arr)
	        {
	            sum=sum+n;
	        }
	        
	        if(sum%3!=0)
	            return false;
	        
	        int each= sum/3;
	        int nsum=0;
	        int count=0;
	        
	        for(int n:arr)
	        {
	            nsum=nsum+n;
	            
	            if(nsum==each)
	            {
	                nsum=0;
	                count++;
	            }
	        }
	        
	        if(count>=3)
	            return true;
	        else
	            return false;
	    }
}
