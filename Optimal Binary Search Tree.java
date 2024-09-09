class Solution {
    static int[][][] dp;
    static int optimalSearchTree(int[] keys, int[] freq, int n) {
        dp = new int[n][n][n];
        return obst(0, n - 1, 1, freq);
    }

    static int obst(int i, int j, int l, int[] freq) {
        if (i > j) return 0;
        if (dp[l-1][i][j] != 0) return dp[l-1][i][j];

        int minCost = Integer.MAX_VALUE;
        
        for (int m = i; m <= j; m++) {
            int cost = obst(i, m - 1, l + 1, freq) + freq[m] * l + obst(m + 1, j, l + 1, freq);
            minCost = Math.min(minCost, cost);
        }

        return dp[l-1][i][j] = minCost;
    }
}
