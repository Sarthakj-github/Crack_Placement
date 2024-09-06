class Solution {
    public int maximizeCuts(int n, int x, int y, int z) {
        
        int[] dp = new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            int cutX = (i+x)<=n?dp[i + x]:Integer.MIN_VALUE;
            int cutY = (i+y)<=n?dp[i + y]:Integer.MIN_VALUE;
            int cutZ = (i+z)<=n?dp[i + z]:Integer.MIN_VALUE;
            dp[i] = Math.max(Math.max(cutX, cutY), cutZ) + 1;
        }
        return Math.max(dp[0],0);
    }
}
