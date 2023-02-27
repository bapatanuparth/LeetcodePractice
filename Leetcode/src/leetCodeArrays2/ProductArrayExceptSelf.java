package leetCodeArrays2;

//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//You must write an algorithm that runs in O(n) time and without using the division operation.
public class ProductArrayExceptSelf {

	
	//apply the concept of prefix sum
	//calculate prefix products straight and reverse
	//for each element i multiply the values of straight product till i-1 and reverse product till i+1
	
	//solution in O(1) space complexity
	public int[] productExceptSelfEff(int[] nums) {
		// Edge cases
		if(nums == null || nums.length == 0) return new int[0];

		    int[] result = new int[nums.length]; // resulting array should be same as the size of nums array
		    
		    int rp = 1 ; // Running Product (Assume)

		    //For left pass
		    
		    for(int i = 0; i < nums.length ; i++){
		        result[i] = rp;
		        rp = rp * nums[i]; // updating the running product
		        
		    }
		    
		    rp = 1;
		    
		    // for Right pass
		    
		    for( int i = nums.length -1 ; i >= 0 ; i--){
		        result[i] = result[i] * rp; // as we are doing the right pass also in the same array we have to take existing value , that value and multiplyng the new value with the existing value
		        rp = rp * nums[i];
		    }
		    
		    return result;
		}
	
	//solution using 2 extra arrays
	public int[] productExceptSelf(int[] nums) {
	        
	        int pre[]= new int [nums.length];
	        int post[] = new int[nums.length];
	        int n=nums.length;
	        
	        // pre[0]=nums[0];
	        // post[nums.length-1]=nums[nums.length-1];
	        
	        //pre product array
	        for(int i=0;i<pre.length;i++){
	            if(i==0)
	                pre[i]=nums[i];
	            else
	                pre[i]=pre[i-1]*nums[i];
	        }
	        
	        //array of reverse products 
	        for(int i=n-1;i>=0;i--){
	            if(i==(n-1))
	                post[i]=nums[i];
	            else
	                post[i]=post[i+1]*nums[i];
	        }
	        
	        int out[] = new int[n];
	        for(int i=0;i<n;i++){
	            if(i==0)
	                out[i]=post[i+1];
	            else if(i==n-1)
	                out[i]=pre[i-1];
	            else
	                out[i]=pre[i-1]*post[i+1];
	        }
	        
	        return out;
	        
	        
	        
	    }
}
