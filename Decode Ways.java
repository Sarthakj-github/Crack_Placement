class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n]=1;
        for(int i=n-1;i>=0;i--){
            char c = s.charAt(i);
            if('0'<c && c<='9'){
                dp[i]+=dp[i+1];
                if(i!=(n-1))
                    if(c=='1' || (c=='2' && '0'<=s.charAt(i+1) && s.charAt(i+1)<'7'))
                        dp[i]+=dp[i+2];
            }
        }
        return dp[0];
    }
}
