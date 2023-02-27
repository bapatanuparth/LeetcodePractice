package leetCodeArrays2;

public class MinDeletToMakeArrayBeautiful {

	//my solution
	 public int minDeletion(int[] nums) {
	        int offset=0; //to keep track of how many elements we have ignored by now 
	        
	        int res=0; //result
	        for(int i=0;i<nums.length;){
	            int j=i;
	            while(j<nums.length-1 && nums[j+1]==nums[j] && (j-offset)%2==0) //to handle cases like [1,1,1,1,2,2,2]
	            {
	                offset++;
	                res++;
	                j++; //if consecutive elements like 1,1,1, appear, we need to make sure that we ignore them all and directly start from next valid element
	            }
	            	//if the loop runs, means there can be one or  multiple consecutive elements, so effectively we directly consider next even element in output array
	            	//for example [1,1,1,1,2,2] we ignore 3 one's after first, the array to consider now becomes [1,2,2] and offset == 3 after deleting 3 ones in the middle
	            	//we start next i from next even element in array after this modification, hence i == j+2
	                i=j+2;
	        }
	        
	        if((nums.length-offset)%2!=0)
	            res++;
	        return res;
	    }
}
