class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use boolean arrays to track seen digits (1-9)
        // first index is the row/col/box number, second is the digit value
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                // Convert char digit to index (0-8)
                int num = board[r][c] - '1';
                int boxIndex = (r / 3) * 3 + (c / 3);

                // If the number has already been seen in this row, col, or box
                if (rows[r][num] || cols[c][num] || boxes[boxIndex][num]) {
                    return false;
                }

                // Mark the number as seen
                rows[r][num] = true;
                cols[c][num] = true;
                boxes[boxIndex][num] = true;
            }
        }

        return true;
    }
}