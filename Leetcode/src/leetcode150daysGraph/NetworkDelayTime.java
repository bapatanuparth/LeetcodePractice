package leetcode150daysGraph;

//You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

//
//We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

import java.util.*;

public class NetworkDelayTime {
	class Solution {
		public int networkDelayTime(int[][] times, int n, int k) {
	        //create an adjacency matrix to fill the edges and weights
	        int [][] adj= new int[n+1][n+1];
	        for(int i=0; i<adj.length; i++)
	            Arrays.fill(adj[i], -1);
	        //create a time array to store the minimum time to reach a point
	        for(int [] time: times){
	            adj[time[0]][time[1]]= time[2];
	        }

	        int [] time= new int[n+1];
	        Arrays.fill(time, Integer.MAX_VALUE);
	        time[k]=0;

	        Queue<Integer> q= new ArrayDeque<>();
	        q.add(k);
	        //start from the src
	        while(!q.isEmpty()){
	            int [] tmpTime= Arrays.copyOf(time, time.length);
	            int size=q.size();
	            while(size>0){
	                
	                int s=q.poll();
	                //for each neighbor, check whether we can reach the neighbor in lesser time
	                for(int d=0; d<=n; d++){
	                    if(adj[s][d]!=-1){
	                        int t= adj[s][d];
	                        //if we can reach there in less time, add it back to the queue
	                        if(time[s] + t < tmpTime[d]){
	                            tmpTime[d] = time[s] + t;
	                            q.add(d);
	                        }
	                    }
	                }
	                size--;
	            }
	            time= tmpTime;
	        }

	        int max=0;
	        for(int i=1; i<time.length; i++{
	            max= Math.max(max, time[i]);
	        }
	        return max==Integer.MAX_VALUE?-1:max;
	    }
	}

}
