package leetCodeArrays2;

//You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
//
//if the ith character is 'Y', it means that customers come at the ith hour
//whereas 'N' indicates that no customers come at the ith hour.
//If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
//
//For every hour when the shop is open and no customers come, the penalty increases by 1.
//For every hour when the shop is closed and customers come, the penalty increases by 1.
//Return the earliest hour at which the shop must be closed to incur a minimum penalty.
//
//Note that if a shop closes at the jth hour, it means the shop is closed at the hour j.

public class MinimumPenaltyForShop {

	public int bestClosingTime(String cust) {
		int closed[] = new int[cust.length() + 1];
		int opened[] = new int[cust.length() + 1];

		for (int i = 0; i < cust.length(); i++) {
			if (cust.charAt(i) == 'Y') {
				closed[i]++;
			} else {
				opened[i]++;
			}
		}

		int n = cust.length();

		for (int i = 0; i < closed.length; i++) {
			opened[i] = i > 0 ? opened[i - 1] + opened[i] : opened[i];
		}
		for (int i = closed.length - 1; i >= 0; i--) {
			closed[i] = i == closed.length - 1 ? closed[i] : closed[i + 1] + closed[i];
		}

		int min = cust.length() + 2;
		int minIndex = 0;
		for (int i = 0; i < closed.length; i++) {
			int pen = i == 0 ? closed[i] : opened[i - 1] + closed[i];
			if (pen < min) {
				min = pen;
				minIndex = i;
			}
		}

		return minIndex;
	}

}
