public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        for (int _ = 0; _ < t; _++) {
            int n = sc.nextInt(); // Size of the array
            int[] arr = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            System.out.println(findMinDifference(arr, n, sum));
        }
        sc.close();
    }

    // Function to find the minimum difference between two subsets
    static int findMinDifference(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        
        // Initialize the dp array
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        int diff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                diff = Math.min(diff, sum - 2 * j);
            }
        }
        
        return diff;
    }
}
