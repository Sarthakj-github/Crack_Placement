class Solution {
    public int longestCommonSubstr(String str1, String str2) {
        // code here
        int n1=str1.length(),n2=str2.length();
        int[][] L = new int[n1+1][n2+1];
        int ans = 0;
        
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    L[i][j] = L[i-1][j-1]+1;
                else{
                    L[i][j] = 0;
                }
                ans = Math.max(ans,L[i][j]);
                
            }
        }
        
        return ans;
    }
}
