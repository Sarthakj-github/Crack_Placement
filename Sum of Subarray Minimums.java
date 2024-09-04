class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<int[]> S = new Stack();
        int s=0,c,ans=0,mod=1000000007;

        for(int a:arr){
            c=1;
            while(!S.isEmpty() && S.peek()[0]>=a){
                int[] p = S.pop();
                s-=(p[0]*p[1])%mod;
                c+=p[1];
            }
            S.push(new int[]{a,c});
            s+=(a*c)%mod;
            ans=(ans+s)%mod;
        }

        return ans;
    }
}
