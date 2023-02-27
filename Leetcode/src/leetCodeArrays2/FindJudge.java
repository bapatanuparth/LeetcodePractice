package leetCodeArrays2;
import java.util.*;
//In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
//
//If the town judge exists, then:
//
//The town judge trusts nobody.
//Everybody (except for the town judge) trusts the town judge.
//There is exactly one person that satisfies properties 1 and 2.
//You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.
//
//Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

//Input: n = 3, trust = [[1,3],[2,3]]
//Output: 3
//Input: n = 3, trust = [[1,3],[2,3],[3,1]]
//Output: -1
public class FindJudge {
	
	//clean code using graph concept
	 public int findJudgeEff(int n, int[][] trust) {
	        
	       //check for edge cases
	        if(trust.length < n-1) return -1;
	        int[] indegrees = new int[n+1];
	        int[] outdegrees = new int[n+1];
	        
	        for(int[] conn : trust){
	            outdegrees[conn[0]]++;
	            indegrees[conn[1]]++;
	        }
	        for(int i=1; i<= n ; i++){
	            if(indegrees[i] == n-1 && outdegrees[i] == 0)return i;
	        }
	        return -1;
	    }
	
	
	//not a clean code	
	 public int findJudge(int n, int[][] trust) {
	     if(n==1)return 1;
	        
	        Set<Integer> set1= new HashSet<>();
	        Set<Integer> set2= new HashSet<>();
	        for(int [] arr:trust){
	            if(set2.contains(arr[0]))set2.remove(arr[0]);
	            set1.add(arr[0]);
	            if(!set1.contains(arr[1]))
	                set2.add(arr[1]);
	        }
	        if(set2.isEmpty())return -1;
	        if(set2.size()>1)return -1;
	        List<Integer> alist= new ArrayList<>(set2);
	        int count=0;
	        for(int [] arr:trust){
	            if(arr[1]==alist.get(0))count++;
	        }
	        if(count==n-1)return alist.get(0);
	        return -1;
	            
	    }
}
