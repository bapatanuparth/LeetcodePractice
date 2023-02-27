package leetcodeDynamicProgramming;

public class PaintHouse {

	public int minCost(int[][] costs) {
		// mark the current cost of painting house red, green or blue
		int prevred = costs[0][0];
		int prevgreen = costs[0][1];
		int prevblue = costs[0][2];

		for (int i = 1; i < costs.length; i++) {
			// for each next house the cost to paint will be, the cost for painting that
			// house + min(cost of painting remaining houses so that color doesnt repeat on
			// consecutive houses)
			// for example, calculating cost to paint new house as red, we will consider
			// cost required till now to paint prev house as either greeen or blue. this
			// ensures that we dont re[eat colors
			int newred = costs[i][0] + Math.min(prevgreen, prevblue);
			int newgreen = costs[i][1] + Math.min(prevred, prevblue);
			int newblue = costs[i][2] + Math.min(prevred, prevgreen);

			prevred = newred;
			prevgreen = newgreen;
			prevblue = newblue;
		}

		// return minimum total cost possible for either painting last as red, blue or
		// green
		return Math.min(prevred, Math.min(prevgreen, prevblue));
	}
}
