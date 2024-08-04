class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        int[] ans = {-1,-1};
        for(int i: arr){
            if(i<=x && ans[0]<i)    ans[0]=i;
            if(i>=x && (ans[1]>i || ans[1]==-1))    ans[1]=i;
        }
        return ans;
    }
}
