package leetCodeArrays2;
import java.util.*;

//There is a long table with a line of plates and candles arranged on top of it. You are given a 0-indexed string s consisting of characters '*' and '|' only, where a '*' represents a plate and a '|' represents a candle.
//
//You are also given a 0-indexed 2D integer array queries where queries[i] = [lefti, righti] denotes the substring s[lefti...righti] (inclusive). For each query, you need to find the number of plates between candles that are in the substring. A plate is considered between candles if there is at least one candle to its left and at least one candle to its right in the substring.
//
//For example, s = "||**||**|*", and a query [3, 8] denotes the substring "*||**|". The number of plates between candles in this substring is 2, as each of the two plates has at least one candle in the substring to its left and right.
//Return an integer array answer where answer[i] is the answer to the ith query.

//Input: s = "**|**|***|", queries = [[2,5],[5,9]]
//Output: [2,3]
public class PlatesBetweenCandles {

	
	class Solution {
		
		
		//working solution
	    public int[] platesBetweenCandles(String s, int[][] queries) {
	        
	        int [] res= new int[queries.length];
	        int k=0;
	        List<Integer> list= new ArrayList<>();
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='|'){
	                list.add(i);
	            }
	        }
	        
	        for(int [] arr:queries){
	            int start=arr[0];
	            int end= arr[1];
	            
	            if(end-start>1){
	                
	            int candle1= Integer.MAX_VALUE;
	            int candle2=Integer.MAX_VALUE;
	                
	            candle1= binarySearch(list,start,0);
	            candle2= binarySearch(list,end,1);
	            
	         //   System.out.println(candle1);
	       // System.out.println(candle2);
	            if(candle1==Integer.MAX_VALUE || candle2==Integer.MAX_VALUE){
		                res[k]=0;k++;
		        }
	            if(candle1>=candle2)
	            {
	                res[k]=0;k++;continue;

	            }
	                    
	             else{
		         
	                //need to figure out this logic. if we dont use this formula, gives TLE 
	                 int count= list.get(candle2)-list.get(candle1)-(candle2-candle1-1)-1;
	                     res[k]=count;k++;
		            }
	            
	            }
	            else {
	                res[k]=0;k++;
	            }
	            
	            
	        }
	        
	        return res;
	    }
	    
	    int binarySearch(List<Integer> list,int val, int b){
	        int left=0, right=list.size()-1;
	        int mid=(left+right)/2;
	        
	       // System.out.println(val);
	        while(left<=right){
	            mid=(left+right)/2;
	            if(list.get(mid)==val)
	                return mid;
	            else if(list.get(mid)>val)
	                right=mid-1;
	            else if(list.get(mid)<val)
	                left= mid+1;
	        }
	        if(b==0)
	            return left;
	        else return right;
	        
	    }
	}
	
	
	//code works but gives TLE
	//find out the leftmost and rightmost candle then count * between them
	  public int[] platesBetweenCandles(String s, int[][] queries) {
	        
	        int [] res= new int[queries.length];
	        int k=0;
	        for(int [] arr:queries){
	            int start=arr[0];
	            int end= arr[1];
	            
	            int candle1=Integer.MAX_VALUE;
	            int candle2= Integer.MAX_VALUE;
	            //find leftmost candle and rightmost candle
	            while(start<=end){
	                if(s.charAt(start)=='|'){
	                    if(candle1==Integer.MAX_VALUE)
	                    {
	                        candle1=start;
	                    }
	                    else
	                        candle2=start;
	                }
	                start++;
	            }
	            //check if both different candles present
	            if(candle1==Integer.MAX_VALUE || candle2==Integer.MAX_VALUE){
	                res[k]=0;k++;
	            }
	            else{
	                int sum=0;
	                //if 2 different candles present, add the number of * in between them
	                while(candle1<=candle2){
	                    if(s.charAt(candle1)=='*')
	                        sum+=1;
	                    candle1++;
	                }
	                res[k]=sum;k++;
	            }
	                
	            
	        }
	        
	        return res;
	    }
}
