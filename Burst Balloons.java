class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // Create a new array with additional boundary values (1 at both ends)
        int[] extendedNums = new int[n + 2];
        extendedNums[0] = extendedNums[n + 1] = 1;

        // Copy the input array into the new array
        for (int i = 0; i < n; i++) {
            extendedNums[i + 1] = nums[i];
        }

        // Initialize a DP table
        int[][] dp = new int[n + 2][n + 2];

        // Fill the DP table in bottom-up manner
        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int ans = 0;
                // Find the best position to burst a balloon in the range [i, j]
                for (int k = i; k <= j; k++) {
                    ans = Math.max(ans, dp[i][k - 1] + dp[k + 1][j] + extendedNums[i - 1] * extendedNums[k] * extendedNums[j + 1]);
                }
                dp[i][j] = ans;
            }
        }

        // The answer is stored in dp[1][n]
        return dp[1][n];
    }
}
