package leetCodeArrays2;
import java.util.*;


public class MinOperationsToMakeAlternating {

	 public int minimumOperationsEff(int[] nums) {
	        int n = nums.length;
	        if(n==1) return 0;
	        if(n==2){ 
	            if(nums[0]==nums[1]) return 1;
	            else return 0;
	        }
	        int cnt1[] = new int[100001];
	        int cnt2[] = new int[100001];
	        for(int i=0;i<n;i+=2){
	            cnt1[nums[i]]++;
	        }
	        for(int j=1;j<n;j+=2){
	            cnt2[nums[j]]++;
	        }
	        PriorityQueue<int[]> pq1 = new PriorityQueue(new Comparator<int[]>(){
	            public int compare(int[] a,int[] b){
	                return b[1]-a[1];
	            }
	        });
	        PriorityQueue<int[]> pq2 = new PriorityQueue(new Comparator<int[]>(){
	            public int compare(int[] a,int[] b){
	                return b[1]-a[1];
	            }
	        });
	        for(int i=0;i<100001;i++){
	            if(cnt1[i]>0){
	                pq1.offer(new int[]{i,cnt1[i]});
	            }
	        }
	        for(int i=0;i<100001;i++){
	            if(cnt2[i]>0){
	                pq2.offer(new int[]{i,cnt2[i]});
	            }
	        }
	        int a[] = pq1.poll();
	        int b[] = pq2.poll();
	        if(a[0]!=b[0]){
	            return n-a[1]-b[1];
	        }
	        else{
	            int c[],d[];
	            if(!pq1.isEmpty())
	                c = pq1.poll();
	            else c = new int[2];
	            if(!pq2.isEmpty())
	                d = pq2.poll();
	            else d = new int[2];
	            return Math.min(n-c[1]-b[1],n-a[1]-d[1]);
	        }
	    }
	
	
	
	//my code -- need to revisit
	//code fails for the test case --> [2,3,4,1,4,2,2,2]
	 public int minimumOperations(int[] nums) {
	        if(nums.length==1){
	            return 0;
	        }
	        Map<Integer, Integer> map1= new HashMap<>();
	        for(int i=0;i<nums.length;i+=2){
	            map1.put(nums[i], map1.getOrDefault(nums[i],0)+1);
	        }
	        
	         Map<Integer, Integer> map2= new HashMap<>();
	        for(int i=1;i<nums.length;i+=2){
	            map2.put(nums[i], map2.getOrDefault(nums[i],0)+1);
	        }
	        
	        Queue<Integer> q= new PriorityQueue<>((a,b)-> map1.get(b)-map1.get(a));
	        Queue<Integer> q2= new PriorityQueue<>((a,b)-> map2.get(b)-map2.get(a));
	        for(int x:map1.keySet()){
	            q.add(x);
	        }
	        for(int x:map2.keySet()){
	            q2.add(x);
	        }
	        
	       int num1= q.poll();
	        int num2= !q2.isEmpty()?q2.poll():Integer.MIN_VALUE;
	        if(num1==num2){
	        if(map1.get(num1)>=map2.get(num2)){
	            if(!q2.isEmpty())
	                num2=q2.poll();
	            else
	            {
	                if(!q.isEmpty())
	                    num1=q.poll();
	            }
	            if(num1==num2){
	                num2=Integer.MIN_VALUE;
	                return nums.length/2;
	            }
	            
	        }
	        else{
	            if(!q.isEmpty()){
	                num1=q.poll();
	            }
	        }
	    }
	        
	        int output=0;
	        if(nums.length%2==0){
	            output+=nums.length/2-map1.get(num1);
	            output+=nums.length/2-map2.get(num2);
	            return output;
	        }
	        else
	        {
	            output+= (nums.length/2+1)-map1.get(num1);
	            output+=nums.length/2-map2.get(num2);
	        }
	        return output;
	        
	    }
}
