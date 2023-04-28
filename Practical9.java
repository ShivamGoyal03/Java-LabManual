// N-Queen Problem
// Shivam
// 21CSU090

class NQueens {
    private int[][] board;
    private int size;

    public NQueens(int n) {
        board = new int[n][n];
        size = n;
    }

    public boolean solve() {
        return solve(0);
    }

    private boolean solve(int col) {
        if (col >= size) {
            return true;
        }

        for (int row = 0; row < size; row++) {
            if (isValid(row, col)) {
                board[row][col] = 1;
                if (solve(col + 1)) {
                    return true;
                }
                board[row][col] = 0;
            }
        }

        return false;
    }

    private boolean isValid(int row, int col) {
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

        for (int i = row, j = col; i < size && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public void printSolution() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Practical9{
    public static void main(String[] args) {
        NQueens nQueens = new NQueens(4);
        if (nQueens.solve()) {
            nQueens.printSolution();
        } else {
            System.out.println("No solution found");
        }
    }
}