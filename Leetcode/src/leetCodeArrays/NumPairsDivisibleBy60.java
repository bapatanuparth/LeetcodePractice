package leetCodeArrays;

public class NumPairsDivisibleBy60 {

	public int numPairsDivisibleBy60(int[] time) 
    {
        //we know that remainders will lie between 0 to 59
        int[] remainders = new int[60];
        
        int count = 0;
        for (int i = 0; i < time.length; i++) 
        {
            //current remainder
            int curr = time[i] % 60;
            
            //if current remainder is zero, it means, the complement for this time would be a time having remainder zero 
            // for other than zero, complement remainder would be 60 - r; 
            if (curr == 0)
                count += remainders[0];
            else
                count += remainders[60 - curr];
            
            remainders[curr]++;
        }
        return count;
    }
}
