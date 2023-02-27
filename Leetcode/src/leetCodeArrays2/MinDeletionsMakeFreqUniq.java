package leetCodeArrays2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinDeletionsMakeFreqUniq {
	
	//efficient approach
	 public int minDeletionsEff(String s) {
	        // Store the frequency of each character
	        int[] frequency = new int[26];
	        for (int i = 0; i < s.length(); i++) {
	            frequency[s.charAt(i) - 'a']++;
	        }
	        
	        Arrays.sort(frequency);
	        
	        int deleteCount = 0;
	        // Maximum frequency the current character can have
	        int maxFreqAllowed = s.length();
	        
	        // Iterate over the frequencies in descending order
	        for (int i = 25; i >= 0 && frequency[i] > 0; i--) {
	            // Delete characters to make the frequency equal the maximum frequency allowed
	            if (frequency[i] > maxFreqAllowed) {
	                deleteCount += frequency[i] - maxFreqAllowed;
	                frequency[i] = maxFreqAllowed;
	            }
	            // Update the maximum allowed frequency
	            maxFreqAllowed = Math.max(0, frequency[i] - 1); //to tackle cases where frequency goes below 0 cases-- abcde
	        }
	        
	        return deleteCount;
	    }     
	
	

	 public int minDeletions(String s) {
	     
	        int [] freq= new int[26];
	        
	        for(char c:s.toCharArray()){
	            freq[c-'a']++;
	        }
	        
	        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
	        for(int a:freq){
	            if(a!=0)
	                q.add(a);
	        }
	        System.out.println(q);
	        
	        int count=0;
	        while(q.size()>1){
	            int temp=q.poll();
	            if(!q.isEmpty() && q.peek()==temp){
	                --temp;
	                if(temp!=0)
	                    q.add(temp);
	                count++;
	            }
	        }
	        
	        return count;
	    }
}
