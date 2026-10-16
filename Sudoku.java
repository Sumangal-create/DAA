public class Sudoku {

    static int[][] board = {
        {5, 3, 0, 0, 7, 0, 0, 0, 0},
        {6, 0, 0, 1, 9, 5, 0, 0, 0},
        {0, 9, 8, 0, 0, 0, 0, 6, 0},
        {8, 0, 0, 0, 6, 0, 0, 0, 3},
        {4, 0, 0, 8, 0, 3, 0, 0, 1},
        {7, 0, 0, 0, 2, 0, 0, 0, 6},
        {0, 6, 0, 0, 0, 0, 2, 8, 0},
        {0, 0, 0, 4, 1, 9, 0, 0, 5},
        {0, 0, 0, 0, 8, 0, 0, 7, 9}
    };

    public static boolean isSafe(int row, int col, int num) {

        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        int firstrow = (row / 3) * 3;
        int firstcolumn = (col / 3) * 3;

        // Check 3x3 box
        for (int i = firstrow; i < firstrow + 3; i++) {
            for (int j = firstcolumn; j < firstcolumn + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solve() {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == 0) {

                    // Try numbers from 1 to 9
                    for (int num = 1; num <= 9; num++) {

                        if (isSafe(row, col, num)) {

                            board[row][col] = num;

                            if (solve()) {
                                return true;
                            }

                            // Backtracking
                            board[row][col] = 0;
                        }
                    }

                    // No number fits in this cell
                    return false;
                }
            }
        }

        // No empty cells remain
        return true;
    }

    public static void display() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Original Sudoku:");
        display();

        if (solve()) {
            System.out.println("\nSolved Sudoku:");
            display();
        } else {
            System.out.println("There exists no solution for this Sudoku!");
        }
    }
}
