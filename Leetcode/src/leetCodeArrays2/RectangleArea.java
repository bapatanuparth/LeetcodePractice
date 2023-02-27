package leetCodeArrays2;

//Given the coordinates of two rectilinear rectangles in a 2D plane, return the total area covered by the two rectangles.
//
//The first rectangle is defined by its bottom-left corner (ax1, ay1) and its top-right corner (ax2, ay2).
//
//The second rectangle is defined by its bottom-left corner (bx1, by1) and its top-right corner (bx2, by2).

//Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
//Output: 45
public class RectangleArea {

	public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

		int areaoverlap = 0;
		if (isOverlap(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2)) {

			int x1 = Math.max(ax1, bx1);
			int x2 = Math.min(ax2, bx2);

			int y1 = Math.max(ay1, by1);
			int y2 = Math.min(ay2, by2);

			int x = Math.abs(x2 - x1);
			int y = Math.abs(y2 - y1);
			areaoverlap = x * y;

		}

		int a1 = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
		int b1 = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
		return a1 + b1 - areaoverlap;
	}

	boolean isOverlap(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		boolean xOver = (ax1 >= bx1 && ax1 < bx2) || (bx1 >= ax1 && bx1 < ax2);
		boolean yOver = (ay1 >= by1 && ay1 < by2) || (by1 >= ay1 && by1 < ay2);
		return xOver && yOver;
	}
}
