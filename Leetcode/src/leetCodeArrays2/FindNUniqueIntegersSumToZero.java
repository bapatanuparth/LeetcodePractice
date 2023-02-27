package leetCodeArrays2;

//Given an integer n, return any array containing n unique integers such that they add up to 0.
public class FindNUniqueIntegersSumToZero {

	public int[] sumZero(int n) {

		int arr[] = new int[n];

		if (n % 2 == 1) {
			arr[0] = 0;
			n--;
			int i = 1, k = 1;
			while (n > 0) {
				arr[k++] = i;
				n--;
				arr[k++] = -i;
				n--;
				i++;
			}

		}

		else if (n % 2 == 0) {
			int i = 1, k = 0;
			while (n > 0) {
				arr[k++] = i;
				n--;
				arr[k++] = -i;
				n--;
				i++;
			}
		}

		return arr;
	}
}
