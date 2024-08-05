class Solution {
    int m, n;
    char[][] board;
    String word;
    boolean[][] vis;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        m = board.length;
        n = board[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && trav(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean trav(int i, int j, int s) {
        if (s == word.length()) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || vis[i][j] || board[i][j] != word.charAt(s)) {
            return false;
        }

        vis[i][j] = true;
        int[][] L = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int p = 0; p < 4; p++) {
            int a = i + L[p][0], b = j + L[p][1];
            if (trav(a, b, s + 1)) {
                return true;
            }
        }
        vis[i][j] = false;
        return false;
    }
}
