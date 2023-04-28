// N-Queen Problem
// Shivam
// 21CSU090

public class Practical9 {
    public static void solveNQueens(int n) {
        int[][] board = new int[n][n];

        if (solveNQueensUtil(board, 0)) {
            printBoard(board);
        } else {
            System.out.println("No solution exists");
        }
    }

    private static boolean solveNQueensUtil(int[][] board, int col) {
        if (col == board.length) {
            return true;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1;

                if (solveNQueensUtil(board, col + 1)) {
                    return true;
                }

                board[row][col] = 0; // backtrack
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solveNQueens(8);
    }
}