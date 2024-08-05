class Solution {
    static int[][] vis;
    static char[][] A;
    static int[][] L = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    static int n, m;

    static char[][] fill(int n, int m, char a[][]) {
        Solution.n = n;
        Solution.m = m;
        vis = new int[n][m];
        A = a;

        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O' && vis[i][0] == 0) {
                trav(i, 0);
            }
            if (a[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                trav(i, m - 1);
            }
        }
        for (int j = 1; j < m - 1; j++) {
            if (a[0][j] == 'O' && vis[0][j] == 0) {
                trav(0, j);
            }
            if (a[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                trav(n - 1, j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 'O' && vis[i][j] == 0) {
                    a[i][j] = 'X';
                }
            }
        }
        return a;
    }

    static void trav(int i, int j) {
        vis[i][j] = 1;
        for (int[] p : L) {
            int a = i + p[0];
            int b = j + p[1];
            if (0 <= a && a < n && 0 <= b && b < m && A[a][b] == 'O' && vis[a][b] == 0) {
                trav(a, b);
            }
        }
    }
}
