package leetcodeBacktrack;

//Write a program to solve a Sudoku puzzle by filling the empty cells.
//
//A sudoku solution must satisfy all of the following rules:
//
//Each of the digits 1-9 must occur exactly once in each row.
//Each of the digits 1-9 must occur exactly once in each column.
//Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
//The '.' character indicates empty cells.

public class SudokuSolver {

	// create 3 new 2d arrays to mark the presence of the digits in the given row,
	// column, and box.
	// each inner box of 3X3 is assigned an index which makes the row and the number
	// makes the column
	//
	// follow simple backtrack-->
	// before placing every number, check whether it is valid to be placed
	// if yes, place the number and go to next row/col
	// remove the number if problem not solved by previous number

	int n = 3;
	int N = n * n;

	int rows[][] = new int[N][N + 1]; // mark the presence of each number in the given row
	int columns[][] = new int[N][N + 1]; // mark the presence of each number in the column
	int boxes[][] = new int[N][N + 1]; // mark the presence of each number in the box

	char[][] board;

	boolean solved = false;

	boolean couldPlace(int d, int row, int col) {
		// calculate the index of the box in which the number is being put
		int idx = (row / n) * n + col / n;

		// check if current number is not present in same row, col or box
		return (columns[col][d] == 0 && rows[row][d] == 0 && boxes[idx][d] == 0);

	}

	void placeNumber(int d, int row, int col) {
		// calculate the index of the box in which the number is being put
		int idx = (row / n) * n + col / n;

		columns[col][d]++;
		rows[row][d]++;
		boxes[idx][d]++;
		board[row][col] = (char) (d + '0');
	}

	void removeNumber(int d, int row, int col) {
		// calculate the index of the box in which the number is being put
		int idx = (row / n) * n + col / n;

		columns[col][d]--;
		rows[row][d]--;
		boxes[idx][d]--;
		board[row][col] = '.';
	}

	void backtrack(int row, int col) {

		// this is the case where we have reached out of the box, i.e. sudoku is solved
		if (col == 0 && row == N) {
			solved = true;
			return;
		}

		// if there is empty spot
		if (board[row][col] == '.') {
			for (int i = 1; i < 10; i++) {
				// check if it is safe to place current number in given row and col and box
				if (couldPlace(i, row, col)) {
					// place number
					placeNumber(i, row, col);
					// backtrack for next row or column
					if (col == N - 1)
						backtrack(row + 1, 0);
					else
						backtrack(row, col + 1);
					// if we reach here and problem is not solved, it means earlier placed number
					// needs to be changed
					if (!solved)
						removeNumber(i, row, col);
				}
			}
		} else {
			// go to next row if we have arrived at last column
			if (col == N - 1)
				backtrack(row + 1, 0);
			// else go to next column if in same row.
			else
				backtrack(row, col + 1);
		}

	}

	// idea is to represent the whole board in terms of 3 arrays
	// mark each number in row, column and the individual box
	public void solveSudoku(char[][] board) {

		this.board = board;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				char num = board[i][j];
				if (num != '.') {
					int d = Character.getNumericValue(num);
					placeNumber(d, i, j);
				}
			}
		}
		backtrack(0, 0);
	}

}
