package leetCodeArrays2;
import java.util.*;



public class SmallestUnoccupiedChairs {

		//working solution
	   class Pair implements Comparable<Pair> {
	        int seatNo;
	        int leavingTime;
	        
	        Pair(int seatNo, int leavingTime){
	            this.seatNo = seatNo;
	            this.leavingTime = leavingTime;
	        }
	        
	        public int compareTo(Pair o){
	            return this.leavingTime - o.leavingTime;
	        }
	    }
	    
	    public int smallestChairEFF(int[][] times, int targetFriend) {
	        int arrivalTime = times[targetFriend][0];
	        
	        Arrays.sort(times, (a, b) -> a[0] - b[0]);
	        
	        PriorityQueue<Integer> availableSeats = new PriorityQueue<>();
	        for(int i = 0; i < times.length; i++){
	            availableSeats.offer(i);
	        }
	        
	        PriorityQueue<Pair> occupiedSeats = new PriorityQueue<>();
	        
	        for(int i = 0; i < times.length; i++){
	            int[] curr = times[i];
	            while(occupiedSeats.size() > 0 && occupiedSeats.peek().leavingTime <= curr[0]){
	                int seatNo = occupiedSeats.poll().seatNo;
	                availableSeats.offer(seatNo);
	            }
	            if(arrivalTime == curr[0]){
	                return availableSeats.peek();
	            }
	            
	            occupiedSeats.offer(new Pair(availableSeats.poll(), curr[1]));
	        }
	        
	        return 0;
	        
	    }
	
	
	
	
	//my code 53/65 test cases
	 public int smallestChair(int[][] times, int targetFriend) {
	        int arrive= times[targetFriend][0];
	        int depart = times[targetFriend][1];
	        
	        Queue<int[]> q= new PriorityQueue<>((a,b)-> a[0]-b[0]);
	        
	        for(int [] arr:times){
	            q.add(arr);
	        }
	       // System.out.println(q);
	        List<int[]> list= new ArrayList<>();
	        while(!q.isEmpty()){
	            int [] test= q.poll();
	            System.out.print(test[0]+ " "+ test[1]);
	            System.out.println();
	            list.add(test);
	        }
	        
	        boolean flag;
	        List<Integer> v = new ArrayList<>();
	        for(int i=0;i<list.size();i++){
	            int [] temp= list.get(i);
	            
	            flag=true;
	            for(int j=0;j<v.size();j++){
	                if(v.get(j)<=temp[0]){
	                    flag=false;
	                    v.set(j,temp[1]); 
	                    if(temp[0]==arrive)return j;  
	                }   
	            }
	            if(flag)v.add(temp[1]);
	            if(temp[0]==arrive)
	                return v.size()-1;
	        }
	        
	        return -1;
	        
	    }
}
