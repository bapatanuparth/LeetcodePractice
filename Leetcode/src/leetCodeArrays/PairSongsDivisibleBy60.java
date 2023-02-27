package leetCodeArrays;

//You are given a list of songs where the ith song has a duration of time[i] seconds.
//
//Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.
//
//Input: time = [30,20,150,100,40]
//Output: 3
//Explanation: Three pairs have a total duration divisible by 60:
//(time[0] = 30, time[2] = 150): total duration 180
//(time[1] = 20, time[3] = 100): total duration 120
//(time[1] = 20, time[4] = 40): total duration 60 
public class PairSongsDivisibleBy60 {

	 public int numPairsDivisibleBy60(int[] time) {
	        int []remainder=new int[60];
	        int count=0;
	        for(int i=0;i<time.length;i++){
	            
	            int curr=time[i]%60;
	          
	            if(curr==0){
	                count+=remainder[0];
	            }
	            else{
	                count+=remainder[60-curr];
	            }
	              remainder[curr]+=1;
	        }
	        
	        return count;
	    }
}
