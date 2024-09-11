class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, l = matrix[0][0], r = matrix[n - 1][n - 1], ans = 0;
        while (l <= r) {
            int m = (l + r) / 2, c = count_equi_less(m, n, matrix);
            if (c >= k) { ans = m; r = m - 1; } 
            else l = m + 1;
        }
        return ans;
    }

    int count_equi_less(int x, int n, int[][] matrix) {
        int ans = 0;
        for (int[] mat : matrix) {
            int l = 0, r = n - 1, a = -1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (mat[m] <= x) { a = m; l = m + 1; } 
                else r = m - 1;
            }
            ans += (a + 1);
        }
        return ans;
    }
}
