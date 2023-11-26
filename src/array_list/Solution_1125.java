package array_list;

public class Solution_1125 {

    // 37. Sudoku Solver
    // Write a program to solve a Sudoku puzzle by filling the empty cells.
    // A sudoku solution must satisfy all of the following rules:
    // Each of the digits 1-9 must occur exactly once in each row.
    // Each of the digits 1-9 must occur exactly once in each column.
    // Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    // The '.' character indicates empty cells.
    // board.length == 9
    // board[i].length == 9
    // board[i][j] is a digit or '.'.
    // It is guaranteed that the input board has only one solution.
    public static final int SUDOKU_SIZE = 9;
    private boolean isValidValueToColumn(char[][] board, char value, int column) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (board[i][column] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidValueToRow(char[][] board, char value, int row) {
        for (int i = 0; i < SUDOKU_SIZE; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidValueToBox(char[][] board, char value, int row, int column) {
        int startRowIndex = (row / 3) * 3;
        int startColumnIndex = (column / 3) * 3;

        for (int c = startColumnIndex; c < startColumnIndex + 3; c++) {
            for (int r = startRowIndex; r < startRowIndex + 3; r++) {
                if(row == r && column == c) {
                    continue;
                }
                if (board[r][c] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkAllCondition(char[][] board, char value, int row, int column) {
        return isValidValueToBox(board,value,row,column)
                && isValidValueToRow(board,value,row)
                && isValidValueToColumn(board, value, column);
    }
    public void solution37(char[][] board) {
        checkBoard(board);
    }
    private boolean checkBoard(char[][] board) {
        for(int row=0; row<SUDOKU_SIZE; row++) {
            for(int col=0; col<SUDOKU_SIZE; col++) {
                if(board[row][col] == '.') {
                    for(int valInt=1; valInt<=SUDOKU_SIZE; valInt++) {
                        char val = (char)((char) valInt + '0');

                        if(checkAllCondition(board,val,row,col)) {
                            board[row][col] = val;

                            if(checkBoard(board)) {
                                return true;
                            } else {
                                board[row][col] = '.';
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // 36. Valid Sudoku
    // Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
    // Each row must contain the digits 1-9 without repetition.
    // Each column must contain the digits 1-9 without repetition.
    // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
    // Note:
    // A Sudoku board (partially filled) could be valid but is not necessarily solvable.
    // Only the filled cells need to be validated according to the mentioned rules.

    public static final int SUDOKU_SIZE_36 = 9;
    public boolean Solution36(char[][] board) {
        for(int i=0; i<SUDOKU_SIZE_36; i++) {
            for(int j=0; j<SUDOKU_SIZE_36; j++) {
                if(board[i][j] != '.') {
                    if(!checkAllCondition36(board,board[i][j], i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidValueToColumn36(char[][] board, char value, int row, int column) {
        for (int i = 0; i < SUDOKU_SIZE_36; i++) {
            if(row == i) {
                continue;
            }
            if (board[i][column] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidValueToRow36(char[][] board, char value, int row, int column) {
        for (int i = 0; i < SUDOKU_SIZE_36; i++) {
            if(column == i) {
                continue;
            }
            if (board[row][i] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidValueToBox36(char[][] board, char value, int row, int column) {
        int startRowIndex = (row / 3) * 3;
        int startColumnIndex = (column / 3) * 3;

        for (int c = startColumnIndex; c < startColumnIndex + 3; c++) {
            for (int r = startRowIndex; r < startRowIndex + 3; r++) {
                if(row == r && column == c) {
                    continue;
                }
                if (board[r][c] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkAllCondition36(char[][] board, char value, int row, int column) {
        return isValidValueToBox36(board,value,row,column)
                && isValidValueToRow36(board,value,row,column)
                && isValidValueToColumn36(board, value, row, column);
    }
}
