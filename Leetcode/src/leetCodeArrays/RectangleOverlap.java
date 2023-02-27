package leetCodeArrays;

public class RectangleOverlap {

	public boolean IsRectangleOverlap(int[] rec1, int[] rec2) {
		if (rec1[2] <= rec2[0] || // rec2 right
				rec2[2] <= rec1[0] || // rec2 left
				rec1[3] <= rec2[1] || // rec2 Top
				rec2[3] <= rec1[1]) // rec2 bottom
			return false;
		return true;
	}

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

		boolean xOver = (rec1[0] >= rec2[0] && rec1[0] < rec2[2]) || (rec2[0] >= rec1[0] && rec2[0] < rec1[2]);

		boolean yOver = (rec1[1] >= rec2[1] && rec1[1] < rec2[3]) || (rec2[1] >= rec1[1] && rec2[1] < rec1[3]);

		return xOver && yOver;
	}
}
