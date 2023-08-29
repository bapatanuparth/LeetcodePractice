package leetcode150daysGraph;

//An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
//
//You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
//
//To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
//
//Return the modified image after performing the flood fill.

public class FloodFill {

	public int[][] floodFill(int[][] image, int sr, int sc, int color) {
		if (image[sr][sc] == color) {
			return image;
		}
		floodFillHelper(image, sr, sc, color, image[sr][sc]);
		return image;

	}

	private void floodFillHelper(int[][] image, int sr, int sc, int color, int old) {
		if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != old) {
			return;
		}
		image[sr][sc] = color;

		// System.out.println("sr="+sr+"\tsc="+sc+"\timage="+Arrays.deepToString(image));

		floodFillHelper(image, sr - 1, sc, color, old);
		floodFillHelper(image, sr + 1, sc, color, old);
		floodFillHelper(image, sr, sc - 1, color, old);
		floodFillHelper(image, sr, sc + 1, color, old);
	}

}
