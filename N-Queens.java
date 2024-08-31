class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        placeQueens(0, n, board, res);
        return res;
    }

    private void placeQueens(int row, int n, char[][] board, List<List<String>> res) {
        if (row == n) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(row, col, board)) {
                board[row][col] = 'Q';
                placeQueens(row + 1, n, board, res);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q' || (col - (row - i) >= 0 && board[i][col - (row - i)] == 'Q') || 
                (col + (row - i) < board.length && board[i][col + (row - i)] == 'Q'))
                return false;
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> result = new ArrayList<>();
        for (char[] row : board) result.add(new String(row));
        return result;
    }
}
