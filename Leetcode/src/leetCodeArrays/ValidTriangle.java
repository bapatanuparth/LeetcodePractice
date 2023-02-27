package leetCodeArrays;
import java.util.*;

public class ValidTriangle {
	
	//efficient approach to do the same thing that did using sort
	 public int triangleNumberEff(int[] nums) {
	        Arrays.sort(nums); 
	        int ans = 0;
	        for(int i = nums.length-1; i>1; i--) {
	            int lo = 0;
	            int hi = i-1;
	            while(lo<hi) {
	                if(nums[lo] + nums[hi]<=nums[i]) lo++;
	                else {
	                    ans += hi - lo;
	                    hi--;
	                }
	                        
	            }
	        }
	        return ans;    
	    }
	
	//approach by sorting array first
	  public int triangleNumber2(int[] arr) {
	        int n=arr.length;
	        int output=0;
	        Arrays.sort(arr);
	        if(n<3)return 0;
	        for(int i=0;i<n-2;i++){
	            
	            for(int j=i+1;j<n-1;j++){
	                
	                for(int k=j+1;k<n;k++){
	                if(arr[i]+arr[j]>arr[k])
	                    output+=1;
	                else break;
	                    
	                }
	            }
	        }
	        return output;
	    }

	//code is right but gives TLE
	 public int triangleNumber(int[] arr) {
	        int n=arr.length;
	        int output=0;
	        if(n<3)return 0;
	        for(int i=0;i<n-2;i++){
	            
	            for(int j=i+1;j<n-1;j++){
	                
	            	int sum=arr[i]+arr[j];
	                int diff=Math.abs(arr[i]-arr[j]);
	                for(int k=j+1;k<n;k++){
	                if(arr[k]>diff && arr[k]<sum)
	                    output+=1;
	                    
	                }
	            }
	        }
	        return output;
	    }
}
