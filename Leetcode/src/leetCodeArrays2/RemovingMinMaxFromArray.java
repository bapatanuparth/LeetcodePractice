package leetCodeArrays2;

public class RemovingMinMaxFromArray {

	 public int minimumDeletions(int[] nums) {
	        int max=0;
	        int maxNum=Integer.MIN_VALUE;
	        int min=0;
	        int minNum=Integer.MAX_VALUE;
	        
	        for(int i=0;i<nums.length;i++){ //find indexes of min and max numbers
	            if(nums[i]>maxNum){
	                max=i;
	                maxNum=nums[i];
	            }
	                
	            if(nums[i]<minNum)
	            {min=i;
	                minNum=nums[i];}
	        }
	        
	        int res=0;
	        int n=nums.length-1;
	        int sc1, sc2, sc3; //three scenarios
	        
	        sc1= (max>min)?max+1:min+1; //both lie on the initial side of the array
	        sc2=((n-max)>(n-min))?(n-max)+1:(n-min)+1; //both lie towards the end of array
	        sc3= Math.min(max+(n-min)+2, min+(n-max)+2); //one near start and other near end

	       res=(sc1<sc2)?Math.min(sc1,sc3):Math.min(sc2,sc3); 
	       
	        return res;
	    }
}
