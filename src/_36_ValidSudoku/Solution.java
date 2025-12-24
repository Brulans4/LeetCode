package _36_ValidSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		System.out.println(isValidSudoku(new char[][]{
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		}));
		System.out.println(isValidSudoku(new char[][]{
				{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		}));
	}

	public static boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			if (!isRowValid(board[i])) {
				return false;
			}
			if (!isColumnValid(board, i)) {
				return false;
			}
			if (i % 3 == 0 && !isSquarValid(board, i)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isRowValid(char[] row) {
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < row.length; i++) {
			char c = row[i];

			if (set.contains(c)) {
				return false;
			}

			if (c != '.') {
				set.add(c);
			}
		}
		return true;
	}

	private static boolean isColumnValid(char[][] board, int colmnLine) {
		Set<Character> set = new HashSet<>();

		for (int i = 0; i < board.length; i++) {
			char c = board[i][colmnLine];

			if (set.contains(c)) {
				return false;
			}

			if (c != '.') {
				set.add(c);
			}
		}
		return true;
	}

	private static boolean isSquarValid(char[][] board, int colmnLine) {
		for (int rowLine = 0; rowLine < 9; rowLine += 3) {
			Set<Character> set = new HashSet<>();

			for (int i = colmnLine; i < colmnLine + 3; i++) {
				for (int j = rowLine; j < rowLine + 3; j++) {
					char c = board[i][j];

					if (set.contains(c)) {
						return false;
					}

					if (c != '.') {
						set.add(c);
					}
				}
			}
		}
		return true;
	}
}

