class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Use standard 2D boolean arrays instead of sets or bitmasking
        // to keep the code straightforward and fast.
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val == '.') {
                    continue;
                }

                int num = val - '1'; // map '1'-'9' to index 0-8
                int boxIndex = (r / 3) * 3 + (c / 3);

                // Check if the number has already been seen in row, col, or box
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